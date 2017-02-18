package com.swarmnyc.testapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.swarmnyc.ui.tracking.TrackingService;

import javax.inject.Inject;

public class MainActivity extends Activity {
    @Inject
    TrackingService trackingService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ((AppApplication) getApplication())
                .component()
                .inject(this);

        trackingService.sendScreen(this);

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                trackingService.sendEvent("Second");
                startActivity(new Intent(getApplicationContext(), SecondActivity.class));
            }
        });
    }
}
