package com.vs18.clickempire.controller;

import com.vs18.clickempire.model.Statistics;

/**
 * Controls game statistics.
 */
public class StatisticsController {

    private final Statistics statistics;

    /**
     * Creates a new statistics controller.
     *
     * @param statistics statistics model
     */
    public StatisticsController(Statistics statistics) {
        this.statistics = statistics;
    }

    /**
     * Adds one click.
     */
    public void addClick() {
        statistics.addClick();
    }

    /**
     * Adds earned coins.
     *
     * @param amount earned coins
     */
    public void addEarnedCoins(long amount) {
        statistics.addEarnedCoins(amount);
    }

    /**
     * Adds play time.
     *
     * @param seconds play time in seconds
     */
    public void addPlayTime(long seconds) {
        statistics.addPlayTime(seconds);
    }

    /**
     * Adds one purchase.
     */
    public void addPurchase() {
        statistics.addPurchase();
    }

    /**
     * Updates highest balance.
     *
     * @param balance current balance
     */
    public void updateHighestBalance(long balance) {
        statistics.updateHighestBalance(balance);
    }

    /**
     * Returns statistics model.
     *
     * @return statistics
     */
    public Statistics getStatistics() {
        return statistics;
    }
}
