package com.dr.SamirAbbas.adapters;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.dr.SamirAbbas.R;

/**
 * Created by Anurag on 4/14/2018.
 */
public class ServicesAdapter extends RecyclerView.Adapter<ServicesAdapter.ServiceHolder>{

    private Activity activity;
    private String heading[], content[];
    private boolean status[];

    public ServicesAdapter(Activity activity) {
        this.activity = activity;
        heading = activity.getResources().getStringArray(R.array.services_list_heading);
        content = activity.getResources().getStringArray(R.array.services_list_content);
        status = new boolean[heading.length];
    }

    class ServiceHolder extends RecyclerView.ViewHolder{
        TextView heading, first, content;
        View main;
        ImageView image;
        public ServiceHolder(View itemView) {
            super(itemView);
            main = itemView.findViewById(R.id.innerlayout4);
            first = itemView.findViewById(R.id.first);
            heading = itemView.findViewById(R.id.heading);
            content = itemView.findViewById(R.id.text4);
            image = itemView.findViewById(R.id.image4);
        }
    }

    @Override
    public ServiceHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(activity).inflate(R.layout.list_item_services, parent, false);
        return new ServiceHolder(view);
    }

    @Override
    public void onBindViewHolder(ServiceHolder holder, final int position) {
        holder.first.setText(heading[position].charAt(0) + "");
        holder.heading.setText(heading[position]);

        holder.content.setText(content[position]);

        holder.main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                status[position] = !status[position];
                notifyItemChanged(position);
            }
        });

        if(status[position]){
            holder.image.setVisibility(View.VISIBLE);
            holder.content.setVisibility(View.VISIBLE);
        }else{
            holder.image.setVisibility(View.GONE);
            holder.content.setVisibility(View.GONE);
        }
    }

    @Override
    public int getItemCount() {
        return heading.length;
    }
}
