package com.vs18.clickempire.util;

import androidx.annotation.NonNull;

import com.vs18.clickempire.model.Player;
import com.vs18.clickempire.model.SaveData;

/**
 * Validates loaded save data.
 */
public final class SaveValidator {

    /**
     * Expected achievement count.
     */

    private static final int ACHIEVEMENT_COUNT = 15;

    /**
     * Expected upgrade count.
     */
    private static final int UPGRADE_COUNT = 20;

    private SaveValidator() {

    }

    /**
     * Checks whether save data is valid.
     *
     * @param saveData save data
     * @return true if save data is valid
     */
    public static boolean isValid(@NonNull SaveData saveData) {

        if (saveData.getPlayer() == null
                || saveData.getStatistics() == null
                || saveData.getAchievements() == null
                || saveData.getUpgrades() == null) {
            return false;
        }

        if (saveData.getAchievements().size() != ACHIEVEMENT_COUNT) {
            return false;
        }

        if (saveData.getUpgrades().size() != UPGRADE_COUNT) {
            return false;
        }

        Player player = saveData.getPlayer();

        if (player.getCoins() < 0) {
            return false;
        }

        if (player.getClickPower() < 1) {
            return false;
        }

        if (player.getIncome() < 0) {
            return false;
        }

        if (player.getLevel() < 1
                || player.getLevel() > Constants.MAX_LEVEL) {
            return false;
        }

        if (player.getExperience() < 0) {
            return false;
        }

        long saveTime = saveData.getLastSaveTime();

        return saveTime > 0
                && saveTime <= System.currentTimeMillis();

    }

}
