package com.dr.SamirAbbas.activities;

import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.dr.SamirAbbas.R;
import com.dr.SamirAbbas.adapters.DoctorInfoAdapter;
import com.dr.SamirAbbas.models.DoctorInfo;

import java.util.ArrayList;
import java.util.List;

public class AvailableDoctorsListActivity extends BaseActivity{

    ArrayList<DoctorInfo> mList;
    DoctorInfoAdapter doctorInfoAdapter;
    RecyclerView recyclerView;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_available_doctors_list);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationIcon(R.drawable.ic_back_arrow);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        Spinner spinner = (Spinner) findViewById(R.id.docOccupationSpinner);
        List<String> list = new ArrayList<>();
        list.add("Dentist");
        list.add("Women Health");
        list.add("Surgery");
        ArrayAdapter<String> mAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, list);
        mAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(mAdapter);


        mList = new ArrayList<>();
        recyclerView = findViewById(R.id.availDocRecyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(linearLayoutManager);
        doctorInfoAdapter = new DoctorInfoAdapter(mList, getActivity());
        recyclerView.setAdapter(doctorInfoAdapter);

        prepareDocList();
        doctorInfoAdapter.notifyDataSetChanged();
    }

    private void prepareDocList() {
        DoctorInfo  doctorInfo;
        for(int i = 0; i < 10; i++) {
            doctorInfo = new DoctorInfo("Ayushmaan Gupta", "MBBS", "Dentist", "12 Years of experience");
            mList.add(doctorInfo);
        }
    }
}
