package com.vs18.clickempire.controller;

import com.vs18.clickempire.model.Achievement;
import com.vs18.clickempire.model.GameActionResult;
import com.vs18.clickempire.model.Player;

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
        boolean levelUp = player.addExperience(1);

        statisticsController.addClick();
        statisticsController.addEarnedCoins(clickPower);
        statisticsController.updateHighestBalance(player.getCoins());

        Achievement achievement =
                achievementController.checkAchievements();

        return new GameActionResult(true, levelUp, achievement);
    }

    /**
     * Adds passive income.
     * Should be called once per second.
     */
    public GameActionResult addPassiveIncome() {

        long income = player.getIncome();

        if (income <= 0) {
            return new GameActionResult(false, false,null);
        }

        player.addCoins(income);

        statisticsController.addEarnedCoins(income);
        updateHighestBalance();

        Achievement achievement =
                achievementController.checkAchievements();

        return new GameActionResult(true, false, achievement);
    }

    /**
     * Increases player level.
     */
    @SuppressWarnings("unused")
    public GameActionResult levelUp() {
        player.levelUp();

        Achievement achievement =
                achievementController.checkAchievements();

        return new GameActionResult(true, true, achievement);
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
    @SuppressWarnings("unused")
    public StatisticsController getStatisticsController() {
        return statisticsController;
    }
}
