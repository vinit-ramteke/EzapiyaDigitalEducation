package com.ezapiya.ezapiyadigitaleducation.Adopter;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ezapiya.ezapiyadigitaleducation.Model.chapterModel;
import com.ezapiya.ezapiyadigitaleducation.R;

import androidx.recyclerview.widget.RecyclerView;

public class chapterAdapter extends RecyclerView.Adapter<chapterAdapter.ViewHolder>{
    private chapterModel[] listdata;
    private Context context;
    private Activity activity;

    public chapterAdapter(chapterModel[] listdata,Context context, Activity activity) {
        this.listdata = listdata;
        this.context=context;
        this.activity=activity;

    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem= layoutInflater.inflate(R.layout.chapterrecyclerlayout, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final chapterModel myListData = listdata[position];
        holder.txtsubjectName.setText(myListData.getSubjectName());
        holder.txtchapterName.setText(myListData.getChapterName());
    }


    @Override
    public int getItemCount() {
        return listdata.length;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView txtsubjectName,txtchapterName;
        public ViewHolder(View itemView) {
            super(itemView);
            this.txtsubjectName =(TextView) itemView.findViewById(R.id.txtsubjectName);
            this.txtchapterName =(TextView) itemView.findViewById(R.id.txtchapterName);
        }
    }
}