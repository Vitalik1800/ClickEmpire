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

    private Constants() {

    }
}
