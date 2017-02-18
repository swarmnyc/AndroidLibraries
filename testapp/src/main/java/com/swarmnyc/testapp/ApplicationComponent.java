package com.swarmnyc.testapp;

import com.swarmnyc.ui.tracking.TrackingService;

import javax.inject.Singleton;

import dagger.Component;

/**
 * A component whose lifetime is the life of the application.
 */
@Singleton // Constraints this component to one-per-application or unscoped bindings.
@Component(modules = ApplicationServiceModule.class)
interface ApplicationComponent {
    void inject(MainActivity mainActivity);

    void inject(SecondActivity secondActivity);
}

