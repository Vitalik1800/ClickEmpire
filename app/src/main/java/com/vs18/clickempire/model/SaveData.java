package com.vs18.clickempire.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents the complete game save.
 */
public class SaveData {

    /**
     * Player state.
     */
    private Player player;

    /**
     * Player statistics.
     */
    private Statistics statistics;

    /**
     * Purchased upgrades.
     */
    private List<Upgrade> upgrades;

    /**
     * Unlocked achievements.
     */
    private List<Achievement> achievements;

    /**
     * Last save timestamp.
     */
    private long lastSaveTime;

    /**
     * Creates empty save data.
     */
    public SaveData() {
        this.player = new Player();
        this.statistics = new Statistics();
        this.upgrades = new ArrayList<>();
        this.achievements = new ArrayList<>();
        this.lastSaveTime = System.currentTimeMillis();
    }

    /**
     * Creates save data.
     */
    public SaveData(Player player,
                    Statistics statistics,
                    List<Upgrade> upgrades,
                    List<Achievement> achievements,
                    long lastSaveTime) {

        this.player = player;
        this.statistics = statistics;
        this.upgrades = upgrades;
        this.achievements = achievements;
        this.lastSaveTime = lastSaveTime;
    }

    // Getters


    public Player getPlayer() {
        return player;
    }

    public Statistics getStatistics() {
        return statistics;
    }

    public List<Upgrade> getUpgrades() {
        return upgrades;
    }

    public List<Achievement> getAchievements() {
        return achievements;
    }

    public long getLastSaveTime() {
        return lastSaveTime;
    }

    // Setters


    public void setPlayer(Player player) {
        this.player = player;
    }

    public void setStatistics(Statistics statistics) {
        this.statistics = statistics;
    }

    public void setUpgrades(List<Upgrade> upgrades) {
        this.upgrades = upgrades;
    }

    public void setAchievements(List<Achievement> achievements) {
        this.achievements = achievements;
    }

    public void setLastSaveTime(long lastSaveTime) {
        this.lastSaveTime = lastSaveTime;
    }
}
