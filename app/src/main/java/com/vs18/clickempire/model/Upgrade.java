package com.vs18.clickempire.model;

import com.vs18.clickempire.util.Constants;

/**
 * Represents a single shop upgrade.
 */
public class Upgrade {

    /**
     * Unique upgrade identifier.
     */
    private final int id;

    /**
     * Upgrade name.
     */
    private int nameResId;

    /**
     * Upgrade description.
     */
    private int descriptionResId;

    /**
     * Drawable resource id.
     */
    private int icon;

    /**
     * Current upgrade price.
     */
    private long price;

    /**
     * Passive income gained per purchase.
     */
    private long income;

    /**
     * Upgrade level (number of purchases).
     */
    private int level;

    /**
     * Creates a new upgrade.
     */
    public Upgrade(int id,
                   int nameResId,
                   int descriptionResId,
                   int icon,
                   long price,
                   long income) {

        this.id = id;
        this.nameResId = nameResId;
        this.descriptionResId = descriptionResId;
        this.icon = icon;
        this.price = price;
        this.income = income;
        this.level = 0;
    }

    /**
     * Performs upgrade purchase.
     */
    public void buy() {

        setLevel(level + 1);

        increasePrice();

    }

    /**
     * Increases upgrade price.
     */
    public void increasePrice() {
        price = Math.round(price * Constants.PRICE_MULTIPLIER);
    }

    // Getters

    public int getId() {
        return id;
    }

    public int getNameResId() {
        return nameResId;
    }

    public int getDescriptionResId() {
        return descriptionResId;
    }

    public int getIcon() {
        return icon;
    }

    public long getPrice() {
        return price;
    }

    public long getIncome() {
        return income;
    }

    public int getLevel() {
        return level;
    }

    // Setters

    public void setNameResId(int nameResId) {
        this.nameResId = nameResId;
    }

    public void setDescriptionResId(int descriptionResId) {
        this.descriptionResId = descriptionResId;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public void setPrice(long price) {
        this.price = Math.max(0, price);
    }

    public void setIncome(long income) {
        this.income = Math.max(0, income);
    }

    public void setLevel(int level) {
        this.level = Math.max(0, level);
    }
}
