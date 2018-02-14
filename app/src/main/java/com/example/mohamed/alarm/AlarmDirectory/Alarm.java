package com.example.mohamed.alarm.AlarmDirectory;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

import java.util.Calendar;

/**
 * Created by CompuCity on 2/14/2018.
 */

public class Alarm implements Parcelable {
    private static final String TAG =Alarm.class.getSimpleName() ;
    private AlarmManager alarmMgr;
    private Intent intent;
    int hour;
    int minute;
    private PendingIntent alarmIntent;
    private static int tot_id;
    private int id;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getHour() {
        return hour;
    }

    Alarm() {
        this.setId(tot_id);
        tot_id++;
    }

    public void setupALarmManager(Context context) {
        alarmMgr = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        intent = new Intent(context, AlarmReceiver.class);
        intent.setAction("sdf"+getId());
        intent.putExtra("hello",getId());
        alarmIntent = PendingIntent.getBroadcast(context, getId(), intent, PendingIntent.FLAG_UPDATE_CURRENT);//hello try change this flag to 0
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        calendar.set(Calendar.HOUR_OF_DAY, this.getHour());
        calendar.set(Calendar.MINUTE, this.getMinute());
        calendar.set(Calendar.SECOND, 0);
        alarmMgr.setExact(AlarmManager.RTC_WAKEUP,calendar.getTimeInMillis(),alarmIntent);
        /*alarmMgr.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(),
                AlarmManager.INTERVAL_DAY, alarmIntent);*/
    }


    Alarm(Parcel in) {
        int[] data = new int[3];
        in.readIntArray(data);
        this.hour = data[0];
        this.minute = data[1];
        this.setId(data[2]);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeIntArray(new int[]{this.hour, this.minute,this.getId()});
    }

    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
        public Alarm createFromParcel(Parcel in) {
            return new Alarm(in);
        }

        public Alarm[] newArray(int size) {
            return new Alarm[size];
        }
    };
}
