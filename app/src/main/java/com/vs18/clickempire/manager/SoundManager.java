package com.vs18.clickempire.manager;

import android.content.Context;
import android.media.AudioAttributes;
import android.media.SoundPool;

import androidx.annotation.NonNull;

import com.vs18.clickempire.R;

/**
 * Manages game sound effects.
 */
public class SoundManager {

    private SoundPool soundPool;

    private int clickSound;
    private int buySound;
    private int achievementSound;
    private int levelUpSound;
    private int errorSound;

    private SettingsManager settingsManager;

    /**
     * Initializes sound manager.
     *
     * @param context application context
     */
    public void initialize(@NonNull Context context) {

        settingsManager = new SettingsManager(
                context.getApplicationContext()
        );

        AudioAttributes audioAttributes =
                new AudioAttributes.Builder()
                        .setUsage(AudioAttributes.USAGE_GAME)
                        .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                        .build();

        soundPool = new SoundPool.Builder()
                .setMaxStreams(5)
                .setAudioAttributes(audioAttributes)
                .build();

        clickSound = soundPool.load(context, R.raw.click, 1);
        buySound = soundPool.load(context, R.raw.buy, 1);
        achievementSound = soundPool.load(context, R.raw.achievement, 1);
        levelUpSound = soundPool.load(context, R.raw.level_up, 1);
        errorSound = soundPool.load(context, R.raw.error, 1);
    }

    /**
     * Plays a sound.
     *
     * @param soundId loaded sound id
     */
    public void play(int soundId) {

        if (soundPool == null) {
            return;
        }

        if (!settingsManager.isSoundEnabled()) {
            return;
        }

        soundPool.play(
                soundId,
                1f,
                1f,
                1,
                0,
                1f
        );
    }

    /**
     * Releases all sound resources.
     */
    public void release() {

        if (soundPool != null) {
            soundPool.release();
            soundPool = null;
        }
    }

    /**
     * Returns click sound id.
     */
    public int getClickSound() {
        return clickSound;
    }

    /**
     * Returns purchase sound id.
     */
    public int getBuySound() {
        return buySound;
    }

    /**
     * Returns achievement sound id.
     */
    public int getAchievementSound() {
        return achievementSound;
    }

    /**
     * Returns levelUp sound id.
     */
    public int getLevelUpSound() {
        return levelUpSound;
    }

    /**
     * Returns error sound id.
     */
    public int getErrorSound() {
        return errorSound;
    }
}
