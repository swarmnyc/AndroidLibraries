package com.swarmnyc.test;

import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;

import java.util.List;

import static android.support.test.InstrumentationRegistry.getInstrumentation;
import static android.support.test.InstrumentationRegistry.getTargetContext;

public class PackageUtils {
    public static class Permissions {
        public static final String READ_EXTERNAL_STORAGE = "android.permission.READ_EXTERNAL_STORAGE";
        public static final String WRITE_EXTERNAL_STORAGE = "android.permission.WRITE_EXTERNAL_STORAGE";
        public static final String READ_PHONE_STATE = "android.permission.READ_PHONE_STATE";
        public static final String PACKAGE_USAGE_STATS = "android.permission.PACKAGE_USAGE_STATS";
    }

    public static void grantPermission(String permission) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (!hasPermission(permission))
                getInstrumentation().getUiAutomation()
                        .executeShellCommand(
                                "pm grant " + getTargetContext().getPackageName() + " " + permission);
        }
    }

    public static void revokePermission(String permission) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (hasPermission(permission))
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

    public static int getAppId(String app) {
        PackageManager packageManager = getTargetContext().getPackageManager();

        for (ApplicationInfo info : packageManager.getInstalledApplications(PackageManager.GET_META_DATA)) {
            if (info.packageName.equals(app))
                return info.uid;
        }

        return 0;
    }

    public static void launchApp(String app) {
        launchApp(app, null);
    }

    public static void launchApp(String app, Bundle bundle) {
        Intent intent = getTargetContext().getPackageManager().getLaunchIntentForPackage(app);
        if (bundle != null) {
            intent.putExtras(bundle);
        }

        getTargetContext().startActivity(intent);
    }
}