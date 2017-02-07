package com.swarmnyc.test;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Environment;
import android.util.Log;
import android.view.View;

import com.swarmnyc.core.util.DateUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;
import java.util.UUID;

public class ScreenShot {
    private static final String TAG = "SCREENSHOT";
    private static final String AWS_SCREEN_DIRECTORY = "/test-screenshots/";
    private static final String SCREEN_DIRECTORY = "screenshots";
    private static final int SCREEN_SHOT_IMAGE_QUALITY = 100;

    public static String getFilePath(Activity activity, String filename){
        // the path might be /sdcard/Android/data/[app name]/files/screenshots/[filename].png
        return String.format("%s/%s.png",
                activity.getExternalFilesDir(SCREEN_DIRECTORY).getAbsolutePath(),
                filename);
    }

    public static void take(Activity activity) {
        takeInternal(activity, getFilePath(activity, DateUtils.fileFormat(new Date())));
    }

    public static void take(Activity activity, String filename) {
        takeInternal(activity, getFilePath(activity, filename));
    }

    public static void takeForAWS(Activity activity) {
        takeInternal(activity, String.format("%s/%s/%s.png",
                Environment.getExternalStorageDirectory().getAbsolutePath(),
                AWS_SCREEN_DIRECTORY,
                UUID.randomUUID().toString()));
    }

    private static void takeInternal(Activity activity, String fileName) {
        File imageFile = new File(fileName);

        // Verify that the directory exists and create it if not.
        File directoryPath = imageFile.getParentFile();
        if (!directoryPath.isDirectory()) {
            Log.i(TAG, "Creating directory: " + directoryPath.toString());
            if (!directoryPath.mkdirs()) {
                Log.e(TAG, "Failed to create the directory");
                return;
            }
        }

        Log.i(TAG, "Saving to path: " + imageFile.toString());

        View phoneView = activity.getWindow().getDecorView().getRootView();
        phoneView.setDrawingCacheEnabled(true);
        Bitmap bitmap = Bitmap.createBitmap(phoneView.getDrawingCache());
        phoneView.setDrawingCacheEnabled(false);

        OutputStream out = null;

        try {
            out = new FileOutputStream(imageFile);
            bitmap.compress(Bitmap.CompressFormat.PNG, SCREEN_SHOT_IMAGE_QUALITY, out);
            out.flush();
        } catch (IOException e) {
            Log.e(TAG, e.toString());
        } finally {
            try {
                if (out != null) {
                    out.close();
                }
            } catch (IOException e) {
                Log.e(TAG, e.toString());
            }
        }
    }
}