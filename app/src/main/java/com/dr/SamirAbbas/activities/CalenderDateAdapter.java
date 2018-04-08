package com.dr.SamirAbbas.activities;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.TextView;

import com.dr.SamirAbbas.R;

import java.util.ArrayList;

/**
 * Created by Anurag on 4/8/2018.
 */

public class CalenderDateAdapter extends RecyclerView.Adapter<CalenderDateAdapter.DateViewHolder>{

    private ArrayList<CalenderDate> list;
    Context mContext;

    public CalenderDateAdapter(ArrayList<CalenderDate> list, Context mContext) {
        this.list = list;
        this.mContext = mContext;
    }

    @Override
    public DateViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View dateView = LayoutInflater.from(parent.getContext()).inflate(R.layout.date_view_layout, parent, false);
        DateViewHolder dateViewHolder = new DateViewHolder(dateView);
        return dateViewHolder;
    }

    @Override
    public void onBindViewHolder(DateViewHolder holder, int position) {
        holder.dateTextView.setText(list.get(position).getDate());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class DateViewHolder extends RecyclerView.ViewHolder {

        private TextView dateTextView;


        public DateViewHolder(View itemView) {
            super(itemView);
            dateTextView = (TextView) itemView.findViewById(R.id.dateTextView);
        }
    }
}
