package com.swarmnyc.ui.util;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.view.View;

public class AnimationUtils
{
    private Context m_context;

    public AnimationUtils(final Context context )
    {
        m_context = context;
    }

    public static AnimationUtils create(final Context context )
    {
        return new AnimationUtils( context );
    }

    /**
     * Shows the progress UI and hides the login form.
     */
    @TargetApi( Build.VERSION_CODES.HONEYCOMB_MR2 )
    public AnimationUtils show(final View... views )
    {
        // On Honeycomb MR2 we have the ViewPropertyAnimator APIs, which allow
        // for very easy animations. If available, use these APIs to fade-in
        // the progress spinner.
        if ( Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR2 )
        {
            int shortAnimTime = m_context.getResources().getInteger( android.R.integer.config_shortAnimTime );

            for ( final View v : views )
            {
                v.setVisibility( View.VISIBLE );
                v.setAlpha( 0 );
                v.animate().setDuration( shortAnimTime ).alpha(
                        1
                ).setListener(
                        new AnimatorListenerAdapter()
                        {
                            @Override
                            public void onAnimationEnd( Animator animation )
                            {
                                v.setVisibility( View.VISIBLE );
                            }
                        }
                );
            }
        }
        else
        {
            // The ViewPropertyAnimator APIs are not available, so simply show
            // and hide the relevant UI components.
            for ( final View v : views )
            {
                v.setVisibility( View.VISIBLE );
            }
        }
        return this;
    }

    @TargetApi( Build.VERSION_CODES.HONEYCOMB_MR2 )
    public AnimationUtils hide(final View... views )
    {
        // On Honeycomb MR2 we have the ViewPropertyAnimator APIs, which allow
        // for very easy animations. If available, use these APIs to fade-in
        // the progress spinner.
        if ( Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR2 )
        {
            int shortAnimTime = m_context.getResources().getInteger( android.R.integer.config_shortAnimTime );

            for ( final View v : views )
            {

                v.animate().setDuration( shortAnimTime ).alpha(
                        0
                ).setListener(
                        new AnimatorListenerAdapter()
                        {
                            @Override
                            public void onAnimationEnd( Animator animation )
                            {
                                v.setVisibility( View.GONE );
                            }
                        }
                );
            }
        }
        else
        {
            // The ViewPropertyAnimator APIs are not available, so simply show
            // and hide the relevant UI components.
            for ( final View v : views )
            {
                v.setVisibility( View.GONE );
            }
        }
        return this;
    }
}
