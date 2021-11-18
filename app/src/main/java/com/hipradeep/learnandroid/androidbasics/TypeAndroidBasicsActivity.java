package com.hipradeep.learnandroid.androidbasics;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.hipradeep.learnandroid.R;
import com.hipradeep.learnandroid.viewpagers.TypeViewPagerActivity;

public class TypeAndroidBasicsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_type_android_basics);
    }

    public void buttonsExam(View view) {

        startActivity(new Intent(this, ButtonsActivity.class ));
    }

    public void onEditText(View view) {
        startActivity(new Intent(this, EditTextActivity.class ));
    }
}