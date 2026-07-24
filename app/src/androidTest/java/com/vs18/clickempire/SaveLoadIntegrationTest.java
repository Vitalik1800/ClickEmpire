package com.vs18.clickempire;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.test.core.app.ApplicationProvider;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.vs18.clickempire.manager.SaveManager;
import com.vs18.clickempire.model.Achievement;
import com.vs18.clickempire.model.Player;
import com.vs18.clickempire.model.SaveData;
import com.vs18.clickempire.model.Statistics;
import com.vs18.clickempire.model.Upgrade;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.List;

/**
 * Integration tests for save/load functionality.
 */
@RunWith(AndroidJUnit4.class)
public class SaveLoadIntegrationTest {

    /**
     * Save manager.
     */
    private SaveManager saveManager;

    /**
     * Test context.
     */
    private Context context;

    /**
     * Creates test objects.
     */
    @Before
    public void setUp() {

        context = ApplicationProvider.getApplicationContext();

        saveManager = new SaveManager(context);

        saveManager.deleteSave();
    }

    /**
     * Removes save file after every test.
     */
    @After
    public void tearDown() {
        saveManager.deleteSave();
    }

    /**
     * Verifies that saved player data
     * is restored correctly.
     */
    @Test
    public void saveAndLoad_shouldRestorePlayer() {

        Player player = new Player();
        player.addCoins(5000);
        player.addIncome(25);
        player.increaseClickPower(4);

        SaveData saveData = new SaveData(
                player,
                new Statistics(),
                createUpgrades(),
                createAchievements(),
                123456789L
        );

        saveManager.save(saveData);

        SaveData loaded = saveManager.load();

        assertNotNull(loaded);

        assertEquals(
                player.getCoins(),
                loaded.getPlayer().getCoins()
        );

        assertEquals(
                player.getIncome(),
                loaded.getPlayer().getIncome()
        );

        assertEquals(
                player.getClickPower(),
                loaded.getPlayer().getClickPower()
        );
    }

    /**
     * Verifies that statistics
     * are saved and restored.
     */
    @Test
    public void saveAndLoad_shouldRestoreStatistics() {

        Statistics statistics = new Statistics();

        statistics.addClick();
        statistics.addClick();
        statistics.addPurchase();
        statistics.addEarnedCoins(2000);
        statistics.updateHighestBalance(1500);

        SaveData saveData = new SaveData(
                new Player(),
                statistics,
                createUpgrades(),
                createAchievements(),
                System.currentTimeMillis()
        );

        saveManager.save(saveData);

        SaveData loaded = saveManager.load();

        assertNotNull(loaded);

        assertEquals(
                statistics.getClicks(),
                loaded.getStatistics().getClicks()
        );

        assertEquals(
                statistics.getPurchases(),
                loaded.getStatistics().getPurchases()
        );

        assertEquals(
                statistics.getEarnedCoins(),
                loaded.getStatistics().getEarnedCoins()
        );

        assertEquals(
                statistics.getHighestBalance(),
                loaded.getStatistics().getHighestBalance()
        );
    }

    /**
     * Verifies that upgrades
     * are saved and restored.
     */
    @Test
    public void saveAndLoad_shouldRestoreUpgrades() {

        List<Upgrade> upgrades = createUpgrades();

        Upgrade upgrade = upgrades.get(0);

        upgrade.buy();
        upgrade.buy();

        SaveData saveData = new SaveData(
                new Player(),
                new Statistics(),
                upgrades,
                createAchievements(),
                System.currentTimeMillis()
        );

        saveManager.save(saveData);

        SaveData loaded = saveManager.load();

        assertNotNull(loaded);

        assertEquals(20, loaded.getUpgrades().size());

        Upgrade loadedUpgrade =
                loaded.getUpgrades().get(0);

        assertEquals(
                upgrade.getLevel(),
                loadedUpgrade.getLevel()
        );

        assertEquals(
                upgrade.getPrice(),
                loadedUpgrade.getPrice()
        );

        assertEquals(
                upgrade.getIncome(),
                loadedUpgrade.getIncome()
        );
    }

    /**
     * Verifies that achievements
     * are saved and restored.
     */
    @Test
    public void saveAndLoad_shouldRestoreAchievements() {

        List<Achievement> achievements =
                new ArrayList<>();

        for (int i = 1; i <= 15; i++) {

            Achievement achievement =
                    new Achievement(
                            i,
                            i,
                            i,
                            i,
                            i * 100L
                    );

            if (i == 1) {
                achievement.unlock();
            }

            achievements.add(achievement);
        }

        SaveData saveData = new SaveData(
                new Player(),
                new Statistics(),
                createUpgrades(),
                achievements,
                100L
        );

        saveManager.save(saveData);

        SaveData loaded = saveManager.load();

        assertNotNull(loaded);

        assertEquals(
                15,
                loaded.getAchievements().size()
        );

        assertTrue(
                loaded.getAchievements()
                        .get(0)
                        .isUnlocked()
        );
    }

    /**
     * Verifies that deleting save
     * removes the save file.
     */
    @Test
    public void deleteSave_shouldRemoveFile() {

        saveManager.save(new SaveData());

        saveManager.deleteSave();

        SaveData loaded = saveManager.load();

        assertNull(loaded);
    }

    /**
     * Verifies that last save time
     * is restored correctly.
     */
    @Test
    public void saveAndLoad_shouldRestoreLastSaveTime() {

        long time = System.currentTimeMillis();

        SaveData saveData = new SaveData(
                new Player(),
                new Statistics(),
                createUpgrades(),
                createAchievements(),
                time
        );

        saveManager.save(saveData);

        SaveData loaded = saveManager.load();

        assertNotNull(loaded);

        assertEquals(
                time,
                loaded.getLastSaveTime()
        );
    }

    /**
     * Verifies that loading
     * without a save returns null.
     */
    @Test
    public void load_withoutSave_shouldReturnNull() {

        saveManager.deleteSave();

        SaveData loaded = saveManager.load();

        assertNull(loaded);
    }

    /**
     * Creates a valid upgrade list.
     */
    @NonNull
    private List<Upgrade> createUpgrades() {

        List<Upgrade> upgrades = new ArrayList<>();

        for (int i = 1; i <= 20; i++) {

            upgrades.add(
                    new Upgrade(
                            i,
                            i,
                            i,
                            i,
                            100,
                            5
                    )
            );
        }

        return upgrades;
    }

    /**
     * Creates a valid achievement list.
     */
    @NonNull
    private List<Achievement> createAchievements() {

        List<Achievement> achievements = new ArrayList<>();

        for (int i = 1; i <= 15; i++) {

            achievements.add(
                    new Achievement(
                            i,
                            i,
                            i,
                            i,
                            i * 100L
                    )
            );
        }

        return achievements;
    }

}
