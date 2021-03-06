package com.dr.SamirAbbas.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
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
import com.dr.SamirAbbas.activities.SearchDoctorActivity;
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
    private ArrayList<Doctors.Doctor> original;

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public DoctorInfoAdapter(ArrayList<Doctors.Doctor> list2, Context mContext, String specialization) {
        this.specialization = specialization;
        this.mContext = mContext;
        this.original = new ArrayList<>();
        original.addAll(list2);

        this.list = list2;

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
        holder.occupation.setText(list.get(position).getSpecilization());
        holder.experience.setText(list.get(position).getExperience());
        holder.qualification.setText(list.get(position).getDegree());
        //holder.profile.setImageResource(R.drawable.blank_profile);
        Glide.with(mContext).load(list.get(position).getProfilePictureUrl()).into(holder.profile);

        if(list.get(position).getIsAvailableToday()){
            holder.availabilityTextView.setText(R.string.available);
        }else{
            holder.availabilityTextView.setText("");
        }

        holder.book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(mContext, AppointmentTimeSlotActivity.class);
                intent.putExtra("doctor", list.get(position));
                intent.putExtra("speciality", list.get(position).getSpecilization());
                mContext.startActivity(intent);

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

    public void search(String name){
        Log.d("QUERY", name);
        if(name.equals("")){
            Log.d("QUERY", "HERE2");

            list.clear();
            list.addAll(((SearchDoctorActivity) mContext).getList());
            notifyDataSetChanged();
            return;
        }

        ArrayList<Doctors.Doctor> tlist = new ArrayList<>();
        Log.d("QUERY", "SIZE " + original.size());

        for(int i = 0 ; i < ((SearchDoctorActivity) mContext).getList().size(); ++i){
            if(((SearchDoctorActivity) mContext).getList().get(i).getName().toLowerCase().startsWith(name.toLowerCase())){
                tlist.add(((SearchDoctorActivity) mContext).getList().get(i));
                Log.d("QUERY", "HERE3");

            }
        }

        if(tlist.size() > 0){
            Log.d("QUERY", "HERE4");

            list.clear();
            list.addAll(tlist);
            notifyDataSetChanged();
            ((SearchDoctorActivity) mContext).updateSearchText(false);
        }else{
            Log.d("QUERY", "HERE5");

            list.clear();
            notifyDataSetChanged();
            ((SearchDoctorActivity) mContext).updateSearchText(true);
        }


    }
}
