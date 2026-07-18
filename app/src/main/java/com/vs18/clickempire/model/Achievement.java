package com.vs18.clickempire.model;

/**
 * Represents a single game achievement.
 */
public class Achievement {

    /**
     * Unique achievement identifier.
     */
    private final int id;

    /**
     * Achievement title.
     */
    private int titleResId;

    /**
     * Achievement description.
     */
    private int descriptionResId;

    /**
     * Drawable resource id.
     */
    private int icon;

    /**
     * Achievement unlocked state.
     */
    private boolean unlocked;

    /**
     * Creates a new achievement.
     *
     * @param id unique identifier
     * @param titleResId achievement title
     * @param descriptionResId achievement description
     * @param icon drawable resource id
     */
    public Achievement(int id, int titleResId, int descriptionResId, int icon) {
        this.id = id;
        this.titleResId = titleResId;
        this.descriptionResId = descriptionResId;
        this.icon = icon;
        this.unlocked = false;
    }

    /**
     * Unlocks the achievement.
     */
    public void unlock() {
        unlocked = true;
    }

    /**
     * Locks the achievement.
     * Used when resetting game progress.
     */
    public void lock() {
        unlocked = false;
    }

    /**
     * Returns whether the achievement is unlocked.
     *
     * @return true if unlocked
     */
    public boolean isUnlocked() {
        return unlocked;
    }

    // Getters


    public int getId() {
        return id;
    }

    public int getTitleResId() {
        return titleResId;
    }

    public int getDescriptionResId() {
        return descriptionResId;
    }

    public int getIcon() {
        return icon;
    }

    // Setters


    public void setTitleResId(int titleResId) {
        this.titleResId = titleResId;
    }

    public void setDescriptionResId(int descriptionResId) {
        this.descriptionResId = descriptionResId;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public void setUnlocked(boolean unlocked) {
        this.unlocked = unlocked;
    }
}
