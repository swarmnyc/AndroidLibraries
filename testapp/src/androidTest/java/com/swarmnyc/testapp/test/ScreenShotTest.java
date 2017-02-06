package com.swarmnyc.testapp.test;


import android.os.Environment;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.swarmnyc.test.ScreenShot;
import com.swarmnyc.testapp.MainActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.File;
import java.util.UUID;

import static org.junit.Assert.*;

@RunWith(AndroidJUnit4.class)
public class ScreenShotTest {
    @Rule
    public ActivityTestRule<MainActivity> mainActivity = new ActivityTestRule<MainActivity>(MainActivity.class);

    @Test
    public void takeTest(){
        MainActivity activity = mainActivity.getActivity();
        String fileName = UUID.randomUUID().toString();
        ScreenShot.take(activity, fileName);

        assertTrue((new File(ScreenShot.getFilePath(activity, fileName)).exists()));
    }
}
