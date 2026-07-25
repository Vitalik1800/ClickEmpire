package com.vs18.clickempire.model;

/**
 * Stores user game settings.
 */
@SuppressWarnings("unused")
public class Settings {

    /**
     * Sound effects enabled.
     */
    private boolean soundEnabled;

    /**
     * Background music enabled.
     */
    private boolean musicEnabled;

    /**
     * Vibration enabled.
     */
    private boolean vibrationEnabled;

    /**
     * Creates default settings.
     */
    public Settings() {
        this.soundEnabled = true;
        this.musicEnabled = true;
        this.vibrationEnabled = true;
    }

    /**
     * Creates settings with custom values.
     */
    public Settings(boolean soundEnabled,
                    boolean musicEnabled,
                    boolean vibrationEnabled) {

        this.soundEnabled = soundEnabled;
        this.musicEnabled = musicEnabled;
        this.vibrationEnabled = vibrationEnabled;
    }

    // Getters


    public boolean isSoundEnabled() {
        return soundEnabled;
    }

    public boolean isMusicEnabled() {
        return musicEnabled;
    }

    public boolean isVibrationEnabled() {
        return vibrationEnabled;
    }

    // Setters


    public void setSoundEnabled(boolean soundEnabled) {
        this.soundEnabled = soundEnabled;
    }

    public void setMusicEnabled(boolean musicEnabled) {
        this.musicEnabled = musicEnabled;
    }

    public void setVibrationEnabled(boolean vibrationEnabled) {
        this.vibrationEnabled = vibrationEnabled;
    }
}
