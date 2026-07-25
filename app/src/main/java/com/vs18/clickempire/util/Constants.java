package com.vs18.clickempire.util;

/**
 * Application constants.
 */
public final class Constants {

    /**
     * Auto save interval (30 seconds).
     */
    public static final long SAVE_INTERVAL = 30_000L;

    /**
     * Maximum offline income time (8 hours).
     */
    public static final long OFFLINE_LIMIT = 8 * 60 * 60;

    /**
     * Upgrade price multiplier.
     */
    public static final double PRICE_MULTIPLIER = 1.15;

    /**
     * Maximum player level.
     */
    public static final int MAX_LEVEL = 100;

    /**
     * Passive income update interval (1 second).
     */
    public static final long PASSIVE_INCOME_INTERVAL = 1000L;

    /**
     * Coin click animation scale.
     */
    public static final float CLICK_ANIMATION_SCALE = 0.9f;

    /**
     * Coin click animation duration (milliseconds).
     */
    public static final long CLICK_ANIMATION_DURATION = 70L;

    /**
     * Enabled button alpha.
     */
    public static final float BUTTON_ENABLED_ALPHA = 1.0f;

    /**
     * Disabled button alpha.
     */
    public static final float BUTTON_DISABLED_ALPHA = 0.5f;

    /**
     * Default animation scale.
     */
    public static final float DEFAULT_ANIMATION_SCALE = 1.0f;

    /**
     * Seconds of hour
     */
    public static final long SECONDS_OF_HOUR = 3600L;

    /**
     * Minutes of hour
     */
    public static final long SECONDS_OF_MINUTE = 60L;

    /**
     * Android Logs
     */
    public static final String TAG = "ClickEmpire";

    /**
     * Maximum level for each upgrade.
     */
    public static final int MAX_UPGRADE_LEVEL = 100;

    private Constants() {

    }
}
