package com.hipradeep.learnandroid.bottomnavigationbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.hipradeep.learnandroid.R;

public class BottomNavigationWithNavHostFragmentsActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_navigation_with_nav_host_fragments);



        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_one, R.id.nav_two, R.id.nav_three)  //id must same in both 'host' as well as 'menu'
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        BottomNavigationView bottomNav = findViewById(R.id.bottomNavigationView);
        NavigationUI.setupWithNavController(bottomNav, navController);

        //or//



        // this method does not change title
//        BottomNavigationView bottomNavigationView =findViewById(R.id.bottomNavigationView);
//        NavHostFragment navHostFragment = (NavHostFragment)getSupportFragmentManager()
//                .findFragmentById(R.id.nav_host_fragment_content_main);
//        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
//        assert navHostFragment != null;
//        NavigationUI.setupWithNavController(bottomNavigationView, navHostFragment.getNavController());

    }


}