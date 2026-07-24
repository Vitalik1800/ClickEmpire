package com.vs18.clickempire;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import com.vs18.clickempire.model.Achievement;

import org.junit.Before;
import org.junit.Test;

/**
 * Unit tests for Achievement.
 */
public class AchievementTest {

    /**
     * Achievement under test.
     */
    private Achievement achievement;

    /**
     * Creates a new achievement before every test.
     */
    @Before
    public void setUp() {

        achievement = new Achievement(
                1,
                101,
                102,
                103,
                100
        );
    }

    /**
     * Constructor should initialize all fields.
     */
    @Test
    public void constructor_shouldInitializeFields() {

        assertEquals(1, achievement.getId());
        assertEquals(101, achievement.getTitleResId());
        assertEquals(102, achievement.getDescriptionResId());
        assertEquals(103, achievement.getIcon());
        assertEquals(100, achievement.getCondition());
        assertFalse(achievement.isUnlocked());
    }

    /**
     * Unlock should change achievement state.
     */
    @Test
    public void unlock_shouldSetUnlockedTrue() {

        achievement.unlock();

        assertTrue(achievement.isUnlocked());
    }

    /**
     * Lock should change achievement state.
     */
    @Test
    public void lock_shouldSetUnlockedFalse() {

        achievement.unlock();

        achievement.lock();

        assertFalse(achievement.isUnlocked());
    }

    /**
     * Setter should update unlocked state.
     */
    @Test
    public void setUnlocked_shouldUpdateState() {

        achievement.setUnlocked(true);
        assertTrue(achievement.isUnlocked());

        achievement.setUnlocked(false);
        assertFalse(achievement.isUnlocked());
    }

    /**
     * Achievement should return correct identifier.
     */
    @Test
    public void getId_shouldReturnCorrectValue() {

        assertEquals(1, achievement.getId());
    }

    /**
     * Achievement should return correct resources.
     */
    @Test
    public void getters_shouldReturnCorrectResources() {

        assertEquals(101, achievement.getTitleResId());
        assertEquals(102, achievement.getDescriptionResId());
        assertEquals(103, achievement.getIcon());
    }

    /**
     * Achievement should return correct unlock condition.
     */
    @Test
    public void getCondition_shouldReturnCorrectValue() {

        assertEquals(100, achievement.getCondition());
    }
}
