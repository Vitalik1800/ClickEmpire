package com.vs18.clickempire.util;

@SuppressWarnings("unused")
public final class TimeUtils {

    private TimeUtils() {

    }

    /**
     * Returns current system time.
     *
     * @return current time in milliseconds
     */
    public static long getCurrentTime() {
        return System.currentTimeMillis();
    }

    /**
     * Calculates offline time.
     *
     * @param lastSaveTime last save time
     * @return offline time in seconds
     */
    public static long calculateOfflineTime(long lastSaveTime) {

        long currentTime = getCurrentTime();

        long seconds = (currentTime - lastSaveTime) / 1000;

        return Math.max(0, seconds);

    }

}
