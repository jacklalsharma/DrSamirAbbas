package com.dr.SamirAbbas.activities;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.dr.SamirAbbas.R;

import java.util.ArrayList;


public class FindAndBookActivity extends BaseActivity {

    private ArrayList<FindAndBook> mList;
    private FindAndBookAdapter adapter;
    private RecyclerView recyclerView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_and_book);


        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        toolbar.setNavigationIcon(R.drawable.ic_back_arrow);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });


        mList = new ArrayList<>();
        adapter = new FindAndBookAdapter(mList, getActivity());
        recyclerView = findViewById(R.id.categoryRecyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());

        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);

        prepareList();

        adapter.notifyDataSetChanged();

    }



    public void prepareList() {
        FindAndBook fb = new FindAndBook("DENTIST");
        mList.add(fb);

        fb = new FindAndBook("WOMEN HEALTH");
        mList.add(fb);

        fb = new FindAndBook("SURGERY");
        mList.add(fb);
    }
}
