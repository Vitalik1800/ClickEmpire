package com.vs18.clickempire.manager;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.vs18.clickempire.model.SaveData;
import com.vs18.clickempire.util.Constants;
import com.vs18.clickempire.util.SaveValidator;

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
    public void save(@NonNull SaveData saveData) {

        try (FileOutputStream outputStream =
                    context.openFileOutput(SAVE_FILE_NAME, Context.MODE_PRIVATE)) {

            String json = gson.toJson(saveData);

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
                     context.openFileInput(SAVE_FILE_NAME);
             InputStreamReader reader =
                     new InputStreamReader(inputStream, StandardCharsets.UTF_8);
             java.io.BufferedReader bufferedReader =
                     new java.io.BufferedReader(reader)) {

            StringBuilder jsonBuilder = new StringBuilder();
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                jsonBuilder.append(line);
            }

            String json = jsonBuilder.toString();

            SaveData saveData = gson.fromJson(json, SaveData.class);

            if (saveData == null) {
                return null;
            }

            if (!SaveValidator.isValid(saveData)) {
                return null;
            }

            return saveData;

        } catch (IOException | JsonSyntaxException e) {
            return null;
        }

    }

    /**
     * Clears all saved data.
     */
    public void deleteSave() {
        context.deleteFile(SAVE_FILE_NAME);
    }
}

