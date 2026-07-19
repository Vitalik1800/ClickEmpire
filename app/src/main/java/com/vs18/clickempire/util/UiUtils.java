package com.vs18.clickempire.util;

import android.content.Context;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.vs18.clickempire.R;
import com.vs18.clickempire.model.GameActionResult;

public final class UiUtils {

    private UiUtils() {

    }

    /**
     * Shows unlocked achievement message.
     *
     * @param context activity context
     * @param result action result
     */
    public static void showAchievement(
            @NonNull Context context,
            @NonNull GameActionResult result
    ) {

        if (result.getAchievement() == null) {
            return;
        }

        Toast.makeText(
                context,
                context.getString(R.string.achievement_unlocked)
                        + "\n\n"
                        + context.getString(result.getAchievement().getTitleResId()),
                Toast.LENGTH_LONG
        ).show();
    }
}
