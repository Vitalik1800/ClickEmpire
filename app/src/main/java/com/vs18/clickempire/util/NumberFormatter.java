package com.vs18.clickempire.util;

import androidx.annotation.NonNull;

import java.util.Locale;

public final class NumberFormatter {

    private NumberFormatter() {

    }

    /**
     * Formats a number into a readable string.
     *
     * @param value number
     * @return formatted value
     */
    @NonNull
    public static String format(long value) {

        if (value < 1_000) {
            return String.valueOf(value);
        }

        if (value < 1_000_000) {
            return String.format(Locale.ROOT, "%.2fK", value / 1_000.0);
        }

        if (value < 1_000_000_000) {
            return String.format(Locale.ROOT, "%.2fM", value / 1_000_000.0);
        }

        if (value < 1_000_000_000_000L) {
            return String.format(Locale.ROOT, "%.2fB", value / 1_000_000_000.0);
        }

        return String.format(Locale.ROOT, "%.2fT", value / 1_000_000_000_000.0);
    }

}
