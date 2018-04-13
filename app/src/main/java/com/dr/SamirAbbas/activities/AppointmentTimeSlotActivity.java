package com.dr.SamirAbbas.activities;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.dr.SamirAbbas.R;
import com.dr.SamirAbbas.models.AppointmentSlot;
import com.dr.SamirAbbas.models.Doctors;
import com.dr.SamirAbbas.utils.DialogBox;
import com.dr.SamirAbbas.utils.Endpoints;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Calendar;

public class AppointmentTimeSlotActivity extends BaseActivity {

    private ImageButton calenderButton;
    private ImageView leftSwipe, rightSwipe;
    private CalenderDateAdapter adapter;
    private RecyclerView recyclerView;
    private TextView monthTextView;
    private TextView dateTextView;

    private ArrayList<AppointmentSlot.Morning> mList1, mList2, mList3, mList4;

    private AppointmentTimeAdapter adapter1, adapter2, adapter3, adapter4;
    private RecyclerView morningRecyclerView, afternoonRecyclerView, eveningRecyclerView, nightRecyclerView;
    private ArrayList<CalenderDate> dateArrayList;

    private Doctors.Doctor doctor;

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
                onBackPressed();
            }
        });

        calenderButton = (ImageButton) findViewById(R.id.calenderButton);
        monthTextView = (TextView) findViewById(R.id.monthTextView);

        doctor = getIntent().getParcelableExtra("doctor");
        setCalendar();

    }

    private void setCalendar(){
        recyclerView = findViewById(R.id.dateRecyclerView);
        final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);

        dateArrayList = new ArrayList<>();
        Calendar cal = Calendar.getInstance();

        for(int i = 0  ; i < 14 ; ++i){
            int year = cal.get(Calendar.YEAR);
            int month = cal.get(Calendar.MONTH);
            int day = cal.get(Calendar.DAY_OF_MONTH);

            CalenderDate date = new CalenderDate(year , month + 1, day);
            if(i == 0){
                date.setSelected(true);
            }
            dateArrayList.add(date);
            cal.add(Calendar.DAY_OF_MONTH, 1);
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

        mList1 = new ArrayList<>();
        mList2 = new ArrayList<>();
        mList3 = new ArrayList<>();
        mList4 = new ArrayList<>();

        adapter1 = new AppointmentTimeAdapter(mList1, this, 1);
        adapter2 = new AppointmentTimeAdapter(mList2, this, 2);
        adapter3 = new AppointmentTimeAdapter(mList3, this, 3);
        adapter4 = new AppointmentTimeAdapter(mList4, this, 4);

        morningRecyclerView = findViewById(R.id.morningRecyclerView);
        afternoonRecyclerView = findViewById(R.id.afternoonRecyclerView);
        eveningRecyclerView = findViewById(R.id.eveningRecyclerView);
        nightRecyclerView = findViewById(R.id.nightRecyclerView);

        GridLayoutManager gridLayoutManager1 = new GridLayoutManager(getActivity(), 4);
        GridLayoutManager gridLayoutManager2 = new GridLayoutManager(getActivity(), 4);
        GridLayoutManager gridLayoutManager3 = new GridLayoutManager(getActivity(), 4);
        GridLayoutManager gridLayoutManager4 = new GridLayoutManager(getActivity(), 4);

        morningRecyclerView.setLayoutManager(gridLayoutManager1);
        morningRecyclerView.setAdapter(adapter1);

        afternoonRecyclerView.setLayoutManager(gridLayoutManager2);
        afternoonRecyclerView.setAdapter(adapter2);

        eveningRecyclerView.setLayoutManager(gridLayoutManager3);
        eveningRecyclerView.setAdapter(adapter3);

        nightRecyclerView.setLayoutManager(gridLayoutManager4);
        nightRecyclerView.setAdapter(adapter4);


        getTimingsSlot();
    }



    public void getTimingsSlot(){

        DialogBox.ShowProgressDialog(this, "Getting time slot", "Please wait while we are getting the time slots...");
        String url = "";
        for(int i = 0 ; i < dateArrayList.size() ; ++i){
            if(dateArrayList.get(i).isSelected()){
                url = String.format(Endpoints.AvailableSlot, doctor.getId() + "" , dateArrayList.get(i).getCalendarDate());
            }
        }

        Log.d("URL", url);
        url = "https://hospoital.000webhostapp.com/booking-apis/apis/get_doctor_schedule_slots?doctor_id=7&date=2018-4-04";
        Ion.with(this)
                .load("GET", url)
                .setJsonObjectBody(new JsonObject())
                .asJsonObject()
                .setCallback(new FutureCallback<JsonObject>() {
                    @Override
                    public void onCompleted(Exception e, JsonObject result) {
                        DialogBox.DismissProgressDialog();
                        if(result != null){
                            try{
                                JSONObject object = new JSONObject(result.toString());
                                if(object.getBoolean("success")){
                                    AppointmentSlot appointmentSlot = new Gson().fromJson(object.toString(), AppointmentSlot.class);

                                    if(appointmentSlot.getData().getSlots().getMorning() != null){
                                        mList1.clear();
                                        mList1.addAll(appointmentSlot.getData().getSlots().getMorning());
                                        adapter1.notifyDataSetChanged();

                                    }

                                    if(appointmentSlot.getData().getSlots().getAfternoon() != null){
                                        mList2.clear();
                                        mList2.addAll(appointmentSlot.getData().getSlots().getAfternoon());
                                        adapter2.notifyDataSetChanged();

                                    }

                                    if(appointmentSlot.getData().getSlots().getEvening() != null){
                                        mList3.clear();
                                        mList3.addAll(appointmentSlot.getData().getSlots().getEvening());
                                        adapter3.notifyDataSetChanged();
                                    }


                                    if(appointmentSlot.getData().getSlots().getNight() != null){

                                        mList4.clear();
                                        mList4.addAll(appointmentSlot.getData().getSlots().getNight());
                                        adapter4.notifyDataSetChanged();
                                    }else{
                                        mList4.clear();
                                        adapter4.notifyDataSetChanged();
                                    }




                                }else{
                                    //Failed...
                                    Toast.makeText(getActivity(), R.string.no_slots, Toast.LENGTH_SHORT).show();
                                }
                            }catch (JSONException e1){

                            }
                        }else{
                            //Failed...
                        }
                    }
                });
    }

    public void updateOthersSlotUponSelection(){
        if(mList4 != null){
            for(int i = 0 ; i < mList4.size() ; ++i){
                if(mList4.get(i).isSelected()){
                    mList4.get(i).setSelected(false);
                    adapter4.notifyItemChanged(i);
                    return;
                }
            }
        }

        if(mList3 != null){
            for(int i = 0 ; i < mList3.size() ; ++i){
                if(mList3.get(i).isSelected()){
                    mList3.get(i).setSelected(false);
                    adapter3.notifyItemChanged(i);
                    return;
                }
            }
        }

        if(mList2 != null){
            for(int i = 0 ; i < mList2.size() ; ++i){
                if(mList2.get(i).isSelected()){
                    mList2.get(i).setSelected(false);
                    adapter2.notifyItemChanged(i);
                    return;
                }
            }
        }

        if(mList1 != null){
            for(int i = 0 ; i < mList1.size() ; ++i){
                if(mList1.get(i).isSelected()){
                    mList1.get(i).setSelected(false);
                    adapter1.notifyItemChanged(i);
                    return;
                }
            }
        }
    }

}
