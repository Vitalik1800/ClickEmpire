package com.vs18.clickempire;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import com.vs18.clickempire.controller.AchievementController;
import com.vs18.clickempire.controller.ShopController;
import com.vs18.clickempire.controller.StatisticsController;
import com.vs18.clickempire.model.Achievement;
import com.vs18.clickempire.model.GameActionResult;
import com.vs18.clickempire.model.Player;
import com.vs18.clickempire.model.Statistics;
import com.vs18.clickempire.model.Upgrade;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Integration tests for gameplay scenarios.
 */
public class GameplayIntegrationTest {

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
     * Shop controller.
     */
    private ShopController shopController;

    /**
     * Test upgrade.
     */
    private Upgrade upgrade;

    /**
     * Creates test objects.
     */
    @Before
    public void setUp() {

        player = new Player();
        statistics = new Statistics();

        statisticsController =
                new StatisticsController(statistics);

        List<Achievement> achievements =
                new ArrayList<>();

        achievementController =
                new AchievementController(
                        achievements,
                        player,
                        statistics
                );

        shopController =
                new ShopController(
                        player,
                        statisticsController,
                        achievementController
                );

        upgrade = new Upgrade(
                1,
                1,
                2,
                3,
                100,
                5
        );
    }

    /**
     * Verifies that one thousand clicks
     * correctly update the player
     * and game statistics.
     */
    @Test
    public void gameplay_1000Clicks_shouldUpdatePlayerAndStatistics() {

        for (int i = 0; i < 1000; i++) {

            player.addCoins(player.getClickPower());

            statisticsController.addClick();

            statisticsController.addEarnedCoins(
                    player.getClickPower()
            );

            statisticsController.updateHighestBalance(
                    player.getCoins()
            );
        }

        assertEquals(
                1000,
                player.getCoins()
        );

        assertEquals(
                1000,
                statisticsController.getClicks()
        );

        assertEquals(
                1000,
                statisticsController.getEarnedCoins()
        );

        assertEquals(
                1000,
                statisticsController.getHighestBalance()
        );
    }

    /**
     * Verifies that multiple upgrade purchases
     * correctly update the gameplay state.
     */
    @Test
    public void gameplay_multiplePurchases_shouldUpdateGameState() {

        player.addCoins(10000);

        int purchases = 0;

        while (shopController.canBuyUpgrade(upgrade)) {

            GameActionResult result =
                    shopController.buyUpgrade(upgrade);

            assertTrue(result.isSuccess());

            purchases++;
        }

        assertTrue(purchases > 1);

        assertEquals(
                purchases,
                statisticsController.getPurchases()
        );

        assertEquals(
                purchases,
                upgrade.getLevel()
        );

        assertEquals(
                purchases * upgrade.getIncome(),
                player.getIncome()
        );
    }

    /**
     * Verifies the complete gameplay flow
     * from clicking to purchasing upgrades.
     */
    @Test
    public void gameplay_completeScenario_shouldWorkCorrectly() {

        for (int i = 0; i < 1000; i++) {

            player.addCoins(player.getClickPower());

            statisticsController.addClick();

            statisticsController.addEarnedCoins(
                    player.getClickPower()
            );

            statisticsController.updateHighestBalance(
                    player.getCoins()
            );
        }

        while (shopController.canBuyUpgrade(upgrade)) {
            shopController.buyUpgrade(upgrade);
        }

        assertTrue(player.getIncome() > 0);

        assertTrue(
                statisticsController.getPurchases() > 0
        );

        assertTrue(upgrade.getLevel() > 0);

        assertTrue(player.getCoins() >= 0);

        assertEquals(
                statistics.getClicks(),
                statisticsController.getClicks()
        );

        assertEquals(
                statistics.getPurchases(),
                statisticsController.getPurchases()
        );

        assertEquals(
                statistics.getEarnedCoins(),
                statisticsController.getEarnedCoins()
        );

        assertEquals(
                statistics.getHighestBalance(),
                statisticsController.getHighestBalance()
        );
    }
}
