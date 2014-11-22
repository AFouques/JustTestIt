package com.genymobile.testit;

import android.content.Intent;
import android.os.BatteryManager;

import com.example.Calculator;

public class BatteryWatcher {

    private final Intent batteryStatus;
    private static final float BATTERY_THRESHOLD = 0.5f;

    BatteryWatcher(Intent batteryStatus) {
        this.batteryStatus = batteryStatus;
    }

    public int getColorAccordingToBatteryLevel() {
        float currentChargeLevel = getBatteryPercentage();

        if (currentChargeLevel > BATTERY_THRESHOLD) {
            return 1;
        } else {
            return 0;
        }
    }

    private float getBatteryPercentage() {
        int level = batteryStatus.getIntExtra(BatteryManager.EXTRA_LEVEL, -1);
        int scale = batteryStatus.getIntExtra(BatteryManager.EXTRA_SCALE, -1);

        return new Calculator(level).divide((float) scale);
    }
}

