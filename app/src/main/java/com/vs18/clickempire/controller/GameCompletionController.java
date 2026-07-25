package com.vs18.clickempire.controller;

import android.util.Log;

import androidx.annotation.NonNull;

import com.vs18.clickempire.model.Achievement;
import com.vs18.clickempire.model.Player;
import com.vs18.clickempire.model.Upgrade;
import com.vs18.clickempire.util.Constants;

import java.util.List;

/**
 * Controls game completion state.
 */
public class GameCompletionController {

    /**
     * Player model.
     */
    private final Player player;

    /**
     * Upgrade list.
     */
    private final List<Upgrade> upgrades;

    /**
     * Achievement list.
     */
    private final List<Achievement> achievements;

    /**
     * Creates a new controller.
     *
     * @param player player model
     * @param upgrades upgrade list
     * @param achievements achievement list
     */
    public GameCompletionController(
            @NonNull Player player,
            @NonNull List<Upgrade> upgrades,
            @NonNull List<Achievement> achievements
    ) {

        this.player = player;
        this.upgrades = upgrades;
        this.achievements = achievements;
    }

    /**
     * Returns whether the game
     * has been completed.
     *
     * @return true if completed
     */
    public boolean isGameCompleted() {

        return hasMaxLevel()
                && areAllUpgradesMaxed()
                && areAllAchievementsUnlocked();
    }

    /**
     * Returns whether the player
     * reached the maximum level.
     *
     * @return true if max level
     */
    private boolean hasMaxLevel() {
        return player.getLevel() >= Constants.MAX_LEVEL;
    }

    /**
     * Returns whether every upgrade
     * has reached its maximum level.
     *
     * @return true if all upgrades are maxed
     */
    private boolean areAllUpgradesMaxed() {

        for (Upgrade upgrade : upgrades) {

            if (upgrade.getLevel()
                    < Constants.MAX_UPGRADE_LEVEL) {

                return false;
            }
        }

        return true;
    }

    /**
     * Returns whether every achievement
     * has been unlocked.
     *
     * @return true if all achievements are unlocked
     */
    private boolean areAllAchievementsUnlocked() {

        for (Achievement achievement : achievements) {

            if (!achievement.isUnlocked()) {
                return false;
            }
        }

        return true;
    }
}
