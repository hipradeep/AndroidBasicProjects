package com.hipradeep.learnandroid.drawernavigations;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.hipradeep.learnandroid.R;
import com.hipradeep.learnandroid.bottomnavigationbar.BottomNavigationViewActivity;
import com.hipradeep.learnandroid.bottomnavigationbar.CustomBottomNavigationActivity;

public class TypeDrawerNavigationViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_type_drawer_navigation_bar);
        getSupportActionBar().setTitle("Drawer Navigation View");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
    public void drawerNavigationView(View view) {
        startActivity(new Intent(this, DrawerNavigationViewActivity.class ));
    }

    public void drawerWithNavController(View view) {
        startActivity(new Intent(this, DrawerWithNavControllerActivity.class ));
    }
    public void customNavigationView(View view) {
        startActivity(new Intent(this, CustomDrawerNavigationActivity.class ));
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}