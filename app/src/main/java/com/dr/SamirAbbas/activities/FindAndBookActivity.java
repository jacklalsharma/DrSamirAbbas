package com.dr.SamirAbbas.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.dr.SamirAbbas.R;
import com.dr.SamirAbbas.models.Specializations;
import com.dr.SamirAbbas.utils.DialogBox;
import com.dr.SamirAbbas.utils.Endpoints;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


public class FindAndBookActivity extends BaseActivity {

    private ArrayList<Specializations.Specialization> mList;
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
        getList();

        findViewById(R.id.searchDocText).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mList == null){
                    Toast.makeText(getActivity(), R.string.something_wrong, Toast.LENGTH_SHORT).show();
                }else{
                    Intent intent = new Intent(getActivity(), SearchDoctorActivity.class);
                    intent.putExtra("position", 0);
                    intent.putParcelableArrayListExtra("list", mList);
                    startActivity(intent);
                }
            }
        });
    }

    private void getList(){
        DialogBox.ShowProgressDialog(this, R.string.getting_special, R.string.getting_special_msg);

        Ion.with(this)
                .load("GET", Endpoints.SpecialityList)
                .setJsonObjectBody(new JsonObject())
                .asJsonObject()
                .setCallback(new FutureCallback<JsonObject>() {
                    @Override
                    public void onCompleted(Exception e, JsonObject result) {
                        DialogBox.DismissProgressDialog();
                        if(result != null){
                            try{
                                JSONObject object = new JSONObject(result.toString());
                                if(object.getBoolean("success")){
                                    Specializations specializations = new Gson().fromJson(object.toString(), Specializations.class);
                                    mList.addAll(specializations.getData().getSpecializations());
                                    adapter.notifyDataSetChanged();
                                }else{

                                }
                            }catch (JSONException e1){

                            }


                        }else{
                            //Failed...
                        }
                    }
                });
    }

}
