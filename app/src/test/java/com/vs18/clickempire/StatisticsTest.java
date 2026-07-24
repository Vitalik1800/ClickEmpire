package com.vs18.clickempire;

import static org.junit.Assert.assertEquals;

import com.vs18.clickempire.model.Statistics;

import org.junit.Before;
import org.junit.Test;

/**
 * Unit tests for {@link Statistics}.
 */
public class StatisticsTest {

    /**
     * Statistics instance under test.
     */
    private Statistics statistics;

    /**
     * Creates a new statistics object before each test.
     */
    @Before
    public void setUp() {
        statistics = new Statistics();
    }

    /**
     * Verifies that adding a click increments click counter.
     */
    @Test
    public void addClick_shouldIncreaseClicks() {

        statistics.addClick();

        assertEquals(1, statistics.getClicks());
    }

    /**
     * Verifies that adding play time increases total play time.
     */
    @Test
    public void addPlayTime_shouldIncreasePlayTime() {

        statistics.addPlayTime(3600);

        assertEquals(3600, statistics.getPlayTime());
    }

    /**
     * Verifies that adding earned coins increases total earned coins.
     */
    @Test
    public void addEarnedCoins_shouldIncreaseEarnedCoins() {

        statistics.addEarnedCoins(500);

        assertEquals(500, statistics.getEarnedCoins());
    }

    /**
     * Verifies that highest balance is updated only
     * when the new balance is greater.
     */
    @Test
    public void updateHighestBalance_shouldStoreMaximumValue() {

        statistics.updateHighestBalance(100);
        statistics.updateHighestBalance(50);
        statistics.updateHighestBalance(300);

        assertEquals(300, statistics.getHighestBalance());
    }

    /**
     * Verifies that adding a purchase increments purchase counter.
     */
    @Test
    public void addPurchase_shouldIncreasePurchases() {

        statistics.addPurchase();

        assertEquals(1, statistics.getPurchases());
    }

    /**
     * Verifies that setters reset all statistics values.
     */
    @Test
    public void reset_shouldClearAllStatistics() {

        statistics.addClick();
        statistics.addPlayTime(100);
        statistics.addEarnedCoins(500);
        statistics.updateHighestBalance(500);
        statistics.addPurchase();

        statistics.setClicks(0);
        statistics.setPlayTime(0);
        statistics.setEarnedCoins(0);
        statistics.setHighestBalance(0);
        statistics.setPurchases(0);

        assertEquals(0, statistics.getClicks());
        assertEquals(0, statistics.getPlayTime());
        assertEquals(0, statistics.getEarnedCoins());
        assertEquals(0, statistics.getHighestBalance());
        assertEquals(0, statistics.getPurchases());
    }
}
