package com.vs18.clickempire.util;

import androidx.annotation.NonNull;

import java.util.Locale;

/**
 * Formats play time.
 */
public final class TimeFormatter {

    private TimeFormatter() {

    }

    /**
     * Formats seconds to HH:mm:ss.
     *
     * @param seconds play time in seconds
     * @return formatted time
     */
    @NonNull
    public static String format(long seconds) {

        long hours = seconds / Constants.SECONDS_0F_HOUR;
        long minutes = (seconds % Constants.SECONDS_0F_HOUR) / Constants.MINUTES_OF_HOUR;
        long secs = seconds % Constants.MINUTES_OF_HOUR;

        return String.format(
                Locale.getDefault(),
                "%02d:%02d:%02d",
                hours,
                minutes,
                secs
        );

    }

}
