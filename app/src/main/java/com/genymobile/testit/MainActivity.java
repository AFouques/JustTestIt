package com.genymobile.testit;

import android.app.Activity;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;


public class MainActivity extends Activity {

    private View batteryLevelView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        batteryLevelView = findViewById(R.id.battery_level_view);
    }

    @Override
    protected void onResume() {
        super.onResume();

        updateBatteryLevel(getCurrentBatteryWatcher());
    }

    private BatteryWatcher getCurrentBatteryWatcher() {
        IntentFilter intentFilter = new IntentFilter(Intent.ACTION_BATTERY_CHANGED);
        Intent batteryStatus = this.registerReceiver(null, intentFilter);
        return new BatteryWatcher(batteryStatus);
    }

    private void updateBatteryLevel(BatteryWatcher watcher) {
        if (watcher.getColorAccordingToBatteryLevel() == 1) {
            batteryLevelView.setBackgroundColor(Color.GREEN);
        } else {
            batteryLevelView.setBackgroundColor(Color.RED);
        }
    }
}
