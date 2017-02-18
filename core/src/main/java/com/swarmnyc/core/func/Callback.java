package com.swarmnyc.core.func;

/**
 * The interface Callback is used for async function.
 *
 * @param <T> the type parameter
 */
public interface Callback<T> {
    /**
     * Callback.
     *
     * @param result the result
     */
    void callback(T result);
}
