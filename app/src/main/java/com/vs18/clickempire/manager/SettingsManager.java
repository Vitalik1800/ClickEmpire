package com.vs18.clickempire.manager;

import android.content.Context;
import android.content.SharedPreferences;

import androidx.annotation.NonNull;

public class SettingsManager {

    /**
     * SharedPreferences file name.
     */
    private static final String PREFS_NAME = "click_empire_settings";

    /**
     * Key for sound setting.
     */
    private static final String KEY_SOUND = "sound_enabled";

    /**
     * Key for vibration setting.
     */
    private static final String KEY_VIBRATION = "vibration_enabled";

    /**
     * SharedPreferences instance.
     */
    private final SharedPreferences preferences;

    /**
     * Returns whether sound is enabled.
     *
     * @return true if sound is enabled
     */
    public SettingsManager(@NonNull Context context) {
        preferences = context.getSharedPreferences(
                PREFS_NAME,
                Context.MODE_PRIVATE
        );
    }

    /**
     * Returns whether sound is enabled.
     *
     * @return true if sound is enabled
     */
    public boolean isSoundEnabled() {
        return preferences.getBoolean(KEY_SOUND, true);
    }

    /**
     * Enables or disables sound.
     *
     * @param enabled true to enable sound
     */
    public void setSoundEnabled(boolean enabled) {
        preferences.edit()
                .putBoolean(KEY_SOUND, enabled)
                .apply();
    }

    /**
     * Returns whether vibration is enabled.
     *
     * @return true if vibration is enabled
     */
    public boolean isVibrationEnabled() {
        return preferences.getBoolean(KEY_VIBRATION, true);
    }

    /**
     * Enables or disables vibration.
     *
     * @param enabled true to enable vibration
     */
    public void setVibrationEnabled(boolean enabled) {
        preferences.edit()
                .putBoolean(KEY_VIBRATION, enabled)
                .apply();
    }

}
