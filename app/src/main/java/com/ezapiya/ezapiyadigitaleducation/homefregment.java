package com.ezapiya.ezapiyadigitaleducation;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class homefregment extends Fragment {
    View view;
    Button btnManageUser,btnClass,btnsubject,btnChapter,btnNotes,btnQuestion,btnChangePassword;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.homefregmentlayout, container, false);
        btnManageUser = view.findViewById(R.id.btnManageUser);

        btnClass = view.findViewById(R.id.btnClass );
        btnsubject = view.findViewById(R.id.btnsubject );
        btnChapter = view.findViewById(R.id.btnChapter );
        btnNotes = view.findViewById(R.id.btnNotes );
        btnQuestion = view.findViewById(R.id.btnQuestion );
        btnChangePassword = view.findViewById(R.id.btnChangePassword );

        btnManageUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                manageuser homeFrag=new manageuser();
                FragmentManager fragmentManager=getActivity().getFragmentManager();
                FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.frameLayout,homeFrag,"tag");
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });

        btnClass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                class_ homeFrag=new class_();
                FragmentManager fragmentManager=getActivity().getFragmentManager();
                FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.frameLayout,homeFrag,"tag");
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });
        btnsubject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                subject homeFrag=new subject();
                FragmentManager fragmentManager=getActivity().getFragmentManager();
                FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.frameLayout,homeFrag,"tag");
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });
        btnChapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chapter homeFrag=new chapter();
                FragmentManager fragmentManager=getActivity().getFragmentManager();
                FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.frameLayout,homeFrag,"tag");
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });
        btnNotes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                notes homeFrag=new notes();
                FragmentManager fragmentManager=getActivity().getFragmentManager();
                FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.frameLayout,homeFrag,"tag");
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });
        btnQuestion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                question homeFrag=new question();
                FragmentManager fragmentManager=getActivity().getFragmentManager();
                FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.frameLayout,homeFrag,"tag");
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });
        btnChangePassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changepassword homeFrag=new changepassword();
                FragmentManager fragmentManager=getActivity().getFragmentManager();
                FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.frameLayout,homeFrag,"tag");
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });



        return view;
    }
}
