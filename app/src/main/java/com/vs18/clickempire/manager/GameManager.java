package com.vs18.clickempire.manager;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;

import com.vs18.clickempire.model.Achievement;
import com.vs18.clickempire.model.Player;
import com.vs18.clickempire.model.SaveData;
import com.vs18.clickempire.model.Statistics;
import com.vs18.clickempire.model.Upgrade;
import com.vs18.clickempire.repository.AchievementRepository;
import com.vs18.clickempire.repository.UpgradeRepository;
import com.vs18.clickempire.util.Constants;

import org.jetbrains.annotations.Contract;

import java.util.List;

/**
 * Stores the current game state.
 */
public final class GameManager {

    private static Player player = new Player();

    private static Statistics statistics = new Statistics();

    private static List<Achievement> achievements = AchievementRepository.getAchievements();

    private static List<Upgrade> upgrades = UpgradeRepository.getUpgrades();

    private static SaveManager saveManager;

    private GameManager() {

    }

    /**
     * Load Game.
     */
    public static void loadGame(@NonNull SaveData saveData) {

        if (saveData.getPlayer() != null) {
            player = saveData.getPlayer();

            Log.d(Constants.TAG,
                    "Player hash = " + System.identityHashCode(player));
        }

        if (saveData.getStatistics() != null) {
            statistics = saveData.getStatistics();
        }

        if (saveData.getAchievements() != null) {
            achievements = saveData.getAchievements();
        }

        if (saveData.getUpgrades() != null) {
            upgrades = saveData.getUpgrades();
        }
    }

    public static boolean loadGame() {

        if (saveManager == null) {
            return false;
        }

        SaveData saveData = saveManager.load();

        if (saveData == null) {
            return false;
        }

        loadGame(saveData);

        return true;
    }

    /**
     * Initialize saveManager.
     */
    public static void initializeSaveManager(@NonNull Context context) {
        saveManager = new SaveManager(context.getApplicationContext());
    }

    /**
     * Initialize saveGame.
     */
    public static void saveGame() {

        if (saveManager != null) {
            saveManager.save(createSaveData());
        }
    }

    /**
     * Creates current game save.
     *
     * @return save data
     */
    @NonNull
    @Contract(" -> new")
    public static SaveData createSaveData() {

        return new SaveData(
                player,
                statistics,
                upgrades,
                achievements,
                System.currentTimeMillis()
        );
    }

    /**
     * Returns current player.
     */
    public static Player getPlayer() {
        return player;
    }

    /**
     * Returns current statistics.
     */
    public static Statistics getStatistics() {
        return statistics;
    }

    /**
     * Returns achievement list.
     *
     * @return achievements
     */
    public static List<Achievement> getAchievements() {
        return achievements;
    }

    public static List<Upgrade> getUpgrades() {
        return upgrades;
    }

    public static void setPlayer(Player player) {
        GameManager.player = player;
    }

    public static void setStatistics(Statistics statistics) {
        GameManager.statistics = statistics;
    }

    public static void setAchievements(List<Achievement> achievements) {
        GameManager.achievements = achievements;
    }

    public static void setUpgrades(List<Upgrade> upgrades) {
        GameManager.upgrades = upgrades;
    }
}
