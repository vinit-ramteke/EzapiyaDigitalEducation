package com.ezapiya.ezapiyadigitaleducation.Adopter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ezapiya.ezapiyadigitaleducation.Model.subjectModel;
import com.ezapiya.ezapiyadigitaleducation.R;

import androidx.recyclerview.widget.RecyclerView;

public class subjectAdapter extends RecyclerView.Adapter<subjectAdapter.ViewHolder>{
    private subjectModel[] listdata;
    private Context context;
    private Activity activity;

    public subjectAdapter(subjectModel[] listdata,Context context, Activity activity) {
        this.listdata = listdata;
        this.context=context;
        this.activity=activity;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem= layoutInflater.inflate(R.layout.subjectrecyclerlayout, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final subjectModel myListData = listdata[position];

        holder.txtclassName.setText(myListData.getClassName());
        holder.txtsubjectName.setText(myListData.getSubjectName());

    }


    @Override
    public int getItemCount() {
        return listdata.length;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView txtclassName,txtsubjectName;
        public ViewHolder(View itemView) {
            super(itemView);
            this.txtclassName =(TextView) itemView.findViewById(R.id.txtclassName);
            this.txtsubjectName =(TextView) itemView.findViewById(R.id.txtsubjectName);

        }
    }
}