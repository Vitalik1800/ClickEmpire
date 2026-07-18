package com.vs18.clickempire.storage;

import android.content.Context;
import android.content.SharedPreferences;

import androidx.annotation.NonNull;

import com.google.gson.Gson;
import com.vs18.clickempire.model.SaveData;

public class SaveManager {

    private static final String PREF_NAME = "click_empire";
    private static final String KEY_SAVE_DATA = "save_data";

    private final SharedPreferences sharedPreferences;
    private final Gson gson;

    /**
     * Creates a new save manager.
     *
     * @param context application context
     */
    public SaveManager(@NonNull Context context) {
        sharedPreferences = context.getSharedPreferences(
                PREF_NAME,
                Context.MODE_PRIVATE
        );

        gson = new Gson();
    }

    /**
     * Saves the game.
     *
     * @param saveData save data
     */
    public void save(SaveData saveData) {

        if (saveData == null) {
            return;
        }

        String json = gson.toJson(saveData);

        sharedPreferences.edit()
                .putString(KEY_SAVE_DATA, json)
                .apply();
    }

    /**
     * Loads the game.
     *
     * @return save data
     */
    public SaveData load() {

        String json = sharedPreferences.getString(KEY_SAVE_DATA, null);

        if (json == null || json.isEmpty()) {
            return null;
        }

        return gson.fromJson(json, SaveData.class);
    }

    /**
     * Clears all saved data.
     */
    public void reset() {

        sharedPreferences.edit()
                .remove(KEY_SAVE_DATA)
                .apply();

    }
}

