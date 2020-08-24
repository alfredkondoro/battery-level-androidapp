package com.alfredkondoro.batterylevel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView batteryStatus;
    private BroadcastReceiver mbc = new BroadcastReceiver () {
        @Override
        public void onReceive(Context context, Intent intent) {
            int level = intent.getIntExtra (BatteryManager.EXTRA_LEVEL,0);
            batteryStatus.setText (String.valueOf (level)+"%");
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_main);

        batteryStatus = (TextView) findViewById (R.id.batteryStatus);
        this.registerReceiver (this.mbc, new IntentFilter (Intent.ACTION_BATTERY_CHANGED));
    }
}