package com.hipradeep.learnandroid.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hipradeep.learnandroid.R;
import com.hipradeep.learnandroid.nestedfragments.NestViewPager2Adapter;
import com.hipradeep.learnandroid.nestedfragments.NestViewPagerAdapter;
import com.hipradeep.learnandroid.viewpagers.adapters.ViewPager2Adapter;


public class NestVP2Fragment extends Fragment {

    private NestViewPager2Adapter viewPagerAdapter;
    private ViewPager2 viewpager2_nest;
    public NestVP2Fragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_nest_v_p2, container, false);
        viewpager2_nest = view.findViewById(R.id.viewpager2_nest);

        NestViewPager2Adapter adapter = new NestViewPager2Adapter((FragmentActivity) getContext());

        viewpager2_nest.setAdapter(adapter);

        return  view;
    }
}