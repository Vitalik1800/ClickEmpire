package com.vs18.clickempire.controller;

import androidx.annotation.NonNull;

import com.vs18.clickempire.model.Player;
import com.vs18.clickempire.model.Upgrade;

/**
 * Controls shop operations.
 */
public class ShopController {

    private final Player player;
    private final StatisticsController statisticsController;

    /**
     * Creates a new shop controller.
     *
     * @param player player model
     * @param statisticsController statistics model
     */
    public ShopController(Player player, StatisticsController statisticsController) {
        this.player = player;
        this.statisticsController = statisticsController;
    }

    /**
     * Buys an upgrade.
     *
     * @param upgrade upgrade to buy
     * @return true if purchase was successful
     */
    public boolean buyUpgrade(@NonNull Upgrade upgrade) {

        if (!canBuyUpgrade(upgrade)) {
            return false;
        }

        if (!player.spendCoins(upgrade.getPrice())) {
            return false;
        }

        upgrade.buy();

        player.addIncome(upgrade.getIncome());

        statisticsController.addPurchase();

        return true;
    }

    /**
     * Checks whether the player can buy an upgrade.
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
