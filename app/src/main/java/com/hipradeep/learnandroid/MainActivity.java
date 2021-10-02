package com.hipradeep.learnandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.hipradeep.learnandroid.bottomnavigationbar.TypeBottomNavigationViewActivity;
import com.hipradeep.learnandroid.drawernavigations.TypeDrawerNavigationViewActivity;
import com.hipradeep.learnandroid.viewpagers.ViewPager2Activity;
import com.hipradeep.learnandroid.viewpagers.ViewPagerWithRecyclerAdapterActivity;
import com.hipradeep.learnandroid.viewpagers.TypeViewPagerActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void viewPagers(View view) {
        startActivity(new Intent(this, TypeViewPagerActivity.class ));

    }

    public void viewpager2(View view) {
        startActivity(new Intent(this, ViewPager2Activity.class ));
    }

    public void viewpagerWithRecyclerAdapter(View view) {
        startActivity(new Intent(this, ViewPagerWithRecyclerAdapterActivity.class ));
    }

    public void bottomNavigationBar(View view) {
        startActivity(new Intent(this, TypeBottomNavigationViewActivity.class ));
    }

    public void drawerNavigationView(View view) {
        startActivity(new Intent(this, TypeDrawerNavigationViewActivity.class ));
    }
}