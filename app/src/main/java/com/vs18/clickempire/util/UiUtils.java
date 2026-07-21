package com.vs18.clickempire.util;

import android.content.Context;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;

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

    /**
     * Shows offline income dialog.
     *
     * @param context activity context
     * @param offlineSeconds offline time in seconds
     * @param offlineCoins earned offline coins
     */
    public static void showOfflineIncome(
            @NonNull Context context,
            long offlineSeconds,
            long offlineCoins
    ) {

        if (offlineCoins <= 0) {
            return;
        }

        long hours = offlineSeconds / Constants.SECONDS_0F_HOUR;
        long minutes = (offlineSeconds % Constants.SECONDS_0F_HOUR) / Constants.SECONDS_OF_MINUTE;
        long seconds = offlineSeconds % Constants.SECONDS_OF_MINUTE;

        String time;

        if (hours > 0) {
            time = hours + " h " + minutes + " min";
        } else if (minutes > 0) {
            time = minutes + " min";
        } else {
            time = seconds + " sec";
        }

        new AlertDialog.Builder(context)
                .setTitle(R.string.welcome_back)
                .setMessage(
                        context.getString(R.string.offline_time) + "\n"
                        + time
                        + "\n\n" + context.getString(R.string.earned) + "\n"
                        + NumberFormatter.format(offlineCoins)
                        + context.getString(R.string.coins)
                )
                .setPositiveButton(android.R.string.ok, null)
                .show();
    }
}
