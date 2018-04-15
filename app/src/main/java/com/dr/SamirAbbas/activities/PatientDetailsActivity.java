package com.dr.SamirAbbas.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.dr.SamirAbbas.R;
import com.dr.SamirAbbas.models.AppointmentSlot;
import com.dr.SamirAbbas.models.Doctors;
import com.dr.SamirAbbas.utils.Endpoints;
import com.google.gson.JsonObject;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;

import org.json.JSONException;
import org.json.JSONObject;

public class PatientDetailsActivity extends BaseActivity {

    private Doctors.Doctor doctor;
    private AppointmentSlot.Morning slot;

    private EditText name, number, id, ins_number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_details);

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

        doctor = getIntent().getParcelableExtra("doctor");
        slot = getIntent().getParcelableExtra("slot");
        String speciality = getIntent().getStringExtra("speciality");

        ((TextView) findViewById(R.id.docNameTextView)).setText("Dr. " + doctor.getName());
        ((TextView) findViewById(R.id.occupationTextView)).setText(doctor.getSpecilization());
        ((TextView) findViewById(R.id.qualificationTextView)).setText(doctor.getDegree());
        Glide.with(this).load(doctor.getProfilePictureUrl()).into(((ImageView) findViewById(R.id.profile)));

        name = findViewById(R.id.nameTextView);
        number = findViewById(R.id.numberTextView);
        id = findViewById(R.id.id_QMA_textView);
        ins_number = findViewById(R.id.insuranceTextView);

        findViewById(R.id.confirmButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                confirm();
            }
        });
    }

    private void confirm(){
        if(name.getText().toString().length() == 0){
            showToast(R.string.enter_name);
            name.requestFocus();
            return;
        }

        if(number.getText().toString().length() < 9){
            showToast(R.string.enter_number);
            number.requestFocus();
            return;
        }

        if(id.getText().toString().length() == 0) {
            showToast(R.string.enter_id);
            id.requestFocus();
            return;
        }

        if(ins_number.getText().toString().length() == 0){
            showToast(R.string.enter_isn_number);
            ins_number.requestFocus();
            return;
        }

        Intent intent = new Intent(this, SummaryActivity.class);
        intent.putExtra("doctor", doctor);
        intent.putExtra("slot", slot);
        intent.putExtra("speciality", doctor.getSpecilization());
        intent.putExtra("name", name.getText().toString());
        intent.putExtra("id", id.getText().toString());
        intent.putExtra("number", number.getText().toString());
        intent.putExtra("ins", ins_number.getText().toString());
        intent.putExtra("date", getIntent().getStringExtra("date"));
        startActivity(intent);
    }

    private void showToast(int id){
        Toast.makeText(this, id, Toast.LENGTH_SHORT).show();
    }
}
