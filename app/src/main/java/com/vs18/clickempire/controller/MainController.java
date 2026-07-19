package com.vs18.clickempire.controller;

import android.util.Log;

import com.vs18.clickempire.model.Achievement;
import com.vs18.clickempire.model.GameActionResult;
import com.vs18.clickempire.model.Player;
import com.vs18.clickempire.util.Constants;

/**
 * Main game controller.
 * Handles the core game mechanics.
 */
public class MainController {

    private final Player player;
    private final StatisticsController statisticsController;
    private final AchievementController achievementController;

    /**
     * Creates a new main controller.
     *
     * @param player player model
     * @param statisticsController statistics model
     */
    public MainController(
            Player player,
            StatisticsController statisticsController,
            AchievementController achievementController
    ) {
        this.player = player;
        this.statisticsController = statisticsController;
        this.achievementController = achievementController;
    }

    /**
     * Handles a player click.
     */
    public GameActionResult click() {

        long clickPower = player.getClickPower();

        player.addCoins(clickPower);

        statisticsController.addClick();
        statisticsController.addEarnedCoins(clickPower);
        statisticsController.updateHighestBalance(player.getCoins());

        achievementController.checkAchievements();

        Achievement achievement =
                achievementController.checkAchievements();

        return new GameActionResult(true, achievement);
    }

    /**
     * Adds passive income.
     * Should be called once per second.
     */
    public GameActionResult addPassiveIncome() {

        long income = player.getIncome();

        Log.d(Constants.TAG,
                "Income = " + income);

        if (income <= 0) {
            return new GameActionResult(false, null);
        }

        player.addCoins(income);

        Log.d(Constants.TAG,
                "Coins = " + player.getCoins());

        statisticsController.addEarnedCoins(income);
        statisticsController.updateHighestBalance(player.getCoins());

        achievementController.checkAchievements();

        Achievement achievement =
                achievementController.checkAchievements();

        return new GameActionResult(true, achievement);
    }

    /**
     * Increases player level.
     */
    public GameActionResult levelUp() {
        player.levelUp();

        Achievement achievement =
                achievementController.checkAchievements();

        return new GameActionResult(true, achievement);
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
