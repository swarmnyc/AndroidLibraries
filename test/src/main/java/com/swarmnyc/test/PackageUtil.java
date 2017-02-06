package com.swarmnyc.test;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;

import static android.support.test.InstrumentationRegistry.getInstrumentation;
import static android.support.test.InstrumentationRegistry.getTargetContext;

public class PackageUtil {

    public static void grantPermission(String permission) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (!hasFeature(permission))
                getInstrumentation().getUiAutomation()
                        .executeShellCommand(
                                "pm grant " + getTargetContext().getPackageName() + " " + permission);
        }
    }

    public static void revokePermission(String permission) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (hasFeature(permission))
                getInstrumentation().getUiAutomation()
                        .executeShellCommand(
                                "pm revoke " + getTargetContext().getPackageName() + " " + permission);
        }
    }

    public static boolean hasPermission(String permission) {
        PackageManager packageManager = getTargetContext().getPackageManager();
        return packageManager.checkPermission(permission, getTargetContext().getPackageName()) == PackageManager.PERMISSION_GRANTED;
    }

    public static boolean hasFeature(String feature) {
        PackageManager packageManager = getTargetContext().getPackageManager();
        return packageManager.hasSystemFeature(feature);
    }

    public static String getAppName(int uid) {
        PackageManager packageManager = getTargetContext().getPackageManager();

        return packageManager.getNameForUid(uid);
    }

    public static void launchApp(String app) {

        Intent intent = getTargetContext().getPackageManager().getLaunchIntentForPackage(app);

        getTargetContext().startActivity(intent);
    }
}