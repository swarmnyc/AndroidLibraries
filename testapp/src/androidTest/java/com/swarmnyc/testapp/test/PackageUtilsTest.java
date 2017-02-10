package com.swarmnyc.testapp.test;

import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.swarmnyc.test.PackageUtils;
import com.swarmnyc.testapp.MainActivity;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

@RunWith(AndroidJUnit4.class)
public class PackageUtilsTest {

    @Rule
    public ActivityTestRule<MainActivity> mainActivity = new ActivityTestRule<>(MainActivity.class, true, false);
    private String app;

    @Before
    public void setUp() throws Exception {
        // Only >= SDK 23 has these problem
        PackageUtils.grantPermission("android.permission.READ_EXTERNAL_STORAGE");
        PackageUtils.grantPermission("android.permission.WRITE_EXTERNAL_STORAGE");
    }

    @Test
    public void grantPermissionTest() throws Exception {
        mainActivity.launchActivity(null);

        assertTrue(PackageUtils.hasPermission("android.permission.WRITE_EXTERNAL_STORAGE"));
    }

    @Test
    public void hasPermissionTest() throws Exception {
        mainActivity.launchActivity(null);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            // Only > SDK 23 has these problem
            assertFalse(PackageUtils.hasPermission("android.permission.CAMERA"));
        }
    }

    @Test
    public void uidTest() throws Exception {
        app = "com.android.calendar";
        int uid = PackageUtils.getAppId(app);

        assertNotEquals(0, uid);
        assertEquals("com.android.calendar", PackageUtils.getAppName(uid));
    }

    @Test
    public void launchAppTest() throws Exception {
        mainActivity.launchActivity(null);

        PackageUtils.launchApp("com.android.calendar", new Bundle());
    }
}
