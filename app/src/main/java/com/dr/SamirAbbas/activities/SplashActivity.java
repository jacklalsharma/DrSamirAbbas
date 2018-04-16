package com.dr.SamirAbbas.activities;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;

import com.dr.SamirAbbas.R;
import com.dr.SamirAbbas.utils.Endpoints;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.gson.JsonObject;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;

import java.util.Locale;

import static com.dr.SamirAbbas.services.MyFirebaseInstanceIdService.getUniquePsuedoID;

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

        String refreshedToken = FirebaseInstanceId.getInstance().getToken();
        updateToken(refreshedToken);

    }

    private void updateToken(String token){

        JsonObject object = new JsonObject();
        object.addProperty("unique_device_id", getUniquePsuedoID());
        object.addProperty("device_token", token);
        object.addProperty("device_type","ANDROID");

        Ion.with(this)
                .load("POST", Endpoints.SavePushToken)
                .setJsonObjectBody(object)
                .asJsonObject()
                .setCallback(new FutureCallback<JsonObject>() {
                    @Override
                    public void onCompleted(Exception e, JsonObject result) {
                        Log.d("RESULT", result.toString());
                    }
                });
    }
}
