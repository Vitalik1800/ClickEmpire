package com.vs18.clickempire.manager;

import com.vs18.clickempire.model.Player;
import com.vs18.clickempire.model.Statistics;

/**
 * Stores the current game state.
 */
public final class GameManager {

    private static final Player player = new Player();
    private static final Statistics statistics = new Statistics();

    private GameManager() {

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
}
