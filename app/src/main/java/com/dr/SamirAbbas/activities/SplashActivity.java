package com.dr.SamirAbbas.activities;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;

import com.dr.SamirAbbas.R;

import java.util.Locale;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        findViewById(R.id.english).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Resources res = getResources();
                DisplayMetrics dm = res.getDisplayMetrics();
                Configuration configuration = res.getConfiguration();
                BaseActivity.IsEnglish = true;
                configuration.locale = new Locale("en");
                res.updateConfiguration(configuration, dm);
                startActivity(new Intent(SplashActivity.this, NavigationActivity.class));
            }
        });

        findViewById(R.id.arabic).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Resources res = getResources();
                DisplayMetrics dm = res.getDisplayMetrics();
                Configuration configuration = res.getConfiguration();
                BaseActivity.IsEnglish = false;
                configuration.locale = new Locale("ar");
                res.updateConfiguration(configuration, dm);

                startActivity(new Intent(SplashActivity.this, NavigationActivity.class));
            }
        });
    }
}
