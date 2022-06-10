package com.ezapiya.ezapiyadigitaleducation;

import com.ezapiya.ezapiyadigitaleducation.Model.loginPojo;
import com.ezapiya.ezapiyadigitaleducation.Model.user;
import  com.ezapiya.ezapiyadigitaleducation.apiInterface.loginInterface;


import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button btnlogin;
    EditText txtusername,txtpassword;
    TextView txterror;
    loginInterface LoginInterface;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnlogin= findViewById(R.id.btnlogin);

        txtusername= findViewById(R.id.txtchapterName);
        txtpassword= findViewById(R.id.txtpassword);
        txterror= findViewById(R.id.txterror);





        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(txtusername.getText().toString().compareTo("")==0)
                {
                    txterror.setText("* Please Enter Username");
                }
                else {
                    if(txtpassword.getText().toString().compareTo("") == 0)
                    {
                        txterror.setText("* Please Enter Password");
                    }
                    else
                        {

                            LoginInterface=RetrofitInstance.getRetrofit().create(loginInterface.class);


                           // Call<List<loginPojo>> call = LoginInterface.createPost(lp);

                            Call<List<loginPojo>> call = LoginInterface.createPost1("login",txtusername.getText().toString(),txtpassword.getText().toString());
                            call.enqueue(new Callback<List<loginPojo>>() {
                                @Override
                                public void onResponse(Call<List<loginPojo>> call, Response<List<loginPojo>> response) {
                                    if(response.body().size()>0)
                                    {
                                        Globle_data.loginData = new loginPojo();
                                        List<loginPojo> postlist = response.body();
                                        loginPojo[] array = new loginPojo[postlist.size()];
                                        postlist.toArray(array);
                                        int code =Integer.valueOf( array[0].getCode());
                                        if(code==1)
                                        {
                                            Globle_data.loginData.setLoginkey(array[0].getLoginkey());
                                            Globle_data.loginData.setCode(array[0].getCode());
                                            Globle_data.loginData.setMessage(array[0].getMessage());
                                            Globle_data.loginData.setUserID(array[0].getUserID());
                                            Globle_data.loginData.setAddUser(array[0].getAddUser());
                                            Globle_data.loginData.setBlockUser(array[0].getBlockUser());
                                            Globle_data.loginData.setRemoveUser(array[0].getRemoveUser());
                                            Globle_data.loginData.setUserPermission(array[0].getUserPermission());
                                            txterror.setText("");






                                            Intent homeactivity = new Intent(MainActivity.this,HomeActivity.class);
                                            startActivity(homeactivity);
                                            finish();
                                        }
                                        if(code==2)
                                        {
                                            txterror.setText("* Invalid Username Or Password");
                                        }
                                        if(code==3)
                                        {
                                            txterror.setText("* Data Not Complit");
                                        }
                                        //Toast.makeText(MainActivity.this,"data found",Toast.LENGTH_LONG).show();
                                    }
                                    else{
                                        txterror.setText("* Invalid Username Or Password");
                                    }
                                }

                                @Override
                                public void onFailure(Call<List<loginPojo>> call, Throwable t) {

                                }
                            });


                    }
                }
            }
        });

    }
}