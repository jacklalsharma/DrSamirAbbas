package com.dr.SamirAbbas.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import com.dr.SamirAbbas.R;

public class FetchDateActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fetch_date);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.dateRecyclerView);


    }
}
