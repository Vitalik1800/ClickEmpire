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
     * Game statistics.
     */
    private Statistics statistics;

    /**
     * User settings.
     */
    private Settings settings;

    /**
     * All upgrades.
     */
    private List<Upgrade> upgrades;

    /**
     * All achievements.
     */
    private List<Achievement> achievements;

    /**
     * Last save time in milliseconds.
     */
    private long lastSaveTime;

    /**
     * Creates a new save with default values.
     */
    public SaveData() {
        this.player = new Player();
        this.statistics = new Statistics();
        this.settings = new Settings();
        this.upgrades = new ArrayList<>();
        this.achievements = new ArrayList<>();
        this.lastSaveTime = System.currentTimeMillis();
    }

    /**
     * Creates a save with custom values.
     */
    public SaveData(Player player,
                    Statistics statistics,
                    Settings settings,
                    List<Upgrade> upgrades,
                    List<Achievement> achievements,
                    long lastSaveTime) {

        this.player = player;
        this.statistics = statistics;
        this.settings = settings;
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

    public Settings getSettings() {
        return settings;
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

    public void setSettings(Settings settings) {
        this.settings = settings;
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
