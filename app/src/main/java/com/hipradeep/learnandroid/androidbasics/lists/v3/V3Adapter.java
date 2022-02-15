package com.hipradeep.learnandroid.androidbasics.lists.v3;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.hipradeep.learnandroid.R;

import java.util.List;

public class V3Adapter extends PagerAdapter {
    List<String> list;

    public V3Adapter(List<String> list) {
        this.list = list;
    }

    @Override
    public float getPageWidth(int position) {
        return (super.getPageWidth(position) / 2);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull final ViewGroup container, int position) {

        View view= LayoutInflater.from(container.getContext()).inflate(R.layout.vp_item_layout,container,false);

        TextView textView=view.findViewById(R.id.textView6);
        textView.setText(list.get(position));
        container.addView(view,0);
        return view;

    }

    @Override
    public int getCount() {
            return list.size();
    }
    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }


    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view==object;
    }
}
