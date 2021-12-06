package com.hipradeep.learnandroid.services;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.nfc.Tag;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.hipradeep.learnandroid.R;
import com.hipradeep.learnandroid.services.svs.RingtoneService;

public class RingtoneActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btn_play, btn_stop;
    private MediaPlayer player;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ringtone);
        btn_play=findViewById(R.id.btn_play);
        btn_stop=findViewById(R.id.btn_stop);
        btn_play.setOnClickListener(this);
        btn_stop.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        if(view == btn_play){

            // starting the service
           // startService(new Intent( this, RingtoneService.class ) );
            Intent intent = new Intent(this, RingtoneService.class);
            startService(intent);
            Log.e("TAG", "PLAY");

        }
        else if (view == btn_stop){

            // stopping the service
            stopService(new Intent( this, RingtoneService.class ) );
            Log.e("TAG", "STOP");

        }

    }
}