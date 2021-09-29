package com.hipradeep.viewpagerexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.hipradeep.viewpagerexample.adpaters.ViewPagerRecyclerAdapter;

public class ViewPagerWithRecyclerAdapterActivity extends AppCompatActivity {

    ViewPager2 viewpager;
    RadioGroup radioGroup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager_with_recycler_adpater);
        getSupportActionBar().setTitle("ViewPager W/ RecyclerAdapter");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        radioGroup=findViewById(R.id.radioGroup);
        viewpager=findViewById(R.id.viewpager);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                RadioButton radioButton = (RadioButton)radioGroup.findViewById(checkedId);
                Toast.makeText(ViewPagerWithRecyclerAdapterActivity.this, radioButton.getText(), Toast.LENGTH_SHORT).show();
               if (checkedId ==R.id.hori){

                   viewpager.setOrientation(ViewPager2.ORIENTATION_HORIZONTAL);
               }else if(checkedId == R.id.vert){
                   viewpager.setOrientation(ViewPager2.ORIENTATION_VERTICAL);
               }
                
                
            }
        });
        
        
        viewpager.setOrientation(ViewPager2.ORIENTATION_HORIZONTAL);
        ViewPagerRecyclerAdapter adapter=new ViewPagerRecyclerAdapter(this);
        viewpager.setAdapter(adapter);


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