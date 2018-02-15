package com.example.mohamed.alarm.AlarmDirectory;

import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.mohamed.alarm.R;

import java.io.IOException;
import java.io.InputStream;

public class AlarmTimeActivity extends AppCompatActivity {

    private String TAG=AlarmTimeActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm_time);

        MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.a);
        if(mediaPlayer==null){
            Log.e(TAG,"null media player");
        }else{
            Log.e(TAG,"found media player");
            mediaPlayer.start();
        }
    }

    public void btn_snooze_click(View view) {
    }

    public void btn_dismiss_click(View view) {
        finish();
    }
}
