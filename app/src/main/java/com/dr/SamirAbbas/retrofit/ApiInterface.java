package com.dr.SamirAbbas.retrofit;

import com.dr.SamirAbbas.retrofitResponse.SpecializationsResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by Anurag on 4/12/2018.
 */

public interface ApiInterface {

@GET("api/booking/v1/specializations")
    Call<SpecializationsResponse> getSpecializationsResponseCall(@Query("specialization") String specialization);
}
