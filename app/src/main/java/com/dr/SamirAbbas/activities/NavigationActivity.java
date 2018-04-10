package com.dr.SamirAbbas.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.dr.SamirAbbas.R;

public class NavigationActivity extends BaseActivity implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        toggle.setDrawerIndicatorEnabled(false);
        toggle.setHomeAsUpIndicator(R.drawable.ic_nav); //set your own


        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        findViewById(R.id.bookAppointmentButton).setOnClickListener(this);
        findViewById(R.id.docSearchLayout).setOnClickListener(this);
        findViewById(R.id.servicesLayout).setOnClickListener(this);
        findViewById(R.id.galleryLayout).setOnClickListener(this);
        findViewById(R.id.facilitiesLayout).setOnClickListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //sgetMenuInflater().inflate(R.menu.navigation, menu);
        return true;
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.openDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
                drawer.openDrawer(GravityCompat.START);
                return true;

        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.docSearchLayout) {
            startActivity(new Intent(getActivity(), DoctorSearchListActivity.class));

        } else if(view.getId() == R.id.facilitiesLayout) {
            startActivity(new Intent(getActivity(), FacilitiesActivity.class));

        } else if(view.getId() == R.id.galleryLayout) {
            startActivity(new Intent(getActivity(), GalleryActivity.class));
        } else if(view.getId() == R.id.servicesLayout) {
            startActivity(new Intent(getActivity(), ServicesActivity.class));

        } else if(view.getId() == R.id.bookAppointmentButton) {
            startActivity(new Intent(getActivity(), FindAndBookActivity.class));
        }
    }
}
