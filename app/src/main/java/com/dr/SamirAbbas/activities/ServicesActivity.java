package com.dr.SamirAbbas.activities;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;

import com.dr.SamirAbbas.R;

public class ServicesActivity extends BaseActivity implements View.OnClickListener {

    private LinearLayout innerLayout, innerLayout2, innerLayout3, innerLayout4;
    private boolean isOpen, isOpen2, isOpen3, isOpen4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_services);

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

        innerLayout = findViewById(R.id.layout);
        innerLayout2 = findViewById(R.id.layout2);
        innerLayout3 = findViewById(R.id.layout3);
        innerLayout4 = findViewById(R.id.layout4);

        isOpen = true;
        isOpen2 = true;
        isOpen3 = true;
        isOpen4 = true;

        findViewById(R.id.layout).setOnClickListener(this);
        findViewById(R.id.layout2).setOnClickListener(this);
        findViewById(R.id.layout3).setOnClickListener(this);
        findViewById(R.id.layout4).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.layout) {

            if (isOpen) {
                innerLayout.setBackgroundColor(getResources().getColor(R.color.background));
                findViewById(R.id.image).setVisibility(View.VISIBLE);
                findViewById(R.id.text).setVisibility(View.VISIBLE);
                findViewById(R.id.viewMoreImageView).setBackground(getResources().getDrawable(R.drawable.draw_up));
                isOpen = false;
            } else {
                innerLayout.setBackgroundColor(getResources().getColor(R.color.white));
                findViewById(R.id.image).setVisibility(View.GONE);
                findViewById(R.id.text).setVisibility(View.GONE);
                findViewById(R.id.viewMoreImageView).setBackground(getResources().getDrawable(R.drawable.drop_down));
                isOpen = true;
            }

        } else if (view.getId() == R.id.layout2) {

            if (isOpen2) {
                innerLayout2.setBackgroundColor(getResources().getColor(R.color.background));
                findViewById(R.id.image2).setVisibility(View.VISIBLE);
                findViewById(R.id.text2).setVisibility(View.VISIBLE);
                findViewById(R.id.viewMoreImageView2).setBackground(getResources().getDrawable(R.drawable.draw_up));
                isOpen2 = false;

            } else {
                innerLayout2.setBackgroundColor(getResources().getColor(R.color.white));
                findViewById(R.id.image2).setVisibility(View.GONE);
                findViewById(R.id.text2).setVisibility(View.GONE);
                findViewById(R.id.viewMoreImageView2).setBackground(getResources().getDrawable(R.drawable.drop_down));
                isOpen2 = true;
            }

        } else if(view.getId() == R.id.layout3) {

            if (isOpen3) {
                innerLayout3.setBackgroundColor(getResources().getColor(R.color.background));
                findViewById(R.id.image3).setVisibility(View.VISIBLE);
                findViewById(R.id.text3).setVisibility(View.VISIBLE);
                findViewById(R.id.viewMoreImageView3).setBackground(getResources().getDrawable(R.drawable.draw_up));
                isOpen3 = false;
            } else {
                innerLayout3.setBackgroundColor(getResources().getColor(R.color.white));
                findViewById(R.id.image3).setVisibility(View.GONE);
                findViewById(R.id.text3).setVisibility(View.GONE);
                findViewById(R.id.viewMoreImageView3).setBackground(getResources().getDrawable(R.drawable.drop_down));
                isOpen3 = true;
            }

        } else if (view.getId() == R.id.layout4) {

            if (isOpen4) {
                innerLayout4.setBackgroundColor(getResources().getColor(R.color.background));
                findViewById(R.id.image4).setVisibility(View.VISIBLE);
                findViewById(R.id.text4).setVisibility(View.VISIBLE);
                findViewById(R.id.viewMoreImageView4).setBackground(getResources().getDrawable(R.drawable.draw_up));
                isOpen4 = false;
            } else {
                innerLayout4.setBackgroundColor(getResources().getColor(R.color.white));
                findViewById(R.id.image4).setVisibility(View.GONE);
                findViewById(R.id.text4).setVisibility(View.GONE);
                findViewById(R.id.viewMoreImageView4).setBackground(getResources().getDrawable(R.drawable.drop_down));
                isOpen4 = true;
            }
        }
    }
}
