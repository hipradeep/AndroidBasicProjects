package com.hipradeep.learnandroid.drawernavigations;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationView;
import com.hipradeep.learnandroid.R;
import com.hipradeep.learnandroid.fragments.OneFragment;
import com.hipradeep.learnandroid.fragments.ThreeFragment;
import com.hipradeep.learnandroid.fragments.TwoFragment;
import com.hipradeep.learnandroid.notifications.NotificationsActivity;

public class DrawerNavigationViewActivity extends AppCompatActivity {
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mDrawerToggle;
    private Toolbar toolbar;
    private NavigationView navigationView;
    private View navHeader;
    private Fragment currentFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawer_navigation_view);
        mDrawerLayout = findViewById(R.id.drawerLayout);
        navigationView = findViewById(R.id.nav_view);
        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("pradeep");

        //default fragments
        replaceFragment(new OneFragment(), "Home");
        setDrawerToggle();

        // load nav menu header data
        loadNavHeader();

        // initializing navigation menu
        setUpNavigationView();
    }

    private void setUpNavigationView() {
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                switch (menuItem.getItemId()) {
                    case R.id.nav_one:
                        if (!(currentFragment instanceof OneFragment))
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
                    case R.id.nav_notifications:
                        startActivity(new Intent(getApplicationContext(), NotificationsActivity.class));
                         mDrawerLayout.closeDrawer(GravityCompat.START);
                        return false;
                        ///break;
                }
                mDrawerLayout.closeDrawer(GravityCompat.START);
//
//                if (menuItem.isChecked()) {
//                    menuItem.setChecked(false);
//                } else {
//                    menuItem.setChecked(true);
//                }
//                menuItem.setChecked(true);
                return true;
            }
        });


    }

    private void setDrawerToggle() {
        mDrawerToggle = new ActionBarDrawerToggle(DrawerNavigationViewActivity.this,
                mDrawerLayout, toolbar, R.string.app_name, R.string.app_name) {
            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                Log.e("TAG", "Close");
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                Log.e("TAG", "Open");
            }

        };
        mDrawerLayout.addDrawerListener(mDrawerToggle);
        mDrawerToggle.syncState();
    }

    private void loadNavHeader() {
        // Navigation view header
        navHeader = navigationView.getHeaderView(0);
        TextView txtName = navHeader.findViewById(R.id.name);
        // name, website
        txtName.setText("Maurya");

    }

    private void replaceFragment(Fragment setFragment, String title) {
        //new Handler().postDelayed(() -> {
        currentFragment = setFragment;
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.container, setFragment, title);
        toolbar.setTitle(title);
        transaction.commitAllowingStateLoss();
        // }, 200);
    }
}