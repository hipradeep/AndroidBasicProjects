package com.hipradeep.learnandroid.androidbasics.splashscreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.hipradeep.learnandroid.R;

public class SimpleSplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_splash_screen);

        //hide action bar
        getSupportActionBar().hide();

        //start new Activity after 3 sec
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(SimpleSplashScreenActivity.this, EmptyActivity.class));
                finish();
            }
        },3000);
    }
}