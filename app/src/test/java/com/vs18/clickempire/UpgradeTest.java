package com.vs18.clickempire;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import com.vs18.clickempire.model.Upgrade;

import org.junit.Before;
import org.junit.Test;

/**
 * Unit tests for Upgrade.
 */
public class UpgradeTest {

    /**
     * Upgrade under test.
     */
    private Upgrade upgrade;

    /**
     * Creates a fresh upgrade before every test.
     */
    @Before
    public void setUp() {

        upgrade = new Upgrade(
                1,
                1,
                2,
                3,
                100,
                10
        );
    }

    /**
     * Upgrade should be created with correct values.
     */
    @Test
    public void constructor_shouldInitializeFields() {

        assertEquals(1, upgrade.getId());
        assertEquals(1, upgrade.getNameResId());
        assertEquals(2, upgrade.getDescriptionResId());
        assertEquals(3, upgrade.getIcon());
        assertEquals(100, upgrade.getPrice());
        assertEquals(10, upgrade.getIncome());
        assertEquals(0, upgrade.getLevel());
    }

    /**
     * New upgrade should have level zero.
     */
    @Test
    public void defaultLevel_shouldBeZero() {

        assertEquals(0, upgrade.getLevel());
    }

    /**
     * Buying upgrade should increase level.
     */
    @Test
    public void buy_shouldIncreaseLevel() {

        upgrade.buy();

        assertEquals(1, upgrade.getLevel());
    }

    /**
     * Buying upgrade should increase price.
     */
    @Test
    public void buy_shouldIncreasePrice() {

        long oldPrice = upgrade.getPrice();

        upgrade.buy();

        assertTrue(upgrade.getPrice() > oldPrice);
    }

    /**
     * Price should increase after calling increasePrice().
     */
    @Test
    public void increasePrice_shouldIncreasePrice() {

        long oldPrice = upgrade.getPrice();

        upgrade.increasePrice();

        assertTrue(upgrade.getPrice() > oldPrice);
    }

    /**
     * New upgrade should have zero total income.
     */
    @Test
    public void totalIncome_newUpgrade_shouldBeZero() {

        assertEquals(0, upgrade.getTotalIncome());
    }

    /**
     * Buying upgrade should increase total income.
     */
    @Test
    public void buy_shouldIncreaseTotalIncome() {

        assertEquals(0, upgrade.getTotalIncome());

        upgrade.buy();
        assertEquals(10, upgrade.getTotalIncome());

        upgrade.buy();
        assertEquals(20, upgrade.getTotalIncome());

        upgrade.buy();
        assertEquals(30, upgrade.getTotalIncome());
    }

    /**
     * Multiple purchases should increase
     * both level and total income.
     */
    @Test
    public void multiplePurchases_shouldIncreaseLevelAndIncome() {

        for (int i = 0; i < 5; i++) {
            upgrade.buy();
        }

        assertEquals(5, upgrade.getLevel());
        assertEquals(50, upgrade.getTotalIncome());
        assertTrue(upgrade.getPrice() > 100);
    }
}
