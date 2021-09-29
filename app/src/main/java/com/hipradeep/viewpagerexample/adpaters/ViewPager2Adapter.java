package com.hipradeep.viewpagerexample.adpaters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.hipradeep.viewpagerexample.fragments.OneFragment;
import com.hipradeep.viewpagerexample.fragments.ThreeFragment;
import com.hipradeep.viewpagerexample.fragments.TwoFragment;

import java.security.acl.Owner;

public class ViewPager2Adapter extends FragmentStateAdapter {


    public ViewPager2Adapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return new OneFragment();
            case 1:
                return new TwoFragment();
            case 2:
                return new ThreeFragment();
            default: return null;

        }

    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
