package com.Eco.eco_farm.Flock_Manager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.Eco.eco_farm.Models.flock_details_model;
import com.Eco.eco_farm.R;
import com.Eco.eco_farm.Response.flock_details_response;
import com.Eco.eco_farm.Utility.AppUtilits;
import com.Eco.eco_farm.Utility.NetworkUtility;
import com.Eco.eco_farm.WebServices.ServiceWrapper;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.gson.Gson;
import java.util.ArrayList;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class flock_details extends AppCompatActivity {

    private TextView mTextMessage;
    RecyclerView flock_recycler;
    FloatingActionButton flock_fab;
    ProgressBar progressbar;
    String TAG = "flock_details";
    private  flock_details_adapter flock_details_adapter;
    private ArrayList<flock_details_model> flockdetailsModels = new ArrayList<>();


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:

                    return true;
                case R.id.navigation_dashboard:

                    return true;
                case R.id.navigation_notifications:
                  //  mTextMessage.setText(R.string.title_notifications);
                    return true;
            }
            return false;
        }
    };



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.flock_manager_activity_flock_details);

        BottomNavigationView navView = findViewById(R.id.nav_view);
        progressbar = findViewById(R.id.progressBar);

        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        flock_fab = findViewById(R.id.flock_fab);
        flock_recycler = findViewById(R.id.flock_recycler);

        flock_fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(flock_details.this, add_flock.class);
                startActivity(intent);
            }
        });


        LinearLayoutManager mLayoutManger3 = new LinearLayoutManager( this, RecyclerView.VERTICAL, false);
        flock_recycler.setLayoutManager(mLayoutManger3);
        flock_recycler.setItemAnimator(new DefaultItemAnimator());

       flock_details_adapter = new flock_details_adapter(this, flockdetailsModels);
       flock_recycler.setAdapter(flock_details_adapter);







        getFlockDetails();


    }

    public void getFlockDetails() {
        progressbar.setVisibility(View.VISIBLE);

        if (!NetworkUtility.isNetworkConnected(flock_details.this)) {
            progressbar.setVisibility(View.GONE);
            Toast.makeText(getApplicationContext(), "Network error", Toast.LENGTH_LONG).show();


        } else {
            progressbar.setVisibility(View.GONE);
            //  Log.e(TAG, "  user value "+ SharePreferenceUtils.getInstance().getString(Constant.USER_DATA));
            ServiceWrapper service = new ServiceWrapper(null);
            Call<flock_details_response> call = service.GetFlockDataCall("1234", "10005");

            call.enqueue(new Callback<flock_details_response>() {
                @Override
                public void onResponse(Call<flock_details_response> call, Response<flock_details_response> response) {
                    Log.e(TAG, "response is " + response.body() + "  ---- " + new Gson().toJson(response.body()));
                    Log.e(TAG, "  ss sixe 1 ");
                    if (response.body() != null && response.isSuccessful()) {

                        Log.e(TAG, "  ss sixe 2 ");
                        if (response.body().getStatus() == 1) {
                            Log.e(TAG, "  ss sixe 3 ");


                            if (response.body().getInformation().size()>0){

                                progressbar.setVisibility(View.GONE);

                                flockdetailsModels.clear();
                                for (int i =0; i<response.body().getInformation().size(); i++){


                                    flockdetailsModels.add(  new flock_details_model(response.body().getInformation().get(i).getFlockId(), response.body().getInformation().get(i).getFlockName(),
                                            response.body().getInformation().get(i).getFlockBreed(), response.body().getInformation().get(i).getFlockSource(), response.body().getInformation().get(i).getChickQty(), response.body().getInformation().get(i).getHenQty(), response.body().getInformation().get(i).getCockQty(), response.body().getInformation().get(i).getFlockDescription(), response.body().getInformation().get(i).getAcquiredDate(), response.body().getInformation().get(i).getRegistrationDate()) );



                                }
                                flock_details_adapter.notifyDataSetChanged();
                            }

                        } else {
                            progressbar.setVisibility(View.GONE);
                            AppUtilits.displayMessage(flock_details.this, response.body().getMsg());
                        }
                    } else {
                        progressbar.setVisibility(View.GONE);
                        Toast.makeText(getApplicationContext(), "Please try again", Toast.LENGTH_LONG).show();
                    }

                }

                @Override
                public void onFailure(Call<flock_details_response> call, Throwable t) {
                    progressbar.setVisibility(View.GONE);
                    Log.e(TAG, "  fail- add to cart item " + t.toString());
                    Toast.makeText(getApplicationContext(), "please try again. Failed to get user cart details ", Toast.LENGTH_LONG).show();

                }
            });


        }
    }
}
