package com.vs18.clickempire;

import static org.junit.Assert.assertTrue;

import com.vs18.clickempire.controller.AchievementController;
import com.vs18.clickempire.controller.StatisticsController;
import com.vs18.clickempire.model.Achievement;
import com.vs18.clickempire.model.Player;
import com.vs18.clickempire.model.Statistics;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Integration tests for achievements and statistics.
 */
public class AchievementStatisticsIntegrationTest {

    /**
     * Player model.
     */
    private Player player;

    /**
     * Statistics model.
     */
    private Statistics statistics;

    /**
     * Statistics controller.
     */
    private StatisticsController statisticsController;

    /**
     * Achievement controller.
     */
    private AchievementController achievementController;

    /**
     * Achievement list.
     */
    private List<Achievement> achievements;

    /**
     * Creates test objects.
     */
    @Before
    public void setUp() {

        player = new Player();
        statistics = new Statistics();

        statisticsController =
                new StatisticsController(statistics);

        achievements = new ArrayList<>();

        achievements.add(
                new Achievement(
                        1,
                        1,
                        1,
                        1,
                        10
                )
        );

        achievements.add(
                new Achievement(
                        4,
                        2,
                        2,
                        2,
                        5
                )
        );

        achievements.add(
                new Achievement(
                        7,
                        3,
                        3,
                        3,
                        1000
                )
        );

        achievements.add(
                new Achievement(
                        10,
                        4,
                        4,
                        4,
                        50
                )
        );

        achievements.add(
                new Achievement(
                        12,
                        5,
                        5,
                        5,
                        2
                )
        );

        achievements.add(
                new Achievement(
                        14,
                        6,
                        6,
                        6,
                        60
                )
        );

        achievements.add(
                new Achievement(
                        15,
                        7,
                        7,
                        7,
                        500
                )
        );

        achievementController =
                new AchievementController(
                        achievements,
                        player,
                        statistics
                );
    }

    /**
     * Verifies that click statistics
     * unlock the click achievement.
     */
    @Test
    public void clicks_shouldUnlockAchievement() {

        for (int i = 0; i < 10; i++) {
            statisticsController.addClick();
        }

        achievementController.checkAchievements();

        assertTrue(
                achievementController.isUnlocked(1)
        );
    }

    /**
     * Verifies that purchase statistics
     * unlock the purchase achievement.
     */
    @Test
    public void purchases_shouldUnlockAchievement() {

        for (int i = 0; i < 5; i++) {
            statisticsController.addPurchase();
        }

        achievementController.checkAchievements();

        assertTrue(
                achievementController.isUnlocked(4)
        );
    }

    /**
     * Verifies that player balance
     * unlocks the coin achievement.
     */
    @Test
    public void coins_shouldUnlockAchievement() {

        player.addCoins(1000);

        achievementController.checkAchievements();

        assertTrue(
                achievementController.isUnlocked(7)
        );
    }

    /**
     * Verifies that passive income
     * unlocks the income achievement.
     */
    @Test
    public void income_shouldUnlockAchievement() {

        player.addIncome(50);

        achievementController.checkAchievements();

        assertTrue(
                achievementController.isUnlocked(10)
        );
    }

    /**
     * Verifies that player level
     * unlocks the level achievement.
     */
    @Test
    public void level_shouldUnlockAchievement() {

        player.setLevel(2);

        achievementController.checkAchievements();

        assertTrue(
                achievementController.isUnlocked(12)
        );
    }

    /**
     * Verifies that play time
     * unlocks the play time achievement.
     */
    @Test
    public void playTime_shouldUnlockAchievement() {

        statisticsController.addPlayTime(60);

        achievementController.checkAchievements();

        assertTrue(
                achievementController.isUnlocked(14)
        );
    }

    /**
     * Verifies that earned coins
     * unlock the earned coins achievement.
     */
    @Test
    public void earnedCoins_shouldUnlockAchievement() {

        statisticsController.addEarnedCoins(500);

        achievementController.checkAchievements();

        assertTrue(
                achievementController.isUnlocked(15)
        );
    }

}
