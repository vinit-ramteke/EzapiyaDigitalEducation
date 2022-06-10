package com.ezapiya.ezapiyadigitaleducation;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.app.Fragment;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.ezapiya.ezapiyadigitaleducation.Model.createUser;
import com.ezapiya.ezapiyadigitaleducation.apiInterface.createUserInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class changepassword  extends Fragment {
    View view;
    EditText txtpassword,txtpassword1;
    TextView txterror;
    Button btnchangePasswrod;
    createUserInterface CreateUserInterface;
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.changepasswordlayout, container, false);
        getActivity().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
        btnchangePasswrod =(Button) view.findViewById(R.id.btnchangePasswrod);
        txtpassword=(EditText) view.findViewById(R.id.txtpassword);
        txtpassword1=(EditText) view.findViewById(R.id.txtpassword1);
        txterror=(TextView) view.findViewById(R.id.txterror);
        CreateUserInterface=RetrofitInstance.getRetrofit().create(createUserInterface.class);

        btnchangePasswrod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(txtpassword.getText().toString().compareTo(txtpassword1.getText().toString())==0) {
                    Call<createUser> call = CreateUserInterface.changePassword(Globle_data.loginData.getLoginkey(), "changePassword", Globle_data.loginData.getUserID(), txtpassword.getText().toString());
                    call.enqueue(new Callback<createUser>() {
                        @Override
                        public void onResponse(Call<createUser> call, Response<createUser> response) {
                            createUser cu = new createUser();
                            cu= response.body();
                            if(cu.getMessage().compareTo("Password Changed")==0)
                            {
                                txterror.setText("Password Changed ");
                            }
                            else {
                                txterror.setText("Password Not Changed ");
                            }
                        }

                        @Override
                        public void onFailure(Call<createUser> call, Throwable t) {

                            txterror.setText(t.getMessage());
                        }
                    });
                }else
                {
                    txterror.setText("Both Passwrod Must be same");
                }
            }
        });

        return view;
    }
}