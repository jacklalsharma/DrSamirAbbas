package com.dr.SamirAbbas.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ImageView;
import android.widget.TextView;

import com.dr.SamirAbbas.R;

public class ImageViewerActivity extends BaseActivity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_image);

        int image = getIntent().getIntExtra("image", R.drawable.women);
        ((ImageView) findViewById(R.id.image)).setImageResource(image);

        String text = getIntent().getStringExtra("title");
        ((TextView) findViewById(R.id.title)).setText(text);

    }
}
