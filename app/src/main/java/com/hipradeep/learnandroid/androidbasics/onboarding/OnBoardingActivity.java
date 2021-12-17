package com.hipradeep.learnandroid.androidbasics.onboarding;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.chyrta.onboarder.OnboarderActivity;
import com.chyrta.onboarder.OnboarderPage;
import com.hipradeep.learnandroid.R;

import java.util.ArrayList;
import java.util.List;

public class OnBoardingActivity extends OnboarderActivity {
    List<OnboarderPage> onboarderPages;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_onbording);

        onboarderPages = new ArrayList<OnboarderPage>();

        // Create your first page
        OnboarderPage onboarderPage1 = new OnboarderPage("Title 1", "Description 1", R.drawable.undraw_1);
        OnboarderPage onboarderPage2 = new OnboarderPage("App title", "app_description", R.drawable.undraw_2);
        OnboarderPage onboarderPage3 = new OnboarderPage("Title 1", "Description 3",R.drawable.undraw_3);
        OnboarderPage onboarderPage4 = new OnboarderPage("App title", "app_description", R.drawable.undraw_1);

        // You can define title and description colors (by default white)
        onboarderPage1.setTitleColor(R.color.black);
        onboarderPage1.setDescriptionColor(R.color.white);

        // Don't forget to set background color for your page
        onboarderPage1.setBackgroundColor(R.color.teal_200);
        onboarderPage2.setBackgroundColor(R.color.white);
        onboarderPage3.setBackgroundColor(R.color.purple_500);
        onboarderPage4.setBackgroundColor(R.color.purple_200);

        // Add your pages to the list
        onboarderPages.add(onboarderPage1);
        onboarderPages.add(onboarderPage2);
        onboarderPages.add(onboarderPage3);
        onboarderPages.add(onboarderPage4);

        // And pass your pages to 'setOnboardPagesReady' method
        setOnboardPagesReady(onboarderPages);
    }

    @Override
    public void onFinishButtonPressed() {

    }
    @Override
    public void onSkipButtonPressed() {
        // Optional: by default it skips onboarder to the end
        super.onSkipButtonPressed();
        // Define your actions when the user press 'Skip' button
        Toast.makeText(OnBoardingActivity.this, "Skip", Toast.LENGTH_SHORT).show();
    }
}

//https://uxplanet.org/16-onboarding-open-source-ui-animation-libraries-swift-java-8e8eda919c96