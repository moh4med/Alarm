package com.example.mohamed.alarm.AlarmDirectory;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by CompuCity on 2/14/2018.
 */

public class Alarm implements Parcelable{
    int hour;
    int minute;
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

    Alarm(){

    }
    Alarm(int hr,int min){
        hour=hr;
        minute=min;
    }
    Alarm(Parcel in){
        int[] data = new int[2];
        in.readIntArray(data);
        this.hour = data[0];
        this.minute = data[1];
    }
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeIntArray(new int[] {this.hour, this.minute});
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
