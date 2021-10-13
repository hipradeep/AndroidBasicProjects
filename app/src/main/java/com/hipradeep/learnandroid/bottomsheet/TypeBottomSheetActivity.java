package com.hipradeep.learnandroid.bottomsheet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.hipradeep.learnandroid.R;

public class TypeBottomSheetActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_type_bottom_sheet);
    }

    public void bottomSheet(View view) {
       // startActivity(new Intent(this, BottomSheetActivity.class));
        BottomSheetWithFragments bottomSheet = new BottomSheetWithFragments(TypeBottomSheetActivity.this);
        bottomSheet.show(getSupportFragmentManager(), "ModalBottomSheet");



    }
}