package com.vs18.clickempire.controller;

import androidx.annotation.NonNull;

import com.vs18.clickempire.model.Achievement;
import com.vs18.clickempire.model.Player;
import com.vs18.clickempire.model.Statistics;

import java.util.List;

/**
 * Controls game achievements.
 */
public class AchievementController {

    private final List<Achievement> achievements;
    private final Player player;
    private final Statistics statistics;

    /**
     * Creates a new achievement controller.
     *
     * @param achievements achievement list
     * @param player       player model
     * @param statistics   statistics model
     */
    public AchievementController(List<Achievement> achievements, Player player, Statistics statistics) {

        this.achievements = achievements;
        this.player = player;
        this.statistics = statistics;
    }

    /**
     * Checks all achievement conditions.
     */
    public Achievement checkAchievements() {

        for (Achievement achievement : achievements) {

            if (achievement.isUnlocked()) {
                continue;
            }

            long progress = 0;

            switch (achievement.getId()) {

                case 1:
                case 2:
                case 3:
                    progress = statistics.getClicks();
                    break;

                case 4:
                case 5:
                case 6:
                    progress = statistics.getPurchases();
                    break;

                case 7:
                case 8:
                case 9:
                    progress = player.getCoins();
                    break;

                case 10:
                case 11:
                    progress = player.getIncome();
                    break;

                case 12:
                case 13:
                    progress = player.getLevel();
                    break;

                case 14:
                    progress = statistics.getPlayTime();
                    break;

                case 15:
                    progress = statistics.getEarnedCoins();
                    break;

                default:
                    break;
            }

            if (progress >= achievement.getCondition()) {
                unlockAchievement(achievement);
                return achievement;
            }
        }

        return null;
    }

    /**
     * Unlocks an achievement.
     *
     * @param achievement achievement to unlock
     */
    public void unlockAchievement(@NonNull Achievement achievement) {
        achievement.unlock();
    }

    /**
     * Unlocks achievement by id.
     *
     * @param id achievement id
     */
    @SuppressWarnings("unused")
    public void unlockAchievementById(int id) {

        for (Achievement achievement : achievements) {

            if (achievement.getId() == id) {
                unlockAchievement(achievement);
                return;
            }
        }
    }

    /**
     * Returns whether achievement is unlocked.
     *
     * @param id achievement id
     * @return true if unlocked
     */
    public boolean isUnlocked(int id) {

        for (Achievement achievement : achievements) {

            if (achievement.getId() == id) {
                return achievement.isUnlocked();
            }
        }

        return false;
    }

    /**
     * Locks all achievements.
     */
    @SuppressWarnings("unused")
    public void resetAchievements() {

        for (Achievement achievement : achievements) {
            achievement.lock();
        }
    }

    /**
     * Returns all achievements.
     *
     * @return achievement list
     */
    public List<Achievement> getAchievements() {
        return achievements;
    }
}
