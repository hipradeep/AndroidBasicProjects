package com.hipradeep.learnandroid.nestedfragments;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.hipradeep.learnandroid.fragments.NestOneFragment;
import com.hipradeep.learnandroid.fragments.NestTwoFragment;
import com.hipradeep.learnandroid.fragments.NestVP2Fragment;
import com.hipradeep.learnandroid.fragments.OneFragment;
import com.hipradeep.learnandroid.fragments.ThreeFragment;
import com.hipradeep.learnandroid.fragments.TwoFragment;
import com.hipradeep.learnandroid.fragments.WithBtnFragment;

public class NestViewPager2Adapter  extends FragmentStateAdapter {


    public NestViewPager2Adapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return new WithBtnFragment();
            case 1:
                return new NestTwoFragment();

            default: return null;

        }

    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
