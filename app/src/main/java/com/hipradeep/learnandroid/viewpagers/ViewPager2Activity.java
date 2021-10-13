package com.hipradeep.learnandroid.viewpagers;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.hipradeep.learnandroid.R;
import com.hipradeep.learnandroid.viewpagers.adapters.ViewPager2Adapter;

public class ViewPager2Activity extends AppCompatActivity {
    TabLayout tabLayout;
    ViewPager2 myViewPager2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager2);

        getSupportActionBar().setTitle("ViewPager2");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        myViewPager2 = findViewById(R.id.viewpager);
        tabLayout = findViewById(R.id.tabs);
        ViewPager2Adapter adapter = new ViewPager2Adapter(this);
        myViewPager2.setAdapter(adapter);

        String [] tabTitles={"One","Two","Three"};
        new TabLayoutMediator(tabLayout, myViewPager2,
                new TabLayoutMediator.TabConfigurationStrategy() {
                    @Override public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                        tab.setText(tabTitles[position]);
                    }
                }).attach();
        float pageMargin= getResources().getDimensionPixelOffset(R.dimen.pageMargin);
        float pageOffset = getResources().getDimensionPixelOffset(R.dimen.offset);
//        myViewPager2.setPageTransformer((page, position) -> {
//            float myOffset = position * -(2 * pageOffset + pageMargin);
//            if (position < -1) {
//                page.setTranslationX(-myOffset);
//            } else if (position <= 1) {
//                float scaleFactor = Math.max(0.7f, 1 - Math.abs(position - 0.14285715f));
//                page.setTranslationX(myOffset);
//                page.setScaleY(scaleFactor);
//                page.setAlpha(scaleFactor);
//            } else {
//                page.setAlpha(0);
//                page.setTranslationX(myOffset);
//            }
//        });
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