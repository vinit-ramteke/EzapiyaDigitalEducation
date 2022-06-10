package com.ezapiya.ezapiyadigitaleducation;

import android.app.AlertDialog;
import android.app.Fragment;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;

import com.ezapiya.ezapiyadigitaleducation.Model.loginPojo;
import com.ezapiya.ezapiyadigitaleducation.Model.createUser;
import com.ezapiya.ezapiyadigitaleducation.Model.user;
import com.ezapiya.ezapiyadigitaleducation.apiInterface.createUserInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class changePermission  extends Fragment {
    View view;
    createUserInterface CreateUserInterface;
    ProgressDialog progressBar;
    Switch swtaddNewUser,swtblockUser,swtremoveUser,swtchangePermission ;
    Button btnchangepermission;
    TextView txterror;
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.changepermissionlayout, container, false);

        getActivity().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);

        CreateUserInterface=RetrofitInstance.getRetrofit().create(createUserInterface.class);

        swtaddNewUser =(Switch)view.findViewById(R.id.swtaddNewUser);
        swtblockUser=(Switch)view.findViewById(R.id.swtblockUser);
        swtremoveUser=(Switch)view.findViewById(R.id.swtremoveUser);
        swtchangePermission=(Switch)view.findViewById(R.id.swtchangePermission);
        btnchangepermission =(Button)view.findViewById(R.id.btnchangepermission);
        txterror =(TextView)view.findViewById(R.id.txterror);

        progressBar = new ProgressDialog(getContext());
        progressBar.setCancelable(false);
        progressBar.setMessage("Loding User Permission");
        progressBar.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        progressBar.setProgress(0);
        progressBar.setMax(100);
        progressBar.show();
        String xx=Globle_data.uid_for_change_parmission;
        Call<loginPojo> call = CreateUserInterface.getUser(Globle_data.loginData.getLoginkey(),"getUserPermission",Globle_data.uid_for_change_parmission);
        call.enqueue(new Callback<loginPojo>() {
            @Override
            public void onResponse(Call<loginPojo> call, Response<loginPojo> response) {
                loginPojo user_to_change_permission=response.body();
                if(user_to_change_permission.getAddUser().compareTo("yes")==0)
                    swtaddNewUser.setChecked(true);
                else
                    swtaddNewUser.setChecked(false);
                if(user_to_change_permission.getBlockUser().compareTo("yes")==0)
                    swtblockUser.setChecked(true);
                else
                    swtblockUser.setChecked(false);
                if(user_to_change_permission.getRemoveUser().compareTo("yes")==0)
                    swtremoveUser.setChecked(true);
                else
                    swtremoveUser.setChecked(false);
                if(user_to_change_permission.getUserPermission().compareTo("yes")==0)
                    swtchangePermission.setChecked(true);
                else
                    swtchangePermission.setChecked(false);
                progressBar.dismiss();
            }

            @Override
            public void onFailure(Call<loginPojo> call, Throwable t) {

            }
        });

        btnchangepermission.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                builder.setTitle(R.string.app_name);
                builder.setMessage("Do you want to Change Permission ?");
                //builder.setIcon(R.drawable.ic_launcher);
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        String addNewUser="",removeUser="",changePermission="",blockUser="";
                        if(swtaddNewUser.isChecked()==true)
                            addNewUser="yes";
                        else
                            addNewUser="no";
                        if(swtremoveUser.isChecked()==true)
                            removeUser="yes";
                        else
                            removeUser="no";
                        if(swtchangePermission.isChecked()==true)
                            changePermission="yes";
                        else
                            changePermission="no";
                        if(swtblockUser.isChecked()==true)
                            blockUser="yes";
                        else
                            blockUser="no";
                        Call<createUser> call = CreateUserInterface.setUserParmission(Globle_data.loginData.getLoginkey(),"setUserPermission",Globle_data.uid_for_change_parmission,addNewUser,removeUser,changePermission,blockUser);
                        call.enqueue(new Callback<createUser>() {
                            @Override
                            public void onResponse(Call<createUser> call, Response<createUser> response) {
                              createUser cu = response.body();
                              if(cu.getMessage().compareTo("Parmission Changed")==0)
                              {
                                  txterror.setText("Permission Changed");
                              }
                            }

                            @Override
                            public void onFailure(Call<createUser> call, Throwable t) {

                                txterror.setText(t.getMessage());
                            }
                        });

                    }
                });
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                    }
                });
                    AlertDialog alert = builder.create();
                    alert.show();
            }
        });
        return view;
    }
}