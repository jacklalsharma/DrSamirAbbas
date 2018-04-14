package com.dr.SamirAbbas.activities;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ViewSwitcher;

import com.dr.SamirAbbas.R;
import com.dr.SamirAbbas.adapters.GalleryAdapter;

public class GalleryActivity extends BaseActivity {

    private ViewPager pager;
    private ImageView b1,b2;

    int res[] = {R.drawable.slider_1, R.drawable.slider_2, R.drawable.slider_3, R.drawable.slider_4};
    int pos = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);

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

        b1 = findViewById(R.id.lSwipe);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(pos >= 1){
                    pos--;
                    pager.setCurrentItem(pos, true);
                }
            }
        });

        b2 = findViewById(R.id.rSwipe);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(pos < 3){
                    pos++;
                    pager.setCurrentItem(pos, true);
                }
            }
        });

        pager = findViewById(R.id.banner);
        pager.setAdapter(new GalleryAdapter(getSupportFragmentManager()));

    }
}
