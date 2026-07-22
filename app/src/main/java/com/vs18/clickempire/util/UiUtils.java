package com.vs18.clickempire.util;

import android.content.Context;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.vs18.clickempire.R;
import com.vs18.clickempire.manager.GameManager;
import com.vs18.clickempire.model.GameActionResult;
import com.vs18.clickempire.model.Upgrade;

public final class UiUtils {

    private UiUtils() {

    }

    /**
     * Shows upgrade purchase result.
     *
     * @param context activity context
     * @param upgrade purchased upgrade
     */
    public static void showUpgrade(
            @NonNull Context context,
            @NonNull Upgrade upgrade,
            boolean success
    ) {

        String message;

        if (success) {

            message = context.getString(
                    R.string.upgrade_purchased,
                    context.getString(upgrade.getNameResId())
            );

            GameManager.getSoundManager().play(
                    GameManager.getSoundManager().getBuySound()
            );

        } else {
            message = context.getString(R.string.not_enough_coins);

            GameManager.getSoundManager().play(
                    GameManager.getSoundManager().getErrorSound()
            );
        }

        Toast.makeText(
                context,
                message,
                Toast.LENGTH_SHORT
        ).show();
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

        GameManager.getSoundManager().play(
                GameManager.getSoundManager().getAchievementSound()
        );

        String title = context.getString(
                result.getAchievement().getTitleResId()
        );

        String message =
                context.getString(R.string.achievement_unlocked)
                        + "\n"
                        + title;

        Toast.makeText(context, message, Toast.LENGTH_LONG).show();
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

        new MaterialAlertDialogBuilder(context)
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

    /**
     * Shows a confirmation dialog before resetting
     * all game progress.
     *
     * @param context dialog context
     * @param onConfirm action executed after confirmation
     */
    public static void showResetDialog(
            @NonNull Context context,
            @NonNull Runnable onConfirm
    ) {

        new MaterialAlertDialogBuilder(context)
                .setTitle(R.string.reset_progress_title)
                .setMessage(R.string.reset_progress_message)
                .setNegativeButton(R.string.cancel, null)
                .setPositiveButton(R.string.reset,
                        (dialog, which) -> onConfirm.run())
                .show();
    }
}
