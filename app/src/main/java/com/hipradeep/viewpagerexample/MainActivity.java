package com.hipradeep.viewpagerexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void viewpager(View view) {
        startActivity(new Intent(this, ViewPagerActivity.class ));

    }

    public void viewpager2(View view) {
        startActivity(new Intent(this, ViewPager2Activity.class ));
    }

    public void viewpagerWithRecyclerAdapter(View view) {
        startActivity(new Intent(this, ViewPagerWithRecyclerAdapterActivity.class ));
    }
}