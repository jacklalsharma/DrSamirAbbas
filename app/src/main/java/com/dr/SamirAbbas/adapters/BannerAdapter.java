package com.dr.SamirAbbas.adapters;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.dr.SamirAbbas.fragments.BannerFragment;

/**
 * Created by Anurag on 4/14/2018.
 */

public class BannerAdapter extends FragmentPagerAdapter{

    public BannerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Bundle bundle = new Bundle();
        bundle.putInt("pos", position);
        BannerFragment fragment = new BannerFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public int getCount() {
        return 4;
    }
}
