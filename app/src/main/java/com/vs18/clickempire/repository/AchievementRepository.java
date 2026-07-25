package com.vs18.clickempire.repository;

import androidx.annotation.NonNull;

import com.vs18.clickempire.R;
import com.vs18.clickempire.model.Achievement;

import java.util.ArrayList;
import java.util.List;

public final class AchievementRepository {

    private AchievementRepository() {

    }

    /**
     * Returns the default achievement list.
     *
     * @return list of achievements
     */
    @NonNull
    public static List<Achievement> getAchievements() {

        List<Achievement> achievements = new ArrayList<>();

        achievements.add(new Achievement(
                1,
                R.string.achievement_1_title,
                R.string.achievement_1_description,
                R.drawable.ic_achievement_1,
                1
        ));

        achievements.add(new Achievement(
                2,
                R.string.achievement_2_title,
                R.string.achievement_2_description,
                R.drawable.ic_achievement_2,
                100
        ));

        achievements.add(new Achievement(
                3,
                R.string.achievement_3_title,
                R.string.achievement_3_description,
                R.drawable.ic_achievement_3,
                1_000
        ));

        achievements.add(new Achievement(
                4,
                R.string.achievement_4_title,
                R.string.achievement_4_description,
                R.drawable.ic_achievement_4,
                1
        ));

        achievements.add(new Achievement(
                5,
                R.string.achievement_5_title,
                R.string.achievement_5_description,
                R.drawable.ic_achievement_5,
                10
        ));

        achievements.add(new Achievement(
                6,
                R.string.achievement_6_title,
                R.string.achievement_6_description,
                R.drawable.ic_achievement_6,
                50
        ));

        achievements.add(new Achievement(
                7,
                R.string.achievement_7_title,
                R.string.achievement_7_description,
                R.drawable.ic_achievement_7,
                1_000
        ));

        achievements.add(new Achievement(
                8,
                R.string.achievement_8_title,
                R.string.achievement_8_description,
                R.drawable.ic_achievement_8,
                10_000
        ));

        achievements.add(new Achievement(
                9,
                R.string.achievement_9_title,
                R.string.achievement_9_description,
                R.drawable.ic_achievement_9,
                100_000
        ));

        achievements.add(new Achievement(
                10,
                R.string.achievement_10_title,
                R.string.achievement_10_description,
                R.drawable.ic_achievement_10,
                10
        ));

        achievements.add(new Achievement(
                11,
                R.string.achievement_11_title,
                R.string.achievement_11_description,
                R.drawable.ic_achievement_11,
                100
        ));

        achievements.add(new Achievement(
                12,
                R.string.achievement_12_title,
                R.string.achievement_12_description,
                R.drawable.ic_achievement_12,
                5
        ));

        achievements.add(new Achievement(
                13,
                R.string.achievement_13_title,
                R.string.achievement_13_description,
                R.drawable.ic_achievement_13,
                10
        ));

        achievements.add(new Achievement(
                14,
                R.string.achievement_14_title,
                R.string.achievement_14_description,
                R.drawable.ic_achievement_14,
                3_600
        ));

        achievements.add(new Achievement(
                15,
                R.string.achievement_15_title,
                R.string.achievement_15_description,
                R.drawable.ic_achievement_15,
                1_000_000
        ));

        return achievements;
    }
}