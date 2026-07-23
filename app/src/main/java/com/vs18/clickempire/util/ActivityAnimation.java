package com.vs18.clickempire.util;

import android.app.Activity;

import androidx.annotation.NonNull;

import com.vs18.clickempire.R;

/**
 * Utility class for activity transition animations.
 */
public class ActivityAnimation {

    /**
     * Prevents instantiation.
     */
    private ActivityAnimation() {

    }

    /**
     * Plays the opening transition animation.
     *
     * @param activity current activity
     */
    public static void open(@NonNull Activity activity) {

        activity.overridePendingTransition(
                R.anim.slide_in_right,
                R.anim.slide_out_left
        );
    }

    /**
     * Plays the closing transition animation.
     *
     * @param activity current activity
     */
    public static void close(@NonNull Activity activity) {

        activity.overridePendingTransition(
                R.anim.slide_in_left,
                R.anim.slide_out_right
        );
    }
}
