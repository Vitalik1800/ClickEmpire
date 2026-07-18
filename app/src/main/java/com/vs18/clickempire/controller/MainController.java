package com.vs18.clickempire.controller;

import com.vs18.clickempire.model.Player;

/**
 * Main game controller.
 * Handles the core game mechanics.
 */
public class MainController {

    private final Player player;
    private final StatisticsController statisticsController;

    /**
     * Creates a new main controller.
     *
     * @param player player model
     * @param statisticsController statistics model
     */
    public MainController(Player player, StatisticsController statisticsController) {
        this.player = player;
        this.statisticsController = statisticsController;
    }

    /**
     * Handles a player click.
     */
    public void click() {

        long clickPower = player.getClickPower();

        player.addCoins(clickPower);

        statisticsController.addClick();
        statisticsController.addEarnedCoins(clickPower);
        statisticsController.updateHighestBalance(player.getCoins());
    }

    /**
     * Adds passive income.
     * Should be called once per second.
     */
    public void addPassiveIncome() {

        long income = player.getIncome();

        if (income <= 0) {
            return;
        }

        player.addCoins(income);

        statisticsController.addEarnedCoins(income);
        statisticsController.updateHighestBalance(player.getCoins());
    }

    /**
     * Increases player level.
     */
    public void levelUp() {
        player.levelUp();
    }

    /**
     * Updates highest balance.
     */
    public void updateHighestBalance() {
        statisticsController.updateHighestBalance(player.getCoins());
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
