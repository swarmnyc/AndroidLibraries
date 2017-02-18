package com.swarmnyc.testapp;

import android.app.Application;
import android.location.LocationManager;

import com.google.android.gms.analytics.GoogleAnalytics;
import com.swarmnyc.ui.tracking.GoogleAnalyticsTrackingService;
import com.swarmnyc.ui.tracking.TrackingService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

import static android.content.Context.LOCATION_SERVICE;

@Module
class ApplicationServiceModule {
    private final AppApplication application;

    ApplicationServiceModule(AppApplication application) {
        this.application = application;
    }

    @Provides
    @Singleton
    TrackingService provideTrackingService() {
        GoogleAnalytics analytics = GoogleAnalytics.getInstance(application);

        return new GoogleAnalyticsTrackingService(analytics.newTracker(R.xml.global_tracker));
    }
}
