package com.hipradeep.learnandroid.nestedfragments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.hipradeep.learnandroid.R;
import com.hipradeep.learnandroid.fragments.NestFragment;
import com.hipradeep.learnandroid.fragments.OneFragment;
import com.hipradeep.learnandroid.fragments.ThreeFragment;
import com.hipradeep.learnandroid.fragments.TwoFragment;

public class NestedFragmentsActivity extends AppCompatActivity {

    private Fragment currentFragment;
    BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nested_fragments);
        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        getSupportActionBar().setTitle("Nested Fragments");
        //default fragments
        replaceFragment(new NestFragment(), "Home");

        bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
            switch (item.getItemId()){
                case R.id.nav_one:
                    if (! (currentFragment instanceof OneFragment))
                        replaceFragment(new NestFragment(), "Home");
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
    //    getSupportActionBar().setTitle(title);
        transaction.commitAllowingStateLoss();
        // }, 200);
    }
}