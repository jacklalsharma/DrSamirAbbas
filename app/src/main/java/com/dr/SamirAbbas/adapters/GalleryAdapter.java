package com.dr.SamirAbbas.adapters;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.dr.SamirAbbas.fragments.BannerFragment;
import com.dr.SamirAbbas.fragments.GalleryBannerFragment;

/**
 * Created by Anurag on 4/14/2018.
 */

public class GalleryAdapter extends FragmentPagerAdapter{

    public GalleryAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Bundle bundle = new Bundle();
        bundle.putInt("pos", position);
        GalleryBannerFragment fragment = new GalleryBannerFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public int getCount() {
        return 4;
    }
}
