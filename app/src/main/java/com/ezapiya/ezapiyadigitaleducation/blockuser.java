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

public class blockuser  extends Fragment {
    View view;
    RecyclerView recyclerView;
    createUserInterface CreateUserInterface;
    ProgressDialog progressBar;
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.blockuserlayout, container, false);

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

                userAdapter adapter = new userAdapter(array,"Block User",getContext(),getActivity());
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

       /* user[] myListData = new user[] {
                new user(1,"vinit"),
                new user(2,"vinit2"),
                new user(3,"vinit3"),
                new user(4,"vinit4"),
                new user(5,"vinit5"),
                new user(6,"vinit6"),
                new user(7,"vinit7"),
                new user(8,"vinit8"),
                new user(9,"vinit9"),
                new user(10,"vinit10"),
                new user(11,"vinit11"),
                new user(12,"vinit12")
        };





        recyclerView = (RecyclerView) view.findViewById(R.id.userRecyclerView);

        userAdapter adapter = new userAdapter(myListData,"Block");
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);*/

        return view;
    }
}
