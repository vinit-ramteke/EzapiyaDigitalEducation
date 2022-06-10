package com.ezapiya.ezapiyadigitaleducation;


import com.ezapiya.ezapiyadigitaleducation.Model.class_Model;
import com.ezapiya.ezapiyadigitaleducation.Model.subjectModel;
import com.ezapiya.ezapiyadigitaleducation.Adopter.subjectAdapter;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.app.Fragment;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class subject  extends Fragment {
    View view;
    RecyclerView recyclerView;
    ImageButton btnadd;
    TextView txterror;
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.subjectlayout, container, false);

        getActivity().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);

        btnadd =(ImageButton)view.findViewById(R.id.btnaddsubject);
        txterror=(TextView)view.findViewById(R.id.txterror);
        recyclerView = (RecyclerView) view.findViewById(R.id.subjectRecyclerView);

        subjectModel[] array= new subjectModel[]{
                new subjectModel("1","1","1st","abc"),
                new subjectModel("1","1","1st","abc"),
                new subjectModel("1","1","1st","abc"),
                new subjectModel("1","1","1st","abc"),
                new subjectModel("1","1","1st","abc"),
                new subjectModel("1","1","1st","abc"),
                new subjectModel("1","1","1st","abc"),
                new subjectModel("1","1","1st","abc"),
                new subjectModel("1","1","1st","abc"),
                new subjectModel("1","1","1st","abc"),

        };

        subjectAdapter adapter = new subjectAdapter(array,getContext(),getActivity());
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);

        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                builder.setTitle("Title");
                final LinearLayout lil =new LinearLayout(getContext());

                lil.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT));
                lil.setOrientation(LinearLayout.VERTICAL);
                lil.setPadding(5,5,5,5);
                final Spinner input = new  Spinner(getContext());
                final EditText input1 = new EditText(getContext());
                //input1.setHint("");
                List<String> spinnerArray =  new ArrayList<String>();
                spinnerArray.add("Teaching");
                spinnerArray.add("Non Teaching");

                ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                        view.getContext(), android.R.layout.simple_spinner_item, spinnerArray);

                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

                input.setAdapter(adapter);


                //input.setInputType(InputType.TYPE_CLASS_TEXT );
                lil.addView(input);
                lil.addView(input1);
                builder.setView(lil);

                // Set up the buttons
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //txterror.setText( input.getText().toString());
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


        return view;
    }
}