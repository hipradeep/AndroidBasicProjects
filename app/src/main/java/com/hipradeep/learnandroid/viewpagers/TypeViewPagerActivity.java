package com.hipradeep.learnandroid.viewpagers;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.hipradeep.learnandroid.R;

public class TypeViewPagerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_type_view_pager_activty);

        getSupportActionBar().setTitle("View Pagers");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
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
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}