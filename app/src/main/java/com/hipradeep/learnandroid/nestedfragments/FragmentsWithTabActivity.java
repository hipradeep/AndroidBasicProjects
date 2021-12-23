package com.hipradeep.learnandroid.nestedfragments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.FrameLayout;

import com.google.android.material.tabs.TabLayout;
import com.hipradeep.learnandroid.R;
import com.hipradeep.learnandroid.fragments.OneFragment;
import com.hipradeep.learnandroid.fragments.TwoFragment;

public class FragmentsWithTabActivity extends AppCompatActivity {
    TabLayout tabLayout;
    private Fragment currentFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragments_with_tab);
        tabLayout = findViewById(R.id.tabLayout);

        // set default fragments
        replaceFragment(new OneFragment());

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

                switch (tab.getPosition()) {
                    case 0:
                        if (!(currentFragment instanceof OneFragment))
                            replaceFragment(new OneFragment());
                        break;
                    case 1:
                        if (!(currentFragment instanceof TwoFragment))
                            replaceFragment(new TwoFragment());

                        break;

                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    private void replaceFragment(Fragment setFragment) {
        //new Handler().postDelayed(() -> {
        currentFragment = setFragment;
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.container, setFragment);
        //  transaction.replace(R.id.container, setFragment, title);
       // transaction.addToBackStack(null);
        transaction.commitAllowingStateLoss();
        // }, 200);
    }
}