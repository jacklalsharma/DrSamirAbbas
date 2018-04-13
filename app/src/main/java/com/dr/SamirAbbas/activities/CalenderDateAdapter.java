package com.dr.SamirAbbas.activities;

import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dr.SamirAbbas.R;

import java.util.ArrayList;

/**
 * Created by Anurag on 4/8/2018.
 */
public class CalenderDateAdapter extends RecyclerView.Adapter<CalenderDateAdapter.DateViewHolder>{

    private ArrayList<CalenderDate> list;
    private Context mContext;
    private int initialPos;

    public CalenderDateAdapter(ArrayList<CalenderDate> list, Context mContext) {
        this.list = list;
        this.mContext = mContext;
        initialPos = 0;
    }

    @Override
    public DateViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View dateView = LayoutInflater.from(parent.getContext()).inflate(R.layout.date_view_layout, parent, false);
        DateViewHolder dateViewHolder = new DateViewHolder(dateView);
        return dateViewHolder;
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onBindViewHolder(final DateViewHolder holder, final int position) {
        holder.dateTextView.setText(list.get(position).getDate() + "");

        holder.dateTextView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                if(list.get(position).isSelected()) {

                    view.setBackgroundTintList(mContext.getResources().getColorStateList(R.color.white));
                    holder.dateTextView.setTextColor(mContext.getResources().getColor(R.color.textGray));
                    list.get(position).setSelected(false);
                } else {
                    view.setBackgroundTintList(mContext.getResources().getColorStateList(R.color.blue));
                    list.get(position).setSelected(true);
                    holder.dateTextView.setTextColor(mContext.getResources().getColor(R.color.white));

                    if(initialPos!=position) {
                        list.get(initialPos).setSelected(false);
                        notifyItemChanged(initialPos);
                    }
                    initialPos = position;
                }

                ((AppointmentTimeSlotActivity) mContext).getTimingsSlot();
            }
        });

        if(list.get(position).isSelected()) {
            Log.d("HERE", "HERE");
            holder.dateTextView.setBackgroundTintList(mContext.getResources().getColorStateList(R.color.blue));
            holder.dateTextView.setTextColor(mContext.getResources().getColor(R.color.white));
        }
        else {
            holder.dateTextView.setBackgroundTintList(mContext.getResources().getColorStateList(R.color.white));
            holder.dateTextView.setTextColor(mContext.getResources().getColor(R.color.textGray));
        }
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
