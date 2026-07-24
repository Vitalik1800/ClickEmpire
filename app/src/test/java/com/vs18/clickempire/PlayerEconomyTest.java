package com.vs18.clickempire;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import com.vs18.clickempire.model.Player;

import org.junit.Before;
import org.junit.Test;

/**
 * Unit tests for player economy.
 */
public class PlayerEconomyTest {

    /**
     * Player under test.
     */
    private Player player;

    /**
     * Creates a fresh player before every test.
     */
    @Before
    public void setUp() {
        player = new Player();
    }

    /**
     * Coins should be added successfully.
     */
    @Test
    public void addCoins_shouldIncreaseBalance() {

        player.addCoins(100);

        assertEquals(100, player.getCoins());
    }

    /**
     * Adding zero coins should not change balance.
     */
    @Test
    public void addCoins_zero_shouldDoNothing() {

        player.addCoins(0);

        assertEquals(0, player.getCoins());
    }

    /**
     * Negative coin amount should be ignored.
     */
    @Test
    public void addCoins_negative_shouldDoNothing() {

        player.addCoins(-50);

        assertEquals(0, player.getCoins());
    }

    /**
     * Very large values should be supported.
     */
    @Test
    public void addCoins_largeValue_shouldWork() {

        player.addCoins(Long.MAX_VALUE);

        assertEquals(Long.MAX_VALUE, player.getCoins());
    }

    /**
     * Spending coins should decrease balance.
     */
    @Test
    public void spendCoins_shouldDecreaseBalance() {

        player.addCoins(500);

        assertTrue(player.spendCoins(200));

        assertEquals(300, player.getCoins());
    }

    /**
     * Spending all coins should leave zero balance.
     */
    @Test
    public void spendCoins_allCoins_shouldBecomeZero() {

        player.addCoins(300);

        assertTrue(player.spendCoins(300));

        assertEquals(0, player.getCoins());
    }

    /**
     * Spending more coins than available should fail.
     */
    @Test
    public void spendCoins_notEnoughCoins_shouldReturnFalse() {

        player.addCoins(100);

        assertFalse(player.spendCoins(200));

        assertEquals(100, player.getCoins());
    }

    /**
     * Spending zero or negative coins should fail.
     */
    @Test
    public void spendCoins_zeroOrNegative_shouldReturnFalse() {

        player.addCoins(100);

        assertFalse(player.spendCoins(0));
        assertFalse(player.spendCoins(-10));

        assertEquals(100, player.getCoins());
    }

    /**
     * Player should be able to buy an item
     * when enough coins are available.
     */
    @Test
    public void canBuy_enoughCoins_shouldReturnTrue() {

        player.addCoins(500);

        assertTrue(player.canBuy(300));
    }

    /**
     * Player should not be able to buy an item
     * when there are not enough coins.
     */
    @Test
    public void canBuy_notEnoughCoins_shouldReturnFalse() {

        player.addCoins(100);

        assertFalse(player.canBuy(200));
    }
}