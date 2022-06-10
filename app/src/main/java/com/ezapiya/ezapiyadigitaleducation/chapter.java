package com.ezapiya.ezapiyadigitaleducation;

import com.ezapiya.ezapiyadigitaleducation.Adopter.subjectAdapter;
import com.ezapiya.ezapiyadigitaleducation.Model.chapterModel;
import com.ezapiya.ezapiyadigitaleducation.Adopter.chapterAdapter;
import com.ezapiya.ezapiyadigitaleducation.Model.subjectModel;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.app.Fragment;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class chapter  extends Fragment {
    View view;
    RecyclerView recyclerView;
    ImageButton btnadd;
    TextView txterror;
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.chapterlayout, container, false);
        getActivity().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
        btnadd =(ImageButton)view.findViewById(R.id.btnadd);
        txterror=(TextView)view.findViewById(R.id.txterror);
        recyclerView = (RecyclerView) view.findViewById(R.id.chapterRecyclerView);
        chapterModel[] array= new chapterModel[]{
                new chapterModel("1","1","1st","abc"),
                new chapterModel("1","1","1st","abc"),
                new chapterModel("1","1","1st","abc"),
                new chapterModel("1","1","1st","abc"),
                new chapterModel("1","1","1st","abc"),
                new chapterModel("1","1","1st","abc"),
                new chapterModel("1","1","1st","abc"),
                new chapterModel("1","1","1st","abc"),
                new chapterModel("1","1","1st","abc"),
                new chapterModel("1","1","1st","abc"),

        };

        chapterAdapter adapter = new chapterAdapter(array,getContext(),getActivity());
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);

        return view;
    }
}