package com.ezapiya.ezapiyadigitaleducation.Adopter;

import com.ezapiya.ezapiyadigitaleducation.Globle_data;
import com.ezapiya.ezapiyadigitaleducation.Model.class_Model;
import com.ezapiya.ezapiyadigitaleducation.R;
import com.ezapiya.ezapiyadigitaleducation.RetrofitInstance;
import com.ezapiya.ezapiyadigitaleducation.apiInterface.class_Interface;
import com.ezapiya.ezapiyadigitaleducation.Model.messageModel;


import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class class_Adapter extends RecyclerView.Adapter<class_Adapter.ViewHolder>{
    private class_Model[] listdata;
    private Context context;
    private Activity activity;
    private class_Interface Class_Interface;

    public class_Adapter(class_Model[] listdata,Context context, Activity activity) {
        this.listdata = listdata;
        this.context=context;
        this.activity=activity;
        Class_Interface= RetrofitInstance.getRetrofit().create(class_Interface.class);
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem= layoutInflater.inflate(R.layout.classrecyclelayout, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final class_Model myListData = listdata[position];
        holder.txtclassName.setText(myListData.getClassName());
        holder.btnedit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //String id= String.valueOf(myListData.getId() );
                //Toast.makeText(activity,"Edit this "+id +"ID",Toast.LENGTH_LONG).show();
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle("Change Class Name");
                final EditText input = new EditText(context);
                // Specify the type of input expected; this, for example, sets the input as a password, and will mask the text
                input.setInputType(InputType.TYPE_CLASS_TEXT );
                input.setText(myListData.getClassName());
                builder.setView(input);

                // Set up the buttons
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //txterror.setText( input.getText().toString());
                        String classID=myListData.getId();
                        String className= input.getText().toString();
                        Call<messageModel> call = Class_Interface.editclass_(Globle_data.loginData.getLoginkey(),"editClass",classID,className);
                        call.enqueue(new Callback<messageModel>() {
                            @Override
                            public void onResponse(Call<messageModel> call, Response<messageModel> response) {
                                Toast.makeText(activity,"Class Edit",Toast.LENGTH_LONG).show();
                            }

                            @Override
                            public void onFailure(Call<messageModel> call, Throwable t) {
                                Toast.makeText(activity,t.getMessage(),Toast.LENGTH_LONG).show();
                            }
                        });



                    }
                });
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });

                builder.show();
            }
        });
        holder.btndelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //String id= String.valueOf(myListData.getId() );
                //Toast.makeText(activity,"Delete this "+id +"ID",Toast.LENGTH_LONG).show();

                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle("Remove This Class");
                final EditText input = new EditText(context);

                // Specify the type of input expected; this, for example, sets the input as a password, and will mask the text
                input.setInputType(InputType.TYPE_CLASS_TEXT );
                input.setText(myListData.getClassName());
                input.setEnabled(false);
                builder.setView(input);



                // Set up the buttons
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //txterror.setText( input.getText().toString());
                        Call<messageModel> call = Class_Interface.removeclass_(Globle_data.loginData.getLoginkey(),"removeClass",myListData.getId());
                        call.enqueue(new Callback<messageModel>() {
                            @Override
                            public void onResponse(Call<messageModel> call, Response<messageModel> response) {
                                Toast.makeText(activity,"Class Remove",Toast.LENGTH_LONG).show();
                            }

                            @Override
                            public void onFailure(Call<messageModel> call, Throwable t) {
                                Toast.makeText(activity,t.getMessage(),Toast.LENGTH_LONG).show();
                            }
                        });

                    }
                });
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });

                builder.show();
            }
        });

    }


    @Override
    public int getItemCount() {
        return listdata.length;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView txtclassName;
        public ImageButton btnedit,btndelete;
        public ViewHolder(View itemView) {
            super(itemView);
            this.txtclassName =(TextView) itemView.findViewById(R.id.txtchapterName);
            this.btnedit =(ImageButton) itemView.findViewById(R.id.btnedit);
            this.btndelete =(ImageButton) itemView.findViewById(R.id.btndelete);


        }
    }
}