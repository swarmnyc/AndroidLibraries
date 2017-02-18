package com.swarmnyc.ui.tracking;

import android.util.Log;

import com.google.android.gms.analytics.HitBuilders;
import com.google.android.gms.analytics.Tracker;

import static com.swarmnyc.core.util.NameParser.parse;

/**
 * The type Google analytics tracking service.
 */
public class GoogleAnalyticsTrackingService implements TrackingService {
    /**
     * The constant TAG which is the same as GoogleAnalytics,
     * So it is easy for filtering.
     */
    public static final String TAG = "GAv4";
    private static final java.lang.String DEFAULT_CATEGORY = "Click";

    private Tracker mTracker;

    /**
     * Instantiates a new Google analytics tracking service.
     *
     * @param tracker the tracker
     */
    public GoogleAnalyticsTrackingService(Tracker tracker) {
        mTracker = tracker;
    }

    @Override
    public void sendScreen(String name) {
        sendScreen(name, null);
    }

    @Override
    public void sendScreen(Object screen) {
        sendScreen(parse(screen), null);
    }

    @Override
    public void sendScreen(Object screen, String tab) {
        sendScreen(parse(screen), tab);
    }

    @Override
    public void sendScreen(String name, String tab) {
        if (tab != null) {
            name += " - " + tab;
        }

        Log.d(TAG, "Screen Name: " + name);
        mTracker.setScreenName(name);
        mTracker.send(new HitBuilders.ScreenViewBuilder().build());
    }

    @Override
    public void sendEvent(String action) {
        sendEvent(DEFAULT_CATEGORY, action, null);
    }

    @Override
    public void sendEvent(String category, String action) {
        sendEvent(category, action, null);
    }

    @Override
    public void sendEvent(String category, String action, Object... params) {
        // If only
        // Event will belong the screen that recent set.
        Log.d(TAG, String.format("Event: Category: %s, Action: %s, Values: %s", category, action, params));

        HitBuilders.EventBuilder eventBuilder = new HitBuilders.EventBuilder();
        eventBuilder = eventBuilder
                .setCategory(category)
                .setAction(action);

        if (params != null) {
            Object label = null;
            Object value = null;
            if (params.length == 1) {
                value = params[1];
            } else if (params.length == 2) {
                label = params[0];
                value = params[1];
            } else {
                Log.d(TAG, "The sendEvent of GoogleAnalyticsTrackingService only supports two parameters");
            }

            if (label !=null){
                eventBuilder.setLabel(label.toString());
            }

            if (value!=null){
                try {
                    long v;
                    if (value instanceof Long) {
                        v = (long) value;
                    } else {
                        v = Long.parseLong(value.toString());
                    }

                    eventBuilder.setValue(v);
                } catch (Exception e) {
                    Log.d(TAG, "The sendEvent of GoogleAnalyticsTrackingService only supports long value parameter");
                }
            }
        }

        mTracker.send(eventBuilder.build());
    }
}
