package com.vs18.clickempire.controller;

import com.vs18.clickempire.model.SaveData;
import com.vs18.clickempire.manager.SaveManager;

/**
 * Controls game save and load operations.
 */
public class SaveController {

    private final SaveManager saveManager;

    /**
     * Creates a new save controller.
     *
     * @param saveManager save manager
     */
    public SaveController(SaveManager saveManager) {
        this.saveManager = saveManager;
    }

    /**
     * Saves the game.
     *
     * @param saveData game save data
     */
    public void saveGame(SaveData saveData) {
        saveManager.save(saveData);
    }

    /**
     * Loads the game.
     *
     * @return loaded save data
     */
    public SaveData loadGame() {
        return saveManager.load();
    }

    /**
     * Performs auto save.
     *
     * @param saveData game save data
     */
    public void autoSave(SaveData saveData) {
        saveManager.save(saveData);
    }

    /**
     * Resets all game progress.
     */
    public void resetGame() {
        saveManager.reset();
    }
}
