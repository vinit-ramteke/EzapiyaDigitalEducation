package com.ezapiya.ezapiyadigitaleducation;
import com.ezapiya.ezapiyadigitaleducation.Model.createUser;
import com.ezapiya.ezapiyadigitaleducation.Model.user;
import com.ezapiya.ezapiyadigitaleducation.apiInterface.class_Interface;


import com.ezapiya.ezapiyadigitaleducation.Model.class_Model;
import com.ezapiya.ezapiyadigitaleducation.Model.messageModel;
import com.ezapiya.ezapiyadigitaleducation.Adopter.class_Adapter;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.app.Fragment;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.ezapiya.ezapiyadigitaleducation.Adopter.userAdapter;
import com.ezapiya.ezapiyadigitaleducation.apiInterface.createUserInterface;
import com.ezapiya.ezapiyadigitaleducation.Model.messageModel;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import  com.ezapiya.ezapiyadigitaleducation.Model.createUser;
import  com.ezapiya.ezapiyadigitaleducation.Model.class_Model;
import  com.ezapiya.ezapiyadigitaleducation.apiInterface.class_Interface;

import java.util.List;

public class class_  extends Fragment {
    View view;
    RecyclerView recyclerView;
    ImageButton btnadd;
    TextView txterror;
    class_Interface Class_Interface;
    EditText txtclassName;
    ProgressDialog progressBar;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.class_layout, container, false);
        btnadd =(ImageButton)view.findViewById(R.id.btnadd);
        txterror=(TextView)view.findViewById(R.id.txterror);
        txtclassName =(EditText)view.findViewById(R.id.txtclassName);
        Class_Interface=RetrofitInstance.getRetrofit().create(class_Interface.class);


        getActivity().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);



        Class_Interface=RetrofitInstance.getRetrofit().create(class_Interface.class);

        progressBar = new ProgressDialog(getContext());
        progressBar.setCancelable(false);
        progressBar.setMessage("Loding Data...");
        progressBar.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        progressBar.setProgress(0);
        progressBar.setMax(100);
        progressBar.show();

        // Call<List<loginPojo>> call = LoginInterface.createPost1("login",txtusername.getText().toString(),txtpassword.getText().toString());
        Call<List<class_Model>> callx = Class_Interface.getClass_List(Globle_data.loginData.getLoginkey(),"getAllClass");
        callx.enqueue(new Callback<List<class_Model>>() {
            @Override
            public void onResponse(Call<List<class_Model>> call, Response<List<class_Model>> response) {
                progressBar.dismiss();
                Globle_data.Class_list = response.body();
                class_Model[] array = new class_Model[Globle_data.Class_list.size()];
                Globle_data.Class_list.toArray(array);

                recyclerView = (RecyclerView) view.findViewById(R.id.class_RecyclerView);


                //userAdapter adapter = new userAdapter(array,"Block User",getContext(),getActivity());
                class_Adapter adapter = new class_Adapter(array,getContext(),getActivity());
                recyclerView.setHasFixedSize(true);
                recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<class_Model>> call, Throwable t) {
                progressBar.dismiss();
                txterror.setText(t.getMessage().toString());
            }
        });







        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String lk=Globle_data.loginData.getLoginkey();
                String command ="addClass";
                String class_name =txtclassName.getText().toString();
                Call<messageModel> call = Class_Interface.addclass_(lk,"addClass",txtclassName.getText().toString());
                call.enqueue(new Callback<messageModel>() {
                    @Override
                    public void onResponse(Call<messageModel> call, Response<messageModel> response) {
                        messageModel MessageModel= response.body();
                        txterror.setText("Class Add");
                    }

                    @Override
                    public void onFailure(Call<messageModel> call, Throwable t) {
                        txterror.setText(t.getMessage().toString());
                    }
                });

            }
        });


        return view;
    }
}