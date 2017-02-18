package com.swarmnyc.testapp;

import android.os.Bundle;
import android.app.Activity;

import com.swarmnyc.ui.tracking.TrackingService;

import javax.inject.Inject;

public class SecondActivity extends Activity {

    @Inject
    TrackingService trackingService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        ((AppApplication) getApplication()).component().inject(this);

        trackingService.sendScreen(this, "Tag");
    }

}
