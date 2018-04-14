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

public class BannerFragment extends Fragment{

    int res[] = {R.drawable.home_banner, R.drawable.banner1, R.drawable.banner2, R.drawable.banner4};

    public BannerFragment() {

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
