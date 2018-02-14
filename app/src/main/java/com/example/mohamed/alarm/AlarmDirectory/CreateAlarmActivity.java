package com.example.mohamed.alarm.AlarmDirectory;

import android.app.Activity;
import android.app.DialogFragment;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.TimePicker;

import com.example.mohamed.alarm.R;

public class CreateAlarmActivity extends AppCompatActivity {
    Intent return_intent;
    private TimePicker timePicker;
    private Alarm alarm;
    private String ALARM_TAG="ALARM_TAG";
    private String TAG=CreateAlarmActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_alarm);
        return_intent=new Intent();
        timePicker = (TimePicker)findViewById(R.id.timePicker);
        alarm=new Alarm();
    }

    public void btn_done_click(View view) {
        savedata();
        return_intent.putExtra(ALARM_TAG,alarm);
        setResult(Activity.RESULT_OK,return_intent);
        finish();
    }

    private void savedata() {
        int hour;
        int min;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
            hour = timePicker.getHour();
            min = timePicker.getMinute();
        }else{
            hour=timePicker.getCurrentHour();
            min=timePicker.getCurrentMinute();
        }
        alarm.setHour(hour);
        alarm.setMinute(min);
    }

    public void btn_cancel_click(View view) {
        setResult(Activity.RESULT_CANCELED);
        finish();
    }
}
