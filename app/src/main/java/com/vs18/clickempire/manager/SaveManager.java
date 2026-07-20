package com.vs18.clickempire.manager;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;

import com.google.gson.Gson;
import com.vs18.clickempire.model.SaveData;
import com.vs18.clickempire.util.Constants;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

/**
 * Manages game save and load operations.
 */
public class SaveManager {

    private static final String SAVE_FILE_NAME = "save.json";
    private final Context context;
    private final Gson gson;

    /**
     * Creates a new save manager.
     *
     * @param context application context
     */
    public SaveManager(@NonNull Context context) {
        this.context = context.getApplicationContext();
        this.gson = new Gson();
    }

    /**
     * Saves the game.
     *
     * @param saveData save data
     */
    public void save(SaveData saveData) {

        try (FileOutputStream outputStream =
                    context.openFileOutput(SAVE_FILE_NAME, Context.MODE_PRIVATE)) {

            String json = gson.toJson(saveData);

            Log.d(Constants.TAG, json);

            Log.d(Constants.TAG,
                    "Saving: coins=" + saveData.getPlayer().getCoins()
                            + ", clickPower=" + saveData.getPlayer().getClickPower()
                            + ", income=" + saveData.getPlayer().getIncome()
                            + ", level=" + saveData.getPlayer().getLevel());

            outputStream.write(json.getBytes(StandardCharsets.UTF_8));

        } catch (IOException e) {
            Log.e(Constants.TAG, "Error saving data: " + e.getMessage());
        }
    }

    /**
     * Loads the game.
     *
     * @return save data
     */
    public SaveData load() {

        try (FileInputStream inputStream =
                    context.openFileInput(SAVE_FILE_NAME)) {

            InputStreamReader reader =
                    new InputStreamReader(inputStream, StandardCharsets.UTF_8);

            SaveData saveData = gson.fromJson(reader, SaveData.class);

            Log.d(Constants.TAG,
                    "Loaded: coins=" + saveData.getPlayer().getCoins()
                            + ", clickPower=" + saveData.getPlayer().getClickPower()
                            + ", income=" + saveData.getPlayer().getIncome()
                            + ", level=" + saveData.getPlayer().getLevel());

            return saveData;

        } catch (IOException e) {
            Log.e(Constants.TAG, "Error loading data: " + e.getMessage());
            return null;
        }

    }

    /**
     * Clears all saved data.
     */
    public void reset() {
        context.deleteFile(SAVE_FILE_NAME);
    }
}

