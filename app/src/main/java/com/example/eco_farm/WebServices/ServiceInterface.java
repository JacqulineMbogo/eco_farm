package com.example.eco_farm.WebServices;

import com.example.eco_farm.Response.NewFlockRegistration;
import com.example.eco_farm.Response.flock_details_response;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface ServiceInterface {

    // method,, return type ,, secondary url

    @Multipart
    @POST("EcoFarm/get_flock_data.php")
    Call<flock_details_response> GetFlockDataCall(
            @Part("securecode") RequestBody securecode,
            @Part("user_id") RequestBody user_id

    );

    @Multipart
    @POST("EcoFarm/new_flock_registration.php")
    Call<NewFlockRegistration> NewFlockRegistrationCall(
            @Part("securecode") RequestBody securecode,
            @Part("flock_name") RequestBody flock_name,
            @Part("flock_breed") RequestBody flock_breed,
            @Part("flock_source") RequestBody flock_sourcel,
            @Part("chick_qty") RequestBody chick_qty,
            @Part("hen_qty") RequestBody hen_qty,
            @Part("cock_qty") RequestBody cock_qty,
            @Part("flock_description") RequestBody flock_description,
            @Part("acquired_date") RequestBody acquired_date,
              @Part("user_id") RequestBody user_id
    );





}




