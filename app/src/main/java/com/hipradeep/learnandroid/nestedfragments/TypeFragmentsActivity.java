package com.hipradeep.learnandroid.nestedfragments;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.hipradeep.learnandroid.R;

public class TypeFragmentsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_type_fragments);
    }

    public void nestedFragments(View view) {
        startActivity(new Intent(this, NestedFragmentsActivity.class ));
    }
    public void nestedVP2Fragments(View view) {
        startActivity(new Intent(this, NestedFrgmentUsingVP2Activity.class ));
    }

    public void tabFragments(View view) {
        startActivity(new Intent(this, FragmentsWithTabActivity.class ));
    }
}