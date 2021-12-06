package com.hipradeep.learnandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.hipradeep.learnandroid.androidbasics.TypeAndroidBasicsActivity;
import com.hipradeep.learnandroid.asynctaskexam.TypeAsyncTaskActivity;
import com.hipradeep.learnandroid.bottomnavigationbar.TypeBottomNavigationViewActivity;
import com.hipradeep.learnandroid.bottomsheet.TypeBottomSheetActivity;
import com.hipradeep.learnandroid.drawernavigations.TypeDrawerNavigationViewActivity;
import com.hipradeep.learnandroid.nestedfragments.NestedFragmentsActivity;
import com.hipradeep.learnandroid.nestedfragments.NestedFrgmentUsingVP2Activity;
import com.hipradeep.learnandroid.galleryandcamera.TypeImageActivity;
import com.hipradeep.learnandroid.services.TypeServicesActivity;
import com.hipradeep.learnandroid.viewpagers.ViewPager2Activity;
import com.hipradeep.learnandroid.viewpagers.ViewPagerWithRecyclerAdapterActivity;
import com.hipradeep.learnandroid.viewpagers.TypeViewPagerActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void androidBasic(View view) {
        startActivity(new Intent(this, TypeAndroidBasicsActivity.class ));

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


    public void bottomSheetExample(View view) {
        startActivity(new Intent(this, TypeBottomSheetActivity.class ));
    }

    public void nestedFragments(View view) {
        startActivity(new Intent(this, NestedFragmentsActivity.class ));
    }
    public void nestedVP2Fragments(View view) {
        startActivity(new Intent(this, NestedFrgmentUsingVP2Activity.class ));
    }

    public void openImageActivity(View view) {
        startActivity(new Intent(this, TypeImageActivity.class ));
    }

    public void asyncTask(View view) {
        startActivity(new Intent(this, TypeAsyncTaskActivity.class ));
    }

    public void openService(View view) {
        startActivity(new Intent(this, TypeServicesActivity.class ));
    }
}