package com.dr.SamirAbbas.activities;

import android.content.Context;
import android.content.Intent;

import android.content.res.ColorStateList;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;


import com.dr.SamirAbbas.R;

import java.util.ArrayList;
import java.util.Calendar;

public class AppointmentTimeSlotActivity extends BaseActivity {

    private ImageButton calenderButton;
    private ImageView leftSwipe, rightSwipe;
    private CalenderDateAdapter adapter;
    private RecyclerView recyclerView;
    private TextView monthTextView;
    private TextView dateTextView;
    private ArrayList<AppointmentTime> mList1, mList2, mList3, mList4;
    private AppointmentTimeAdapter adapter1, adapter2, adapter3, adapter4;
    private RecyclerView morningRecyclerView, afternoonRecyclerView, eveningRecyclerView, nightRecyclerView;
    private ArrayList<CalenderDate> dateArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appointment_time_slot);

        leftSwipe = (ImageView) findViewById(R.id.leftSwipe);
        rightSwipe = (ImageView) findViewById(R.id.rightSwipe);
        dateTextView = (TextView) findViewById(R.id.dateTextView);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationIcon(R.drawable.ic_back_arrow);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), AvailableDoctorsListActivity.class));
            }
        });

        calenderButton = (ImageButton) findViewById(R.id.calenderButton);
        monthTextView = (TextView) findViewById(R.id.monthTextView);

        setCalendar();

        setAppointment();

    }

    private void setCalendar(){
        recyclerView = findViewById(R.id.dateRecyclerView);
        final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);

        dateArrayList = new ArrayList<>();

        for(int i =1  ; i <= 31 ; ++i){
            CalenderDate date = new CalenderDate(2018, 4, i);

            dateArrayList.add(date);
        }

        adapter = new CalenderDateAdapter(dateArrayList, getActivity());
        recyclerView.setAdapter(adapter);


        //Scrolling rate one week

        rightSwipe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int totalItemCount = recyclerView.getAdapter().getItemCount();
                if(totalItemCount <=0)
                    return;
                int lastVisibleItem = linearLayoutManager.findLastCompletelyVisibleItemPosition();
                if(lastVisibleItem >= totalItemCount)
                    return;
                linearLayoutManager.smoothScrollToPosition(recyclerView, null, lastVisibleItem+7);
            }
        });

        leftSwipe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int firstVisibleItem = linearLayoutManager.findFirstCompletelyVisibleItemPosition();
                if (firstVisibleItem > 0)
                    linearLayoutManager.smoothScrollToPosition(recyclerView, null, firstVisibleItem-7);
            }
        });

    }

    public void setAppointment() {

        morningRecyclerView = findViewById(R.id.morningRecyclerView);
        afternoonRecyclerView = findViewById(R.id.afternoonRecyclerView);
        eveningRecyclerView = findViewById(R.id.eveningRecyclerView);
        nightRecyclerView = findViewById(R.id.nightRecyclerView);

        GridLayoutManager gridLayoutManager1 = new GridLayoutManager(getActivity(), 4);
        GridLayoutManager gridLayoutManager2 = new GridLayoutManager(getActivity(), 4);
        GridLayoutManager gridLayoutManager3 = new GridLayoutManager(getActivity(), 4);
        GridLayoutManager gridLayoutManager4 = new GridLayoutManager(getActivity(), 4);


        mList1 = new ArrayList<>();
        adapter1 = new AppointmentTimeAdapter(mList1, getActivity());

        mList2 = new ArrayList<>();
        adapter2 = new AppointmentTimeAdapter(mList2, getActivity());

        mList3 = new ArrayList<>();
        adapter3 = new AppointmentTimeAdapter(mList3, getActivity());

        mList4 = new ArrayList<>();
        adapter4 = new AppointmentTimeAdapter(mList4, getActivity());

        morningRecyclerView.setLayoutManager(gridLayoutManager1);
        morningRecyclerView.setAdapter(adapter1);

        afternoonRecyclerView.setLayoutManager(gridLayoutManager2);
        afternoonRecyclerView.setAdapter(adapter2);

        eveningRecyclerView.setLayoutManager(gridLayoutManager3);
        eveningRecyclerView.setAdapter(adapter3);

        nightRecyclerView.setLayoutManager(gridLayoutManager4);
        nightRecyclerView.setAdapter(adapter4);

        getTimmings();

        adapter1.notifyDataSetChanged();
        adapter2.notifyDataSetChanged();
        adapter3.notifyDataSetChanged();
        adapter4.notifyDataSetChanged();


    }

    public void getTimmings() {
        for(int i = 0 ; i < 5 ; ++i){
            AppointmentTime appointmentTime = new AppointmentTime("9:10");
            mList1.add(appointmentTime);
        }


        for(int i = 0 ; i < 5 ; ++i){
            AppointmentTime appointmentTime = new AppointmentTime("9:10");
            mList2.add(appointmentTime);
        }


        for(int i = 0 ; i < 5 ; ++i){
            AppointmentTime appointmentTime = new AppointmentTime("9:10");
            mList3.add(appointmentTime);
        }


        for(int i = 0 ; i < 5 ; ++i){
            AppointmentTime appointmentTime = new AppointmentTime("9:10");
            mList4.add(appointmentTime);
        }
    }
}
