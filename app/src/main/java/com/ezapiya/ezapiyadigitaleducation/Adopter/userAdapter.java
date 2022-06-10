package com.ezapiya.ezapiyadigitaleducation.Adopter;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.ezapiya.ezapiyadigitaleducation.Globle_data;
import com.ezapiya.ezapiyadigitaleducation.Model.createUser;
import com.ezapiya.ezapiyadigitaleducation.Model.user;
import com.ezapiya.ezapiyadigitaleducation.R;
import com.ezapiya.ezapiyadigitaleducation.RetrofitInstance;
import com.ezapiya.ezapiyadigitaleducation.apiInterface.createUserInterface;
import com.ezapiya.ezapiyadigitaleducation.changePermission;

import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class userAdapter extends RecyclerView.Adapter<userAdapter.ViewHolder>{
    private user[] listdata;
    private String command="";
    private Context context;
    private Activity activity;

    public userAdapter(user[] listdata, String command, Context context, Activity activity) {
        this.listdata = listdata;
        this.command= command;
        this.context=context;
        this.activity=activity;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem= layoutInflater.inflate(R.layout.userlistlayout, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final user myListData = listdata[position];
        holder.txtusername.setText(listdata[position].getuserName());
        holder.btnAction.setText(command);
        holder.btnAction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(command.compareTo("Change Permission")!=0) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(context);
                    builder.setTitle(R.string.app_name);
                    builder.setMessage("Do you want to " + command + " ?");
                    //builder.setIcon(R.drawable.ic_launcher);
                    builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            dialog.dismiss();
                            //Toast.makeText(view.getContext(),String.valueOf( myListData.getuserId()),Toast.LENGTH_LONG).show();
                            ProgressDialog progressBar;
                            progressBar = new ProgressDialog(context);
                            progressBar.setCancelable(false);
                            progressBar.setMessage("Loding Data...");
                            progressBar.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                            progressBar.setProgress(0);
                            progressBar.setMax(100);
                            progressBar.show();
                            createUserInterface CreateUserInterface;
                            CreateUserInterface = RetrofitInstance.getRetrofit().create(createUserInterface.class);
                            if (command.compareTo("Remove User") == 0) {

                                Call<createUser> call = CreateUserInterface.blockRemoveUser(Globle_data.loginData.getLoginkey(), "removeUser", String.valueOf(myListData.getuserId()));
                                call.enqueue(new Callback<createUser>() {
                                    @Override
                                    public void onResponse(Call<createUser> call, Response<createUser> response) {
                                        createUser createUserlist = response.body();
                                        int code = Integer.valueOf(createUserlist.getCode());
                                        if (code == 6) {
                                            progressBar.dismiss();
                                            Toast.makeText(view.getContext(), "User Remove", Toast.LENGTH_LONG).show();
                                        }
                                    }

                                    @Override
                                    public void onFailure(Call<createUser> call, Throwable t) {
                                        progressBar.dismiss();
                                    }
                                });

                            }
                            if (command.compareTo("Block User") == 0) {

                                Call<createUser> call = CreateUserInterface.blockRemoveUser(Globle_data.loginData.getLoginkey(), "blockUser", String.valueOf(myListData.getuserId()));
                                call.enqueue(new Callback<createUser>() {
                                    @Override
                                    public void onResponse(Call<createUser> call, Response<createUser> response) {
                                        createUser createUserlist = response.body();
                                        int code = Integer.valueOf(createUserlist.getCode());
                                        if (code == 5) {
                                            progressBar.dismiss();
                                            Toast.makeText(view.getContext(), "User Block", Toast.LENGTH_LONG).show();
                                        }
                                    }

                                    @Override
                                    public void onFailure(Call<createUser> call, Throwable t) {
                                        Toast.makeText(view.getContext(), t.getMessage().toString(), Toast.LENGTH_LONG).show();
                                        progressBar.dismiss();
                                    }
                                });
                            }
                            if (command.compareTo("Unblock User") == 0) {
                                Call<createUser> call = CreateUserInterface.blockRemoveUser(Globle_data.loginData.getLoginkey(), "unblockUser", String.valueOf(myListData.getuserId()));
                                call.enqueue(new Callback<createUser>() {
                                    @Override
                                    public void onResponse(Call<createUser> call, Response<createUser> response) {
                                        createUser createUserlist = response.body();
                                        int code = Integer.valueOf(createUserlist.getCode());
                                        if (code == 5) {
                                            progressBar.dismiss();
                                            Toast.makeText(view.getContext(), "User Block", Toast.LENGTH_LONG).show();
                                        }
                                    }

                                    @Override
                                    public void onFailure(Call<createUser> call, Throwable t) {
                                        Toast.makeText(view.getContext(), t.getMessage().toString(), Toast.LENGTH_LONG).show();
                                        progressBar.dismiss();
                                    }
                                });
                            }

//                        if(command.compareTo("Change Permission")==0)
//                        {
//                            Globle_data.uid_for_change_parmission=String.valueOf( myListData.getuserId());
//                            progressBar.dismiss();
//                            changePermission homeFrag=new changePermission();
//                            FragmentManager fragmentManager=activity.getFragmentManager();
//                            FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
//                            fragmentTransaction.replace(R.id.frameLayout,homeFrag,"tag");
//                            fragmentTransaction.addToBackStack(null);
//                            fragmentTransaction.commit();
//                        }
                        }
                    });
                    builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            dialog.dismiss();
                        }
                    });
                    AlertDialog alert = builder.create();
                    alert.show();
                }
                if(command.compareTo("Change Permission")==0)
                {
                    Globle_data.uid_for_change_parmission=String.valueOf( myListData.getuserId());
                    changePermission homeFrag=new changePermission();
                    FragmentManager fragmentManager=activity.getFragmentManager();
                    FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.frameLayout,homeFrag,"tag");
                    fragmentTransaction.addToBackStack(null);
                    fragmentTransaction.commit();
                }



            }
        });
    }


    @Override
    public int getItemCount() {
        return listdata.length;
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageView;
        public TextView txtusername;
        public Button btnAction;
        public ViewHolder(View itemView) {
            super(itemView);
            this.txtusername = (TextView) itemView.findViewById(R.id.txtchapterName);
            this.btnAction =(Button) itemView.findViewById(R.id.btnAction);
            //relativeLayout = (RelativeLayout)itemView.findViewById(R.id.relativeLayout);
        }
    }
}
