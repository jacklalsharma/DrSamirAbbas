package com.dr.SamirAbbas.activities;

import android.content.Intent;
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

    int res2[] = {R.drawable.sameer_abbas_gallery_1_1, R.drawable.sameer_abbas_gallery_2_2, R.drawable.sameer_abbas_gallery_3_3,R.drawable.sameer_abbas_gallery_4_4,
            R.drawable.sameer_abbas_gallery_5_5, R.drawable.sameer_abbas_gallery_6_6, R.drawable.sameer_abbas_gallery_7_7, R.drawable.sameer_abbas_gallery_8_8};
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

        findViewById(R.id.one1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), ImageViewerActivity.class);
                intent.putExtra("image", res2[0]);
                intent.putExtra("title", "");
                getActivity().startActivity(intent);
            }
        });


        findViewById(R.id.one2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), ImageViewerActivity.class);
                intent.putExtra("image", res2[1]);
                intent.putExtra("title", "");
                getActivity().startActivity(intent);

            }
        });


        findViewById(R.id.one3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), ImageViewerActivity.class);
                intent.putExtra("image", res2[2]);
                intent.putExtra("title", "");
                getActivity().startActivity(intent);

            }
        });


        findViewById(R.id.one4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), ImageViewerActivity.class);
                intent.putExtra("image", res2[3]);
                intent.putExtra("title", "");
                getActivity().startActivity(intent);

            }
        });


        findViewById(R.id.one5).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), ImageViewerActivity.class);
                intent.putExtra("image", res2[4]);
                intent.putExtra("title", "");
                getActivity().startActivity(intent);

            }
        });


        findViewById(R.id.one6).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getActivity(), ImageViewerActivity.class);
                intent.putExtra("image", res2[5]);
                intent.putExtra("title", "");
                getActivity().startActivity(intent);
            }
        });




        findViewById(R.id.one7).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), ImageViewerActivity.class);
                intent.putExtra("image", res2[6]);
                intent.putExtra("title", "");
                getActivity().startActivity(intent);

            }
        });

        findViewById(R.id.one8).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), ImageViewerActivity.class);
                intent.putExtra("image", res2[7]);
                intent.putExtra("title", "");
                getActivity().startActivity(intent);

            }
        });

    }
}
