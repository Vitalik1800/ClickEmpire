package com.vs18.clickempire.util;

public final class OfflineIncomeCalculator {

    private OfflineIncomeCalculator() {

    }

    /**
     * Calculates offline income.
     *
     * @param income coins per second
     * @param offlineTime offline time in seconds
     * @return earned coins
     */
    public static long calculate(long income, long offlineTime) {

        if (income <= 0 || offlineTime <= 0) {
            return 0;
        }

        long time = Math.min(
                offlineTime,
                Constants.OFFLINE_LIMIT
        );

        return income * time;
    }

}
