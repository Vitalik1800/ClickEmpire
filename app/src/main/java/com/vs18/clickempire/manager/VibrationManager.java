package com.vs18.clickempire.manager;

import android.content.Context;
import android.os.Build;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.util.Log;

import androidx.annotation.NonNull;

import com.vs18.clickempire.util.Constants;

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

        Log.d(Constants.TAG, "vibrate() called");

        Log.d(Constants.TAG,
                "enabled = " + settingsManager.isVibrationEnabled());

        Vibrator vibrator =
                (Vibrator) context.getSystemService(Context.VIBRATOR_SERVICE);

        if (vibrator == null || !vibrator.hasVibrator()) {
            Log.d(Constants.TAG, "Vibrator is null");
            return;
        }

        Log.d(Constants.TAG,
                "hasVibrator = " + vibrator.hasVibrator());

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
