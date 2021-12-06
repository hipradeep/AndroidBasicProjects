package com.hipradeep.learnandroid.services;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.hipradeep.learnandroid.R;

public class TypeServicesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_type_services);
    }

    public void openRingtone(View view) {
        startActivity(new Intent(this, RingtoneActivity.class));
    }
}