package com.swarmnyc.testapp.ui;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.view.View;
import android.widget.TextView;

import com.swarmnyc.testapp.MainActivity;
import com.swarmnyc.testapp.R;
import com.swarmnyc.ui.util.AnimationUtil;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

@RunWith(AndroidJUnit4.class)
public class AnimationUtilsTest {
    @Rule
    public ActivityTestRule<MainActivity> mainActivity = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void showAndHideTest() throws Exception {
        MainActivity activity = mainActivity.getActivity();
        final AnimationUtil utils = AnimationUtil.create(activity);
        final TextView view = (TextView) activity.findViewById(R.id.txt_view);

        activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                utils.hide(view);
            }
        });
        Thread.sleep(1000);
        assertTrue(view.getVisibility() == View.GONE);
        activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                utils.show(view);
            }
        });
        Thread.sleep(1000);
        assertTrue(view.getVisibility() == View.VISIBLE);
    }
}
