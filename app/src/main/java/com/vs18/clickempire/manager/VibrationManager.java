package com.vs18.clickempire.manager;

import android.content.Context;
import android.os.Build;
import android.os.VibrationEffect;
import android.os.Vibrator;

import androidx.annotation.NonNull;

/**
 * Manages device vibration effects.
 */
public class VibrationManager {

    private final Context context;
    private final SettingsManager settingsManager;

    /**
     * Creates a new vibration manager.
     *
     * @param context application context
     */
    public VibrationManager(@NonNull Context context) {
        this.context = context.getApplicationContext();
        this.settingsManager = new SettingsManager(context);
    }

    /**
     * Plays a short vibration if enabled.
     */
    public void vibrate() {

        if (!settingsManager.isVibrationEnabled()) {
            return;
        }

        Vibrator vibrator =
                (Vibrator) context.getSystemService(Context.VIBRATOR_SERVICE);

        if (vibrator == null || !vibrator.hasVibrator()) {
            return;
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            vibrator.vibrate(
                    VibrationEffect.createOneShot(
                            500,
                            VibrationEffect.DEFAULT_AMPLITUDE
                    )
            );
        } else {
            vibrator.vibrate(100);
        }

    }

}
