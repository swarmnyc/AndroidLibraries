package com.swarmnyc.testapp;

import android.app.Application;

import com.swarmnyc.ui.tracking.TrackingService;

import javax.inject.Inject;

public class AppApplication extends Application {
    private ApplicationComponent applicationComponent;

    public ApplicationComponent component() {
        return applicationComponent;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        applicationComponent = DaggerApplicationComponent.builder()
                .applicationServiceModule(new ApplicationServiceModule(this))
                .build();
    }
}
