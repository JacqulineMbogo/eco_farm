package com.example.eco_farm;

import android.content.Intent;
import android.os.Bundle;

import com.example.eco_farm.Collection_Manager.egg_collections;
import com.example.eco_farm.Flock_Manager.flock_details;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;

import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity {

   CardView flockcard, eggcard;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                  //  mTextMessage.setText(R.string.title_home);
                    return true;
                case R.id.navigation_dashboard:
                   // mTextMessage.setText(R.string.title_dashboard);
                    return true;
                case R.id.navigation_notifications:
                   // mTextMessage.setText(R.string.title_notifications);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView navView = findViewById(R.id.nav_view);

        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        flockcard = findViewById(R.id.flockcard);
        eggcard = findViewById(R.id.feggcard);

        flockcard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this, flock_details.class);
                startActivity(intent);
            }
        });
        eggcard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this, egg_collections.class);
                startActivity(intent);
            }
        });
    }

}
