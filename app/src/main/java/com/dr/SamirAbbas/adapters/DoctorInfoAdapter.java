package com.dr.SamirAbbas.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.dr.SamirAbbas.R;
import com.dr.SamirAbbas.activities.AppointmentTimeSlotActivity;
import com.dr.SamirAbbas.models.DoctorInfo;
import com.dr.SamirAbbas.models.Doctors;

import java.util.ArrayList;

/**
 * Created by Anurag on 4/9/2018.
 */

public class DoctorInfoAdapter extends RecyclerView.Adapter<DoctorInfoAdapter.InfoViewHolder>{
    private ArrayList<Doctors.Doctor> list;
    private Context mContext;
    private String specialization;

    public DoctorInfoAdapter(ArrayList<Doctors.Doctor> list, Context mContext, String specialization) {
        this.list = list;
        this.specialization = specialization;
        this.mContext = mContext;
    }

    @Override
    public InfoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_doctor_details, parent, false);
        InfoViewHolder infoViewHolder = new InfoViewHolder(view);
        return infoViewHolder;
    }

    @Override
    public void onBindViewHolder(InfoViewHolder holder, final int position) {
        holder.name.setText(list.get(position).getName());
        holder.occupation.setText(specialization);
        holder.experience.setText(list.get(position).getExperience() + " years experience");
        holder.qualification.setText(list.get(position).getDegree());
        //holder.profile.setImageResource(R.drawable.blank_profile);
        Glide.with(mContext).load(list.get(position).getProfilePictureUrl()).into(holder.profile);

        if(list.get(position).getIsAvailableToday()){
            holder.availabilityTextView.setText(R.string.available);
        }else{
            holder.availabilityTextView.setText(R.string.not_available);
        }

        holder.book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!list.get(position).getIsAvailableToday()){
                    //Available today...
                    Intent intent = new Intent(mContext, AppointmentTimeSlotActivity.class);
                    intent.putExtra("doctor", list.get(position));
                    mContext.startActivity(intent);
                }else{
                    //Not available today...
                    Toast.makeText(mContext, R.string.doctor_not_available, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class InfoViewHolder extends RecyclerView.ViewHolder{
        private TextView name, occupation, experience, qualification, availabilityTextView;
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
            availabilityTextView = itemView.findViewById(R.id.availabilityTextView);
        }
    }
}
