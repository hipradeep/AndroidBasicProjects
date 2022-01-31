package com.hipradeep.learnandroid.androidbasics.lists.v3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.os.Bundle;
import android.util.TypedValue;

import com.google.android.material.tabs.TabLayout;
import com.hipradeep.learnandroid.R;

import java.util.ArrayList;
import java.util.List;

public class RecyclerView3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view3);

        ViewPager pager = findViewById(R.id.viewpager);
        List<String> list=new ArrayList<>();
        list.add("Abc");
        list.add("Abc2");
        list.add("Abc");
        list.add("crf");
        list.add("vfg");
        list.add("xyz");
        list.add("Abc2");
        PagerAdapter adapter = new V3Adapter( list);
        int pagerPadding = 32;
        pager.setClipToPadding(false);
        //pager.setPadding(pagerPadding, 0, pagerPadding, 0);
        pager.setPageMargin(convertDip2Pixels(this,16));
      //  pager.setPageMarginDrawable(Drawable);
        //pager. setPageMarginDrawable(int);

        pager.setAdapter(adapter);

        TabLayout tabLayout = findViewById(R.id.tab_layout);
        tabLayout.setupWithViewPager(pager, true);
    }
    public static int convertDip2Pixels(Context context, int dip) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dip, context.getResources().getDisplayMetrics());
    }
}