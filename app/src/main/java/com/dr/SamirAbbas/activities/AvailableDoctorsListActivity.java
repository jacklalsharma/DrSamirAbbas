package com.dr.SamirAbbas.activities;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.AppCompatSpinner;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.dr.SamirAbbas.R;
import com.dr.SamirAbbas.adapters.DoctorInfoAdapter;
import com.dr.SamirAbbas.models.Doctors;
import com.dr.SamirAbbas.models.Specializations;
import com.dr.SamirAbbas.utils.DialogBox;
import com.dr.SamirAbbas.utils.Endpoints;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class AvailableDoctorsListActivity extends BaseActivity{

    ArrayList<Doctors.Doctor> mList;
    DoctorInfoAdapter doctorInfoAdapter;
    RecyclerView recyclerView;
    private boolean firstRun;

    private ArrayList<Specializations.Specialization> specializationArrayList;
    private int selectedSpecialisation;


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        firstRun = false;
        selectedSpecialisation = getIntent().getIntExtra("position", 0);
        specializationArrayList = getIntent().getParcelableArrayListExtra("list");

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

        AppCompatSpinner spinner = (AppCompatSpinner) findViewById(R.id.docOccupationSpinner);

        List<String> list = new ArrayList<>();

        for(int i = 0 ; i < specializationArrayList.size() ; ++i){
            list.add(specializationArrayList.get(i).getName());
        }

        ((TextView) findViewById(R.id.docTextView)).setText(specializationArrayList.get(selectedSpecialisation).getName());

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if(firstRun == false){
                    firstRun = true;
                    return;
                }
                selectedSpecialisation = i;
                ((TextView) findViewById(R.id.docTextView)).setText(specializationArrayList.get(selectedSpecialisation).getName());
                mList.clear();
                doctorInfoAdapter.setSpecialization(specializationArrayList.get(selectedSpecialisation).getName());
                doctorInfoAdapter.notifyDataSetChanged();
                getDoctorsList();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        ArrayAdapter<String> mAdapter = new ArrayAdapter<String>(this, R.layout.spinner_list_item, list);
        mAdapter.setDropDownViewResource(R.layout.spinner_list_item);
        spinner.setAdapter(mAdapter);


        mList = new ArrayList<>();
        recyclerView = findViewById(R.id.availDocRecyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(linearLayoutManager);
        doctorInfoAdapter = new DoctorInfoAdapter(mList, getActivity(), specializationArrayList.get(selectedSpecialisation).getName());
        recyclerView.setAdapter(doctorInfoAdapter);

        getDoctorsList();
    }


    //Gets the Doctor list for selected specialization....
    private void getDoctorsList(){
        DialogBox.ShowProgressDialog(this, "Getting doctors list", "Please wait while we are getting doctors list");

        Date c = Calendar.getInstance().getTime();
        System.out.println("Current time => " + c);

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String formattedDate = df.format(c);

        String url = String.format(Endpoints.GetDoctors, "" + specializationArrayList.get(selectedSpecialisation).getId() , "" + formattedDate);
        Log.d("URL", url);
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
                                    Doctors doctors = new Gson().fromJson(object.toString(), Doctors.class);
                                    mList.clear();
                                    mList.addAll(doctors.getData().getDoctors());
                                    doctorInfoAdapter.notifyDataSetChanged();

                                    if(mList.size() == 0){
                                        findViewById(R.id.no_docs).setVisibility(View.VISIBLE);
                                    }else{
                                        findViewById(R.id.no_docs).setVisibility(View.GONE);
                                    }
                                }
                            }catch (JSONException e1){

                            }
                        }else{
                            //Failed...
                        }
                    }
                });
    }
}
