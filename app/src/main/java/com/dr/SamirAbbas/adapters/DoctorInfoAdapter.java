package com.dr.SamirAbbas.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.dr.SamirAbbas.R;
import com.dr.SamirAbbas.models.DoctorInfo;

import java.util.ArrayList;

/**
 * Created by Anurag on 4/9/2018.
 */

public class DoctorInfoAdapter extends RecyclerView.Adapter<DoctorInfoAdapter.InfoViewHolder>{
    private ArrayList<DoctorInfo> list;
    private Context mContext;

    public DoctorInfoAdapter(ArrayList<DoctorInfo> list, Context mContext) {
        this.list = list;
        this.mContext = mContext;
    }

    @Override
    public InfoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_doctor_details, parent, false);
        InfoViewHolder infoViewHolder = new InfoViewHolder(view);
        return infoViewHolder;
    }

    @Override
    public void onBindViewHolder(InfoViewHolder holder, int position) {
        holder.name.setText(list.get(position).getDocName());
        holder.occupation.setText(list.get(position).getDocOccupation());
        holder.experience.setText(list.get(position).getDocExperience());
        holder.qualification.setText(list.get(position).getDocQualification());
        holder.profile.setImageResource(R.drawable.blank_profile);
        holder.book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class InfoViewHolder extends RecyclerView.ViewHolder{
        private TextView name, occupation, experience, qualification;
        private ImageView profile;
        private Button book;

        public InfoViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.docNameTextView);
            occupation = itemView.findViewById(R.id.occupationTextView);
            experience = itemView.findViewById(R.id.experienceTextView);
            qualification = itemView.findViewById(R.id.qualificationTextView);
            profile = itemView.findViewById(R.id.profile);
            book = itemView.findViewById(R.id.bookAppointmentButton);
        }
    }
}
