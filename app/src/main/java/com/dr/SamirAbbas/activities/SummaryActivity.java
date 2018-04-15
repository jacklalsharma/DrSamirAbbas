package com.dr.SamirAbbas.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.dr.SamirAbbas.R;
import com.dr.SamirAbbas.models.AppointmentSlot;
import com.dr.SamirAbbas.models.Doctors;
import com.dr.SamirAbbas.utils.DialogBox;
import com.dr.SamirAbbas.utils.Endpoints;
import com.google.gson.JsonObject;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;

import org.json.JSONException;
import org.json.JSONObject;

public class SummaryActivity extends BaseActivity {

    private Doctors.Doctor doctor;
    private AppointmentSlot.Morning slot;
    private String name, id, ins, number;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);

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

        doctor = getIntent().getParcelableExtra("doctor");
        slot = getIntent().getParcelableExtra("slot");
        String speciality = getIntent().getStringExtra("speciality");

        name = getIntent().getStringExtra("name");
        number = getIntent().getStringExtra("number");
        id = getIntent().getStringExtra("id");
        ins = getIntent().getStringExtra("ins");

        String date = getIntent().getStringExtra("date");
        ((TextView) findViewById(R.id.date)).setText(date);

        ((TextView) findViewById(R.id.docNameTextView)).setText("Dr. " + doctor.getName());
        ((TextView) findViewById(R.id.occupationTextView)).setText(doctor.getSpecilization());
        ((TextView) findViewById(R.id.qualificationTextView)).setText(doctor.getDegree());
        Glide.with(this).load(doctor.getProfilePictureUrl()).into(((ImageView) findViewById(R.id.profile)));

        ((TextView) findViewById(R.id.nameTextView)).setText(name);
        ((TextView) findViewById(R.id.numberTextView)).setText(number);
        ((TextView) findViewById(R.id.id_QMA_textView)).setText(id);
        ((TextView) findViewById(R.id.insuranceNumTextView)).setText(ins);

        String timeSlot = slot.getStartTime();
        int hr = Integer.parseInt(timeSlot.split(":")[0]);
        if(hr < 12){
            timeSlot = timeSlot + " AM";
        }else{
            hr = hr % 12;
            if(hr == 0){
                timeSlot = "12:" + slot.getStartTime().split(":")[1] + " PM";
            }else{
                timeSlot = hr + ":" + slot.getStartTime().split(":")[1] + " PM";
            }
        }
        ((TextView) findViewById(R.id.time_slot)).setText(timeSlot);

        findViewById(R.id.confirmButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bookAppointment();
            }
        });
    }

    private void bookAppointment(){
        DialogBox.ShowProgressDialog(this, R.string.book, R.string.book_msg);
        final JsonObject object = new JsonObject();
        object.addProperty("slot_id", slot.getId());
        object.addProperty("name", name);
        object.addProperty("national_id", id);
        object.addProperty("insurance_no", ins);
        object.addProperty("mobile", number);
        Log.d("RESPONSE", object.toString());

        Ion.with(this)
                .load("POST", Endpoints.BookDoctor)
                .setHeader("Content-Type", "application/json")
                .setJsonObjectBody(object)
                .asJsonObject()
                .setCallback(new FutureCallback<JsonObject>() {
                    @Override
                    public void onCompleted(Exception e, JsonObject result) {

                        DialogBox.DismissProgressDialog();

                        if(result != null){
                            try{
                                Log.d("RESPONSE", result.toString());
                                JSONObject response = new JSONObject(result.toString());
                                if(response.getBoolean("success")){
                                    Intent intent = new Intent(getActivity(), SaveBookingActivity.class);
                                    intent.putExtra("booking_id", response.getJSONObject("data").getString("booking_id"));
                                    startActivity(intent);
                                }else{
                                    showToast(R.string.booking_failed);
                                }
                            }catch (JSONException e1){
                                showToast(R.string.booking_failed);

                            }
                        }else{
                            showToast(R.string.booking_failed);
                        }
                    }
                });
    }

    private void showToast(int id){
        Toast.makeText(this, id, Toast.LENGTH_SHORT).show();
    }
}
