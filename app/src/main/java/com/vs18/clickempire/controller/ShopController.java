package com.vs18.clickempire.controller;

import androidx.annotation.NonNull;

import com.vs18.clickempire.model.Achievement;
import com.vs18.clickempire.model.GameActionResult;
import com.vs18.clickempire.model.Player;
import com.vs18.clickempire.model.Upgrade;

/**
 * Controls shop operations.
 */
public class ShopController {

    private final Player player;
    private final StatisticsController statisticsController;
    private final AchievementController achievementController;

    /**
     * Creates a new shop controller.
     *
     * @param player player model
     * @param statisticsController statistics model
     */
    public ShopController(
            Player player,
            StatisticsController statisticsController,
            AchievementController achievementController
    ) {
        this.player = player;
        this.statisticsController = statisticsController;
        this.achievementController = achievementController;
    }

    /**
     * Buys an upgrade.
     *
     * @param upgrade upgrade to click.wav.wav
     * @return true if purchase was successful
     */
    public GameActionResult buyUpgrade(@NonNull Upgrade upgrade) {

        if (!canBuyUpgrade(upgrade)) {
            return new GameActionResult(false, false,null);
        }

        if (!player.spendCoins(upgrade.getPrice())) {
            return new GameActionResult(false, false,null);
        }

        upgrade.buy();

        player.addIncome(upgrade.getIncome());

        statisticsController.addPurchase();

        Achievement achievement =
                achievementController.checkAchievements();

        return new GameActionResult(true, false, achievement);
    }

    /**
     * Checks whether the player can click.wav an upgrade.
     *
     * @param upgrade upgrade
     * @return true if player has enough coins
     */
    public boolean canBuyUpgrade(@NonNull Upgrade upgrade) {
        return player.canBuy(upgrade.getPrice());
    }

    /**
     * Returns current upgrade price.
     *
     * @param upgrade upgrade
     * @return current price
     */
    public long getUpgradePrice(@NonNull Upgrade upgrade) {
        return upgrade.getPrice();
    }

    /**
     * Returns player model.
     */
    public Player getPlayer() {
        return player;
    }

    /**
     * Returns statistics model.
     */
    public StatisticsController getStatisticsController() {
        return statisticsController;
    }
}
