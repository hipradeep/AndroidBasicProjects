package com.hipradeep.learnandroid.androidbasics;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.hipradeep.learnandroid.R;
import com.hipradeep.learnandroid.androidbasics.alert_n_dialog.AlertAndDialogsActivity;
import com.hipradeep.learnandroid.androidbasics.autoimageslider.AutoImageSliderActivity;
import com.hipradeep.learnandroid.androidbasics.lists.RecyclerViewActivity;
import com.hipradeep.learnandroid.androidbasics.onboarding.OnBoardingActivity;
import com.hipradeep.learnandroid.androidbasics.splashscreen.SimpleSplashScreenActivity;

public class TypeAndroidBasicsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_type_android_basics);
    }

    public void buttonsExam(View view) {

        startActivity(new Intent(this, ButtonsActivity.class ));
    }
    public void openRecyclerActivity(View view) {
        startActivity(new Intent(this, RecyclerViewActivity.class ));
    }

    public void onEditText(View view) {
        startActivity(new Intent(this, EditTextActivity.class ));
    }

    public void openAlertDialogActivity(View view) {
        startActivity(new Intent(this, AlertAndDialogsActivity.class ));
    }

    public void openAutoImageSliderActivity(View view) {
        startActivity(new Intent(this, AutoImageSliderActivity.class ));

    }
    public void openOnBoardingActivity(View view) {
        startActivity(new Intent(this, OnBoardingActivity.class ));

    }

    public void openSplashActivity(View view) {
        startActivity(new Intent(this, SimpleSplashScreenActivity.class ));
    }
}