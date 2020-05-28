package com.Eco.eco_farm.Flock_Manager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.Eco.eco_farm.R;
import com.Eco.eco_farm.Response.NewFlockRegistration;
import com.Eco.eco_farm.Utility.NetworkUtility;
import com.Eco.eco_farm.WebServices.ServiceWrapper;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class add_flock extends AppCompatActivity {

        EditText flockname_edit, flockbreed_edit,flocksource_edit, chick_qty_edit, hen_qty_edit, cock_qty_edit, description_edit, acquired_date;
        String TAG = "add_flock";
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:

                    return true;
                case R.id.navigation_dashboard:

                    sendNewRegistrationReq();

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
        setContentView(R.layout.flock_manager_add_flock);

        BottomNavigationView navView = findViewById(R.id.nav_view);


        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        flockname_edit = findViewById(R.id.flockname_edit);
        flockbreed_edit = findViewById(R.id.flockbreed_edit);
        flocksource_edit = findViewById(R.id.flocksource_edit);
        chick_qty_edit = findViewById(R.id.chick_qty_edit);
        hen_qty_edit = findViewById(R.id.hen_qty_edit);
        cock_qty_edit = findViewById(R.id.cock_qty_edit);
        description_edit = findViewById(R.id.description_edit);
       acquired_date = findViewById(R.id.acquired_edit);



    }


    public void sendNewRegistrationReq(){



        if (!NetworkUtility.isNetworkConnected(add_flock.this)){
            Toast.makeText(getApplicationContext(),"Network error",Toast.LENGTH_LONG).show();


        }else {

            ServiceWrapper serviceWrapper = new ServiceWrapper(null);
            Call<NewFlockRegistration> callNewREgistration=   serviceWrapper.newFlockRegistrationCall( "12345",flockname_edit.getText().toString(),flockbreed_edit.getText().toString(),flocksource_edit.getText().toString(),chick_qty_edit.getText().toString(),hen_qty_edit.getText().toString(),cock_qty_edit.getText().toString(),description_edit.getText().toString(),acquired_date.getText().toString(),"10005"  );
            callNewREgistration.enqueue(new Callback<NewFlockRegistration>() {
                @Override
                public void onResponse(Call<NewFlockRegistration> call, Response<NewFlockRegistration> response) {
                    Log.d(TAG, "reponse : "+ response.toString());
                    if (response.body()!= null && response.isSuccessful()){
                        if (response.body().getStatus() ==1){

                            Toast.makeText(getApplicationContext(),"Successful",Toast.LENGTH_LONG).show();
                            Intent intent = new Intent(add_flock.this, flock_details.class);
                            startActivity(intent);
                            finish();

                        }else {


                            Toast.makeText(getApplicationContext(), response.body().getMsg(),Toast.LENGTH_LONG).show();
                        }
                    }else {

                        Toast.makeText(getApplicationContext(),"Request failed",Toast.LENGTH_LONG).show();

                    }
                }

                @Override
                public void onFailure(Call<NewFlockRegistration> call, Throwable t) {

                    Log.e(TAG, " failure "+ t.toString());
                    Toast.makeText(getApplicationContext(),"Request failed",Toast.LENGTH_LONG).show();


                }
            });
        }


    }
}
