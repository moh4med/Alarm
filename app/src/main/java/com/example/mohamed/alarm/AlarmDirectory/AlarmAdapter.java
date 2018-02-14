package com.example.mohamed.alarm.AlarmDirectory;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Switch;
import android.widget.TextView;

import com.example.mohamed.alarm.R;

import java.util.ArrayList;

/**
 * Created by CompuCity on 2/14/2018.
 */

public class AlarmAdapter extends RecyclerView.Adapter<AlarmAdapter.AlarmViewHolder> {
    ArrayList<Alarm>alarms;
    public AlarmAdapter(ArrayList<Alarm> alarms) {
        this.alarms=alarms;
    }

    @Override
    public AlarmAdapter.AlarmViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.alarm_view, parent, false);
        return new AlarmViewHolder(view);
    }

    @Override
    public void onBindViewHolder(AlarmAdapter.AlarmViewHolder holder, int position) {
        Alarm alarm = alarms.get(position);
        int hour=alarm.getHour();
        int min=alarm.getMinute();
        if(hour>12){
            hour-=12;
            holder.tv_AMPM.setText("PM");
        }
        holder.tv_time.setText(hour+":"+min);
    }

    @Override
    public int getItemCount() {
        if(alarms==null)return 0;
        return alarms.size();
    }

    public class AlarmViewHolder extends RecyclerView.ViewHolder {

        private ImageButton ib_popupmenu;
        private Switch tb_onoff;
        private TextView tv_day;
        private  TextView tv_AMPM;
        private TextView tv_time;

        public AlarmViewHolder(View itemView) {
            super(itemView);
            tv_time = (TextView)itemView.findViewById(R.id.tv_time);
            tv_AMPM = (TextView)itemView.findViewById(R.id.tv_AMPM);
            tv_day = (TextView)itemView.findViewById(R.id.tv_day);
            tb_onoff = (Switch)itemView.findViewById(R.id.tb_onoff);
            ib_popupmenu = (ImageButton)itemView.findViewById(R.id.ib_popupmenu);
        }
    }
}
