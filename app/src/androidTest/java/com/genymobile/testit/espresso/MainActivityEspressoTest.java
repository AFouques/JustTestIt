package com.genymobile.testit.espresso;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.test.ActivityInstrumentationTestCase2;
import android.view.View;

import com.genymobile.testit.MainActivity;
import com.genymobile.testit.R;
import com.genymotion.api.GenymotionManager;

import static android.test.ViewAsserts.assertOnScreen;

public class MainActivityEspressoTest extends ActivityInstrumentationTestCase2<MainActivity> {

    private View batteryLevelView;
    private MainActivity mainActivity;

    public MainActivityEspressoTest() {
        super(MainActivity.class);
    }

    @Override
    public void setUp() throws Exception {
        super.setUp();
        mainActivity = getActivity();
        batteryLevelView = mainActivity.findViewById(R.id.battery_level_view);
    }

    public void testBatteryLevelViewIsShown() {
        assertOnScreen(mainActivity.getWindow().getDecorView(), batteryLevelView);
    }

    public void testWhenBatteryLevelIsMoreThanHalfLevelViewIsGreen() throws Exception {

        // Avoid the test if not a Genymotion device
        if (!GenymotionManager.isGenymotionDevice()) {
            return;
        }
        GenymotionManager.getGenymotionManager(getActivity()).getBattery().setLevel(100);

        View levelView = getActivity().findViewById(R.id.battery_level_view);
        ColorDrawable green = (ColorDrawable) levelView.getBackground();
        assertEquals(green.getColor(), Color.GREEN);
    }

    public void testWhenBatteryLevelIsLessThanHalfLevelViewIsRed() throws Exception {

        // Avoid the test if not a Genymotion device
        if (!GenymotionManager.isGenymotionDevice()) {
            return;
        }

        GenymotionManager.getGenymotionManager(getActivity()).getBattery().setLevel(10);

        View levelView = getActivity().findViewById(R.id.battery_level_view);
        ColorDrawable green = (ColorDrawable) levelView.getBackground();
        assertEquals(green.getColor(), Color.RED);
    }
}
