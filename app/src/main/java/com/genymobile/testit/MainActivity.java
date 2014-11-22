package com.genymobile.testit;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;


public class MainActivity extends Activity {

    private View batteryLevelView;

    private BatteryLevelListener batteryLevelListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        batteryLevelView = findViewById(R.id.battery_level_view);

        batteryLevelListener = new BatteryLevelListener();
    }

    @Override
    protected void onResume() {
        super.onResume();

        IntentFilter intentFilter = new IntentFilter(Intent.ACTION_BATTERY_CHANGED);
        Intent batteryStatus = this.registerReceiver(batteryLevelListener, intentFilter);

        updateBatteryLevel(new BatteryWatcher(batteryStatus));
    }

    private void updateBatteryLevel(BatteryWatcher watcher) {
        if (watcher.getColorAccordingToBatteryLevel() == 1) {
            batteryLevelView.setBackgroundColor(Color.GREEN);
        } else {
            batteryLevelView.setBackgroundColor(Color.RED);
        }
    }

    private class BatteryLevelListener extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            updateBatteryLevel(new BatteryWatcher(intent));
        }
    }
}
