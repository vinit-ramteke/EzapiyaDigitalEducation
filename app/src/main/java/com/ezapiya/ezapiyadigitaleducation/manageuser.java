package com.ezapiya.ezapiyadigitaleducation;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.app.Fragment;
import android.view.WindowManager;
import android.widget.Button;

public class manageuser extends Fragment {
    View view;
    Button btnAddUser,btnRemoveUser,btnBlockUser,btnPermission,btnUnBlockUser;
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.manageuserlayout, container, false);
        getActivity().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);

        btnAddUser = view.findViewById(R.id.btnManageUser);
        btnRemoveUser = view.findViewById(R.id.btnRemoveUser );
        btnBlockUser = view.findViewById(R.id.btnBlockUser );
        btnPermission = view.findViewById(R.id.btnPermission );
        btnUnBlockUser= view.findViewById(R.id.btnUnBlockUser );

        if(Globle_data.loginData.getAddUser().compareTo("yes")==0)
        {
            btnAddUser.setEnabled(true);
        }
        else
        {
            btnAddUser.setEnabled(false);
        }
        if(Globle_data.loginData.getRemoveUser().compareTo("yes")==0)
        {
            btnRemoveUser.setEnabled(true);
        }
        else
        {
            btnRemoveUser.setEnabled(false);
        }
        if(Globle_data.loginData.getBlockUser().compareTo("yes")==0)
        {
            btnBlockUser.setEnabled(true);
            btnUnBlockUser.setEnabled(true);

        }
        else
        {
            btnBlockUser.setEnabled(false);
            btnUnBlockUser.setEnabled(false);
        }
        if(Globle_data.loginData.getUserPermission().compareTo("yes")==0)
        {
            btnPermission.setEnabled(true);
        }
        else
        {
            btnPermission.setEnabled(false);
        }

        btnAddUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adduser homeFrag=new adduser();
                FragmentManager fragmentManager=getActivity().getFragmentManager();
                FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.frameLayout,homeFrag,"tag");
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });
        btnRemoveUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                removeuser homeFrag=new removeuser();
                FragmentManager fragmentManager=getActivity().getFragmentManager();
                FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.frameLayout,homeFrag,"tag");
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });
        btnBlockUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                blockuser homeFrag=new blockuser();
                FragmentManager fragmentManager=getActivity().getFragmentManager();
                FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.frameLayout,homeFrag,"tag");
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });
        btnPermission.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userpermission homeFrag=new userpermission();
                FragmentManager fragmentManager=getActivity().getFragmentManager();
                FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.frameLayout,homeFrag,"tag");
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });
        btnUnBlockUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                unblockuser homeFrag=new unblockuser();
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