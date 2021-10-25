package com.hipradeep.learnandroid.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hipradeep.learnandroid.R;
import com.hipradeep.learnandroid.nestedfragments.NestViewPagerAdapter;
import com.hipradeep.learnandroid.viewpagers.adapters.ViewPagerAdapter;

public class NestFragment extends Fragment {

    private NestViewPagerAdapter viewPagerAdapter;
    private ViewPager viewpager_nest;
    public NestFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_nest, container, false);

        viewpager_nest = view.findViewById(R.id.viewpager_nest);
        viewPagerAdapter = new NestViewPagerAdapter(getChildFragmentManager());

        // add the fragments
        viewPagerAdapter.add(new NestOneFragment());
        viewPagerAdapter.add(new NestTwoFragment());


        // Set the adapter
        viewpager_nest.setAdapter(viewPagerAdapter);



        return view;
    }
}