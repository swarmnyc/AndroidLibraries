package com.swarmnyc.testapp.test;


import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.swarmnyc.test.Screenshot;
import com.swarmnyc.testapp.MainActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.File;
import java.util.UUID;

import static org.junit.Assert.*;

@RunWith(AndroidJUnit4.class)
public class ScreenshotTest {
    @Rule
    public ActivityTestRule<MainActivity> mainActivity = new ActivityTestRule<MainActivity>(MainActivity.class);

    @Test
    public void takeTest() throws InterruptedException {
        MainActivity activity = mainActivity.getActivity();
        String fileName = UUID.randomUUID().toString();
        Screenshot.take(activity, fileName);
        Thread.sleep(100);

        assertTrue("The screenshot file didn't created", (new File(Screenshot.getFilePath(activity, fileName)).exists()));
    }
}
