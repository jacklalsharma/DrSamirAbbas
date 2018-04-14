package com.dr.SamirAbbas.activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.dr.SamirAbbas.R;
import com.dr.SamirAbbas.adapters.BannerAdapter;

public class NavigationActivity extends BaseActivity implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener{

    private ViewPager viewPager;


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

        navigationView.findViewById(R.id.galleryLayout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
                drawer.closeDrawer(GravityCompat.START);
                startActivity(new Intent(getActivity(), GalleryActivity.class));
            }
        });

        navigationView.findViewById(R.id.servicesLayout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
                drawer.closeDrawer(GravityCompat.START);
                startActivity(new Intent(getActivity(), ServicesActivity.class));
            }
        });

        navigationView.findViewById(R.id.contactLayout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
                drawer.closeDrawer(GravityCompat.START);
                startActivity(new Intent(getActivity(), ContactUsActivity.class));
            }
        });

        navigationView.findViewById(R.id.shareLayout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
                drawer.closeDrawer(GravityCompat.START);

            }
        });

        navigationView.findViewById(R.id.homeLayout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
                drawer.closeDrawer(GravityCompat.START);

            }
        });

        navigationView.findViewById(R.id.aboutUSLayout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
                drawer.closeDrawer(GravityCompat.START);

            }
        });

        viewPager = findViewById(R.id.banner);
        viewPager.setAdapter(new BannerAdapter(getSupportFragmentManager()));

        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                viewPager.setCurrentItem((viewPager.getCurrentItem() + 1) % 4 , true);
                handler.postDelayed(this, 2000);
            }
        }, 2000);

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
            Intent intent = new Intent(getActivity(), SearchDoctorActivity.class);
            intent.putParcelableArrayListExtra("list", null);
            intent.putExtra("position", 0);
            startActivity(intent);

        } else if(view.getId() == R.id.facilitiesLayout) {
            startActivity(new Intent(getActivity(), ContactUsActivity.class));

        } else if(view.getId() == R.id.galleryLayout) {
            startActivity(new Intent(getActivity(), GalleryActivity.class));
        } else if(view.getId() == R.id.servicesLayout) {
            startActivity(new Intent(getActivity(), ServicesActivity.class));

        } else if(view.getId() == R.id.bookAppointmentButton) {
            startActivity(new Intent(getActivity(), FindAndBookActivity.class));
        }
    }
}
