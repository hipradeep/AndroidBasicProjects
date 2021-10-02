package com.hipradeep.learnandroid.drawernavigations;

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
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.hipradeep.learnandroid.R;
import com.hipradeep.learnandroid.fragments.OneFragment;
import com.hipradeep.learnandroid.fragments.ThreeFragment;
import com.hipradeep.learnandroid.fragments.TwoFragment;
import com.hipradeep.learnandroid.notifications.NotificationsActivity;

public class CustomDrawerNavigationActivity extends AppCompatActivity {
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mDrawerToggle;
    private Toolbar toolbar;
    private Fragment currentFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_drawer_navigation);
        mDrawerLayout = findViewById(R.id.drawerLayout);
        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("pradeep");

        //default fragments
        replaceFragment(new OneFragment(), "Home");
        setDrawerToggle();

        setMenuNavigation();
    }

    private void setMenuNavigation() {
        if (!(currentFragment instanceof OneFragment))
      findViewById(R.id.ll_home).setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              mDrawerLayout.closeDrawers();
              replaceFragment(new OneFragment(), "Home");
          }
      });
        if (!(currentFragment instanceof TwoFragment))
        findViewById(R.id.ll_park).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mDrawerLayout.closeDrawers();
                replaceFragment(new TwoFragment(), "Park");
            }
        });
        if (!(currentFragment instanceof ThreeFragment))
        findViewById(R.id.ll_setting).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mDrawerLayout.closeDrawers();
                replaceFragment(new ThreeFragment(), "Setting");
            }
        });

        findViewById(R.id.ll_notification).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), NotificationsActivity.class));
                mDrawerLayout.closeDrawer(GravityCompat.START);
            }
        });

        findViewById(R.id.ll_logout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(CustomDrawerNavigationActivity.this, "Logout!", Toast.LENGTH_SHORT).show();
            }
        });

    }


    private void setDrawerToggle() {
        mDrawerToggle = new ActionBarDrawerToggle(CustomDrawerNavigationActivity.this,
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