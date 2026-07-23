package com.vs18.clickempire.util;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import androidx.annotation.NonNull;

import com.vs18.clickempire.R;

/**
 * Utility class for UI animations.
 */
public final class AnimationUtilsEx {

    /**
     * Prevents instantiation.
     */
    private AnimationUtilsEx() {

    }

    /**
     * Plays the standard button press animation.
     *
     * @param view button or any clickable view
     */
    public static void animateButton(@NonNull View view) {

        Animation animation = AnimationUtils.loadAnimation(
                view.getContext(),
                R.anim.button_press
        );

        view.startAnimation(animation);
    }
}
