package com.Eco.eco_farm.WebServices;

import com.Eco.eco_farm.BuildConfig;
import com.Eco.eco_farm.Response.NewFlockRegistration;
import com.Eco.eco_farm.Response.flock_details_response;
import com.Eco.eco_farm.Utility.Constant;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;



public class ServiceWrapper  {

    private ServiceInterface mServiceInterface;

    public ServiceWrapper(Interceptor mInterceptorheader) {
        mServiceInterface = getRetrofit(mInterceptorheader).create(ServiceInterface.class);
    }

    public Retrofit getRetrofit(Interceptor mInterceptorheader) {
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient mOkHttpClient = null;
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.connectTimeout(Constant.API_CONNECTION_TIMEOUT, TimeUnit.SECONDS);
        builder.readTimeout(Constant.API_READ_TIMEOUT, TimeUnit.SECONDS);

//        if (BuildConfig.DEBUG)
//            builder.addInterceptor(loggingInterceptor);

        if (BuildConfig.DEBUG) {
//            HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            builder.addInterceptor(loggingInterceptor);
        }


        mOkHttpClient = builder.build();
        Gson gson = new GsonBuilder().create();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constant.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(mOkHttpClient)
                .build();
        return retrofit;
    }

    public Call<flock_details_response> GetFlockDataCall(String securecode,String user_id){
        return mServiceInterface.GetFlockDataCall(convertPlainString(securecode), convertPlainString(user_id));
    }

    public Call<NewFlockRegistration> newFlockRegistrationCall(String securecode, String flock_name, String flock_breed, String flock_source, String chick_qty, String hen_qty, String cock_qty, String flock_description, String acquired_date, String user_id){
        return mServiceInterface.NewFlockRegistrationCall(convertPlainString(securecode),convertPlainString(flock_name), convertPlainString(flock_breed),convertPlainString(flock_source), convertPlainString(chick_qty),convertPlainString(hen_qty), convertPlainString(cock_qty), convertPlainString(flock_description), convertPlainString(acquired_date), convertPlainString(user_id));
    }

    // convert aa param into plain text
    public RequestBody convertPlainString(String data){
        RequestBody plainString = RequestBody.create(MediaType.parse("text/plain"), data);
        return  plainString;
    }


}


