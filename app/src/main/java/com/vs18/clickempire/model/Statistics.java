package com.vs18.clickempire.model;

/**
 * Stores player game statistics.
 */
public class Statistics {

    /**
     * Total number of clicks.
     */
    private long clicks;

    /**
     * Total play time in seconds.
     */
    private long playTime;

    /**
     * Total earned coins.
     */
    private long earnedCoins;

    /**
     * Highest coin balance reached.
     */
    private long highestBalance;

    /**
     * Total number of purchased upgrades.
     */
    private int purchases;

    /**
     * Creates empty statistics.
     */
    public Statistics() {
        this.clicks = 0;
        this.playTime = 0;
        this.earnedCoins = 0;
        this.highestBalance = 0;
        this.purchases = 0;
    }

    /**
     * Creates statistics with custom values.
     */
    public Statistics(long clicks,
                      long playTime,
                      long earnedCoins,
                      long highestBalance,
                      int purchases) {

        this.clicks = clicks;
        this.playTime = playTime;
        this.earnedCoins = earnedCoins;
        this.highestBalance = highestBalance;
        this.purchases = purchases;
    }

    /**
     * Increments click counter.
     */
    public void addClick() {
        clicks++;
    }

    /**
     * Adds play time.
     *
     * @param seconds play time in seconds
     */
    public void addPlayTime(long seconds) {
        if (seconds > 0) {
            playTime += seconds;
        }
    }

    /**
     * Adds earned coins.
     *
     * @param amount earned coins
     */
    public void addEarnedCoins(long amount) {
        if (amount > 0) {
            earnedCoins += amount;
        }
    }

    /**
     * Updates highest balance if necessary.
     *
     * @param balance current balance
     */
    public void updateHighestBalance(long balance) {
        if (balance > highestBalance) {
            highestBalance = balance;
        }
    }

    /**
     * Increments purchase counter.
     */
    public void addPurchase() {
        purchases++;
    }

    // Getters

    public long getClicks() {
        return clicks;
    }

    public long getPlayTime() {
        return playTime;
    }

    public long getEarnedCoins() {
        return earnedCoins;
    }

    public long getHighestBalance() {
        return highestBalance;
    }

    public int getPurchases() {
        return purchases;
    }

    // Setters


    public void setClicks(long clicks) {
        this.clicks = Math.max(0, clicks);
    }

    public void setPlayTime(long playTime) {
        this.playTime = Math.max(0, playTime);
    }

    public void setEarnedCoins(long earnedCoins) {
        this.earnedCoins = Math.max(0, earnedCoins);
    }

    public void setHighestBalance(long highestBalance) {
        this.highestBalance = Math.max(0, highestBalance);
    }

    public void setPurchases(int purchases) {
        this.purchases = Math.max(0, purchases);
    }
}
