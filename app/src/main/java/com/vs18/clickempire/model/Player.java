package com.vs18.clickempire.model;

import com.vs18.clickempire.util.Constants;

/**
 * Represents the current state of the player.
 */
public class Player {

    /**
     * Current amount of coins.
     */

    private long coins;

    /**
     * Coins earned per click.
     */
    private long clickPower;

    /**
     * Passive income per second.
     */
    private long income;

    /**
     * Current player level.
     */
    private int level;

    /**
     * Current experience.
     */
    private long experience;

    /**
     * Creates a new player with default values.
     */
    public Player() {

        this.coins = 0;
        this.clickPower = 1;
        this.income = 0;
        this.level = 1;
        this.experience = 0;
    }

    /**
     * Creates a player with custom values.
     */
    public Player(long coins, long clickPower, long income, int level, long experience) {
        this.coins = coins;
        this.clickPower = clickPower;
        this.income = income;
        this.level = level;
        this.experience = experience;
    }

    /**
     * Adds coins.
     *
     * @param amount amount to add
     */
    public void addCoins(long amount) {

        if (amount <= 0) {
            return;
        }

        coins += amount;

    }

    /**
     * Spends coins if possible.
     *
     * @param amount amount to spend
     * @return true if successful, otherwise false
     */
    public boolean spendCoins(long amount) {

        if (amount <= 0) {
            return false;
        }

        if (coins >= amount) {
            coins -= amount;
            return true;
        }

        return false;
    }

    /**
     * Checks whether the player can click.wav an item.
     *
     * @param price item price
     * @return true if enough coins
     */
    public boolean canBuy(long price) {

        if (price <= 0) {
            return false;
        }

        return coins >= price;
    }

    /**
     * Increases player level.
     */
    public void levelUp() {

        if (level < Constants.MAX_LEVEL) {
            setLevel(level + 1);
            setClickPower(level);
        }

    }

    /**
     * Increases click power.
     *
     * @param value value to add
     */
    public void increaseClickPower(long value) {
        if (value > 0) {
            clickPower += value;
        }
    }

    /**
     * Increases passive income.
     *
     * @param value income to add
     */
    public void addIncome(long value) {
        if (value > 0) {
            income += value;
        }
    }

    /**
     * Adds experience.
     *
     * @param value experience to add
     */
    public boolean addExperience(long value) {

        if (value <= 0) {
            return false;
        }

        experience += value;

        return checkLevelUp();
    }

    /**
     * Checks whether the player can level up.
     */
    public boolean checkLevelUp() {

        boolean leveledUp = false;

        while (experience >= getRequiredExperience()
                && level < Constants.MAX_LEVEL) {

            experience -= getRequiredExperience();
            levelUp();

            leveledUp = true;
        }

        return leveledUp;
    }

    /**
     * Returns required experience for the next level.
     *
     * @return required experience
     */
    public long getRequiredExperience() {
        return level * 100L;
    }

    // Getters

    public long getCoins() {
        return coins;
    }

    public long getClickPower() {
        return clickPower;
    }

    public long getIncome() {
        return income;
    }

    public int getLevel() {
        return level;
    }

    public long getExperience() {
        return experience;
    }

    // Setters

    public void setCoins(long coins) {

        this.coins = Math.max(0, coins);
    }

    public void setClickPower(long clickPower) {
        this.clickPower = Math.max(1, clickPower);
    }

    public void setIncome(long income) {
        this.income = Math.max(0, income);
    }

    public void setLevel(int level) {
        this.level = Math.max(1, level);
    }

    @SuppressWarnings("unused")
    public void setExperience(long experience) {
        this.experience = Math.max(0, experience);
    }
}
