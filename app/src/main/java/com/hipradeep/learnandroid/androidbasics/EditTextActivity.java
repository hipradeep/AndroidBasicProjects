package com.hipradeep.learnandroid.androidbasics;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;


import com.hipradeep.learnandroid.R;

public class EditTextActivity extends AppCompatActivity {


    String[] language ={"C","C++","Java",".NET","iPhone","Android","ASP.NET","PHP"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_text);

//Creating the instance of ArrayAdapter containing list of language names
        ArrayAdapter<String> adapter = new ArrayAdapter<String>
                (this,android.R.layout.select_dialog_item,language);
        //Getting the instance of AutoCompleteTextView
        AutoCompleteTextView actv =  (AutoCompleteTextView)findViewById(R.id.autoCompleteTextView);
        actv.setThreshold(1);//will start working from first character
        actv.setAdapter(adapter);//setting the adapter data into the AutoCompleteTextView
        actv.setTextColor(Color.RED);
    }


}