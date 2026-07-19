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
    private final int titleResId;

    /**
     * Achievement description.
     */
    private final int descriptionResId;

    /**
     * Drawable resource id.
     */
    private final int icon;

    /**
     * Condition value required to unlock the achievement.
     */
    private final long condition;

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
     * @param condition required condition value
     */
    public Achievement(
            int id,
            int titleResId,
            int descriptionResId,
            int icon,
            long condition
    ) {
        this.id = id;
        this.titleResId = titleResId;
        this.descriptionResId = descriptionResId;
        this.icon = icon;
        this.condition = condition;
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

    public long getCondition() {
        return condition;
    }

    // Setters

    public void setUnlocked(boolean unlocked) {
        this.unlocked = unlocked;
    }
}
