package com.ezapiya.ezapiyadigitaleducation;

import com.ezapiya.ezapiyadigitaleducation.Model.createUser;
import  com.ezapiya.ezapiyadigitaleducation.apiInterface.createUserInterface;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.app.Fragment;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class adduser extends Fragment {
    View view;
    Spinner spnuserType;
    EditText txtusername;
    EditText txtpassword;
    EditText txtpassword1;
    Button btncreateUser;
    TextView txterror;
    createUserInterface CreateUserInterface;
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.adduserlayout, container, false);

        getActivity().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);


        List<String> spinnerArray =  new ArrayList<String>();
        spinnerArray.add("Teaching");
        spinnerArray.add("Non Teaching");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                view.getContext(), android.R.layout.simple_spinner_item, spinnerArray);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnuserType = (Spinner) view.findViewById(R.id.spnuserType);
        txtusername=(EditText) view.findViewById(R.id.txtchapterName);
        txtpassword=(EditText) view.findViewById(R.id.txtpassword);
        txtpassword1=(EditText) view.findViewById(R.id.txtpassword1);
        btncreateUser= (Button) view.findViewById(R.id.btnchangePasswrod);
        txterror= (TextView) view.findViewById(R.id.txterror);


        spnuserType.setAdapter(adapter);

        btncreateUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(txtusername.getText().toString().compareTo("")==0|| txtusername.getText().toString().isEmpty())
                {
                    txterror.setText("Enter User Name");
                    txtusername.requestFocus();
                }else if(txtpassword.getText().toString().compareTo("")==0||txtpassword.getText().toString().isEmpty())
                {
                    txterror.setText("Enter Passwored");
                    txtpassword.requestFocus();
                }else if(txtpassword1.getText().toString().compareTo("")==0||txtpassword1.getText().toString().isEmpty())
                {
                    txterror.setText("Enter Passwored");
                    txtpassword1.requestFocus();
                }else if(txtpassword.getText().toString().compareTo(txtpassword1.getText().toString())!=0)
                {
                    txterror.setText("Both Password Must Be Same");
                    txtpassword1.requestFocus();
                }else
                {

                    AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                    builder.setTitle(R.string.app_name);
                    builder.setMessage("Do you want to Create new user ?");
                    //builder.setIcon(R.drawable.ic_launcher);
                    builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            dialog.dismiss();
                            CreateUserInterface=RetrofitInstance.getRetrofit().create(createUserInterface.class);

                            Call<createUser> call = CreateUserInterface.createUser(Globle_data.loginData.getLoginkey(),"CreateUser",txtusername.getText().toString(),txtpassword.getText().toString(),spnuserType.getSelectedItem().toString());
                            call.enqueue(new Callback<createUser>() {
                                @Override
                                public void onResponse(Call<createUser> call, Response<createUser> response) {

                                    createUser createUserlist = response.body();
                                    //createUser[] array = new createUser[createUserlist.size()];
                                    //createUserlist.toArray(array);
                                    //int code =Integer.valueOf( array[0].getCode());
                                    int code=Integer.valueOf(createUserlist.getCode());
                                    if(code==1)
                                    {
                                        Toast.makeText(getActivity(),"Create user",Toast.LENGTH_LONG).show();
                                        txterror.setText("User Create");
                                    }
                                    if(code==2)
                                    {
                                        Toast.makeText(getActivity(),"User Exist",Toast.LENGTH_LONG).show();
                                        txterror.setText("User Not Create");
                                    }
                                    if(code==3)
                                    {
                                        Toast.makeText(getActivity(),"User Exist",Toast.LENGTH_LONG).show();
                                        txterror.setText("User Exist");
                                    }
                                    if(code==4)
                                    {
                                        Toast.makeText(getActivity(),"Data Not Complit",Toast.LENGTH_LONG).show();
                                        txterror.setText("Data Not Complit");
                                    }
                                }

                                @Override
                                public void onFailure(Call<createUser> call, Throwable t) {
                                    String tt =t.getMessage();
                                    Toast.makeText(getActivity(),t.getMessage(),Toast.LENGTH_LONG).show();
                                }
                            });

                        }
                    });
                    builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            dialog.dismiss();
                        }
                    });
                    AlertDialog alert = builder.create();
                    alert.show();



                    //call.enqueue(new Callback<List<loginPojo>>() {



                }
            }
        });


        return view;
    }
}
