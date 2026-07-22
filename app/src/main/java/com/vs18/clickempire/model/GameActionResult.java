package com.vs18.clickempire.model;

import androidx.annotation.Nullable;

/**
 * Represents the result of a game action.
 */
public class GameActionResult {

    /**
     * Whether the purchase was successful.
     */
    private final boolean success;

    /**
     * LevelUp
     */
    private final boolean levelUp;

    /**
     * Achievement unlocked by this action.
     * Null if no achievement was unlocked.
     */
    @Nullable
    private final Achievement achievement;

    /**
     * Creates a game action result.
     *
     * @param success action success
     * @param achievement unlocked achievement or null
     */
    public GameActionResult(
            boolean success,
            boolean levelUp,
            @Nullable Achievement achievement
        ) {

        this.success = success;
        this.levelUp = levelUp;
        this.achievement = achievement;
    }

    /**
     * Returns whether the purchase was successful.
     *
     * @return true if successful
     */
    public boolean isSuccess() {
        return success;
    }

    /**
     * Returns whether the player leveled up.
     *
     * @return true if level increased
     */
    public boolean isLevelUp() {
        return levelUp;
    }

    /**
     * Returns unlocked achievement.
     *
     * @return unlocked achievement or null
     */
    @Nullable
    public Achievement getAchievement() {
        return achievement;
    }
}
