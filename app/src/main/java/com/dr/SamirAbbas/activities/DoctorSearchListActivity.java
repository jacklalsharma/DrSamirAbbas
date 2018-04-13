package com.dr.SamirAbbas.activities;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.dr.SamirAbbas.R;
import com.dr.SamirAbbas.adapters.DoctorInfoAdapter;
import com.dr.SamirAbbas.models.DoctorInfo;
import com.dr.SamirAbbas.models.Doctors;

import java.util.ArrayList;

public class DoctorSearchListActivity extends BaseActivity {
    ArrayList<Doctors.Doctor> mList;
    DoctorInfoAdapter doctorInfoAdapter;
    RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_search_list);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        toolbar.setNavigationIcon(R.drawable.ic_back_arrow);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });


        mList = new ArrayList<>();
        recyclerView = findViewById(R.id.docListRecyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(linearLayoutManager);
        doctorInfoAdapter = new DoctorInfoAdapter(mList, getActivity(), "");
        recyclerView.setAdapter(doctorInfoAdapter);

        prepareDocList();
        doctorInfoAdapter.notifyDataSetChanged();
    }

    private void prepareDocList() {
        DoctorInfo  doctorInfo;
        for(int i = 0; i < 10; i++) {
            doctorInfo = new DoctorInfo("Ayushmaan Gupta", "MBBS", "Dentist", "12 Years of experience");
            //mList.add(doctorInfo);
        }
    }
}
