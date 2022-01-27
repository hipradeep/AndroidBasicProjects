package com.hipradeep.learnandroid.androidbasics.lists;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.hipradeep.learnandroid.R;
import com.hipradeep.learnandroid.androidbasics.ButtonsActivity;

public class TypeListsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_type_lists);
    }

    public void simpleList(View view) {
        startActivity(new Intent(this, ListViewActivity.class ));
    }

    public void simpleRv(View view) {
        startActivity(new Intent(this, RecyclerViewActivity.class ));
    }

    public void rv2(View view) {
        startActivity(new Intent(this, RecyclerView2Activity.class ));
    }
}