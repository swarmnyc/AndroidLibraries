package com.swarmnyc.testapp.test;

import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.swarmnyc.test.PackageUtil;
import com.swarmnyc.testapp.MainActivity;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

@RunWith(AndroidJUnit4.class)
public class PackageUtilTest {

    @Rule
    public ActivityTestRule<MainActivity> mainActivity = new ActivityTestRule<>(MainActivity.class, true, false);

    @Before
    public void setUp() throws Exception {
        // Only >= SDK 23 has these problem
        PackageUtil.grantPermission("android.permission.READ_EXTERNAL_STORAGE");
        PackageUtil.grantPermission("android.permission.WRITE_EXTERNAL_STORAGE");
    }

    @Test
    public void grantPermissionTest() throws Exception {
        mainActivity.launchActivity(null);

        assertTrue(PackageUtil.hasPermission("android.permission.WRITE_EXTERNAL_STORAGE"));
    }

    @Test
    public void hasPermissionTest() throws Exception {
        mainActivity.launchActivity(null);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            // Only > SDK 23 has these problem
            assertFalse(PackageUtil.hasPermission("android.permission.CAMERA"));
        }
    }

    @Test
    public void launchAppTest() throws Exception {
        mainActivity.launchActivity(null);

        PackageUtil.launchApp("com.android.calendar", new Bundle());
    }
}
