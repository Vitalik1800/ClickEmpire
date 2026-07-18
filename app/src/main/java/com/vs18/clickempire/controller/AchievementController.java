package com.vs18.clickempire.controller;

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
     * @param player player model
     * @param statistics statistics model
     */
    public AchievementController(List<Achievement> achievements,
                                 Player player,
                                 Statistics statistics) {

        this.achievements = achievements;
        this.player = player;
        this.statistics = statistics;
    }

    /**
     * Checks all achievement conditions.
     */
    public void checkAchievements() {

        for (Achievement achievement : achievements) {

            if (achievement.isUnlocked()) {
                continue;
            }

            switch (achievement.getId()) {

                // First Click
                case 1:
                    if (statistics.getClicks() >= 1) {
                        achievement.unlock();
                    }
                    break;

                // 100 Clicks
                case 2:
                    if (statistics.getClicks() >= 100) {
                        achievement.unlock();
                    }
                    break;

                // 1000 Clicks
                case 3:
                    if (statistics.getClicks() >= 1000) {
                        achievement.unlock();
                    }
                    break;

                // First Upgrade
                case 4:
                    if (statistics.getPurchases() >= 1) {
                        achievement.unlock();
                    }
                    break;

                // 10 Upgrades
                case 5:
                    if (statistics.getPurchases() >= 10) {
                        achievement.unlock();
                    }
                    break;

                // 50 Upgrades
                case 6:
                    if (statistics.getPurchases() >= 50) {
                        achievement.unlock();
                    }
                    break;

                // 1 000 Coins
                case 7:
                    if (player.getCoins() >= 1_000) {
                        achievement.unlock();
                    }
                    break;

                // 10 000 Coins
                case 8:
                    if (player.getCoins() >= 10_000) {
                        achievement.unlock();
                    }
                    break;

                // 100 000 Coins
                case 9:
                    if (player.getCoins() >= 100_000) {
                        achievement.unlock();
                    }
                    break;

                // Passive income 10/sec
                case 10:
                    if (player.getIncome() >= 10) {
                        achievement.unlock();
                    }
                    break;

                // Passive income 100/sec
                case 11:
                    if (player.getIncome() >= 100) {
                        achievement.unlock();
                    }
                    break;

                // Level 5
                case 12:
                    if (player.getLevel() >= 5) {
                        achievement.unlock();
                    }
                    break;

                // Level 10
                case 13:
                    if (player.getLevel() >= 10) {
                        achievement.unlock();
                    }
                    break;

                // 1 Hour Play Time
                case 14:
                    if (statistics.getPlayTime() >= 3600) {
                        achievement.unlock();
                    }
                    break;

                // Millionaire
                case 15:
                    if (statistics.getEarnedCoins() >= 1_000_000) {
                        achievement.unlock();
                    }
                    break;

                default:
                    break;
            }
        }
    }

    /**
     * Unlocks achievement manually.
     *
     * @param id achievement id
     */
    public void unlockAchievement(int id) {

        for (Achievement achievement : achievements) {

            if (achievement.getId() == id) {
                achievement.unlock();
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
