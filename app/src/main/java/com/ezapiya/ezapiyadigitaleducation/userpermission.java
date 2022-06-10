package com.ezapiya.ezapiyadigitaleducation;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.app.Fragment;
import android.view.WindowManager;
import android.widget.Toast;

import com.ezapiya.ezapiyadigitaleducation.Adopter.userAdapter;
import com.ezapiya.ezapiyadigitaleducation.Model.loginPojo;
import com.ezapiya.ezapiyadigitaleducation.Model.user;
import com.ezapiya.ezapiyadigitaleducation.apiInterface.createUserInterface;

import java.util.List;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class userpermission  extends Fragment {
    View view;
    RecyclerView recyclerView;
    createUserInterface CreateUserInterface;
    ProgressDialog progressBar;
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.userpermissionlayout, container, false);

        getActivity().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);

        CreateUserInterface=RetrofitInstance.getRetrofit().create(createUserInterface.class);

        progressBar = new ProgressDialog(getContext());
        progressBar.setCancelable(false);
        progressBar.setMessage("Loding Data...");
        progressBar.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        progressBar.setProgress(0);
        progressBar.setMax(100);
        progressBar.show();

        // this line need to delete

        Call<List<user>> call = CreateUserInterface.getUserList(Globle_data.loginData.getLoginkey(),"getAllUser",Globle_data.loginData.getUserID());
        call.enqueue(new Callback<List<user>>() {
            @Override
            public void onResponse(Call<List<user>> call, Response<List<user>> response) {
                progressBar.dismiss();
                List<user> userlist = response.body();

                user[] array = new user[userlist.size()];
                userlist.toArray(array); // fill the array


                recyclerView = (RecyclerView) view.findViewById(R.id.userRecyclerView);

                userAdapter adapter = new userAdapter(array,"Change Permission",getContext(),getActivity());
                recyclerView.setHasFixedSize(true);
                recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<user>> call, Throwable t) {
                progressBar.dismiss();
                Toast.makeText(getActivity(),t.getMessage().toString(),Toast.LENGTH_LONG).show();
            }
        });



        return view;
    }
}