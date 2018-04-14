package com.dr.SamirAbbas.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.dr.SamirAbbas.R;

/**
 * Created by Anurag on 4/14/2018.
 */

public class GalleryBannerFragment extends Fragment{

    int res[] = {R.drawable.slider_1, R.drawable.slider_2, R.drawable.slider_3, R.drawable.slider_4};

    public GalleryBannerFragment() {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.banner_item_pager, container, false);
        int pos = getArguments().getInt("pos");
        ((ImageView) view.findViewById(R.id.banner)).setImageResource(res[pos]);
        return view;
    }
}
