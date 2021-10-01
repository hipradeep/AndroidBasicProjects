package com.hipradeep.learnandroid.bottomnavigationbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.hipradeep.learnandroid.R;
import com.hipradeep.learnandroid.fragments.OneFragment;
import com.hipradeep.learnandroid.fragments.ThreeFragment;
import com.hipradeep.learnandroid.fragments.TwoFragment;

public class BottomNavigationViewActivity extends AppCompatActivity {


    BottomNavigationView bottomNavigationView;

    private Fragment currentFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_navigation_view);
        bottomNavigationView = findViewById(R.id.bottomNavigationView);

        //default fragments
        replaceFragment(new OneFragment(), "Home");

//
//        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
//            @Override
//            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//
//                switch (item.getItemId()){
//                    case R.id.nav_one:
//                        if (! (currentFragment instanceof OneFragment))
//                        replaceFragment(new OneFragment(), "Home");
//                        break;
//                    case R.id.nav_two:
//                        if (!(currentFragment instanceof TwoFragment))
//                        replaceFragment(new TwoFragment(), "Park");
//                        break;
//                    case R.id.nav_three:
//                        if (!(currentFragment instanceof ThreeFragment))
//                        replaceFragment(new ThreeFragment(), "Setting");
//                        break;
//
//                }
//                return false;
//            }
//        });

        bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
            switch (item.getItemId()){
                case R.id.nav_one:
                    if (! (currentFragment instanceof OneFragment))
                        replaceFragment(new OneFragment(), "Home");
                    break;
                case R.id.nav_two:
                    if (!(currentFragment instanceof TwoFragment))
                        replaceFragment(new TwoFragment(), "Park");
                    break;
                case R.id.nav_three:
                    if (!(currentFragment instanceof ThreeFragment))
                        replaceFragment(new ThreeFragment(), "Setting");
                    break;
            }
            return true;
        });
    }




    public void replaceFragment(Fragment setFragment, String title) {
        //new Handler().postDelayed(() -> {
            currentFragment = setFragment;
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction transaction = fragmentManager.beginTransaction();
            transaction.replace(R.id.container, setFragment, title);
            getSupportActionBar().setTitle(title);
            transaction.commitAllowingStateLoss();
       // }, 200);
    }
}