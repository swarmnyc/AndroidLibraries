package com.swarmnyc.ui.tracking;

/**
 * The interface Tracking service.
 */
public interface TrackingService {

    /**
     * Send screen.
     *
     * @param name the name
     */
    void sendScreen(String name);

    /**
     * Send screen.
     *
     * @param name the name
     * @param tab  the tab
     */
    void sendScreen(String name, String tab);

    /**
     * Send screen.
     *
     * @param source the source
     */
    void sendScreen(Object source);

    /**
     * Send screen.
     *
     * @param screen the screen
     * @param tab    the tab
     */
    void sendScreen(Object screen, String tab);

    void sendEvent(String action);

    void sendEvent(String category, String action);

    void sendEvent(String category, String action, Object... params);
}

