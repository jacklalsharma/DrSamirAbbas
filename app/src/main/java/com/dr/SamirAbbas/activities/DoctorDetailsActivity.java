package com.dr.SamirAbbas.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.dr.SamirAbbas.R;

public class DoctorDetailsActivity extends AppCompatActivity {

    private TextView docNameTextView, occupationTexView, experienceTextView, avalabilityTextView;
    private Button bookAppoinmentButton;
    private ImageView prfileImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_details);
    }
}
