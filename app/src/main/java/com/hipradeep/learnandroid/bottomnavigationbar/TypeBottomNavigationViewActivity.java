package com.hipradeep.learnandroid.bottomnavigationbar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.hipradeep.learnandroid.R;

public class TypeBottomNavigationViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_type_bottom_navigation_view);
        getSupportActionBar().setTitle("Bottom Navigation View");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public void bottomNavigationView(View view) {
        startActivity(new Intent(this, BottomNavigationViewActivity.class ));
    }

    public void customBNV(View view) {
        startActivity(new Intent(this, CustomBottomNavigationActivity.class ));
    }

    public void bottomNavigationWithNavHostFragment(View view) {
        startActivity(new Intent(this, BottomNavigationWithNavHostFragmentsActivity.class ));
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