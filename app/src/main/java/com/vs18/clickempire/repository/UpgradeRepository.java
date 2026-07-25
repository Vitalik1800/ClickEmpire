package com.vs18.clickempire.repository;

import androidx.annotation.NonNull;

import com.vs18.clickempire.R;
import com.vs18.clickempire.model.Upgrade;

import java.util.ArrayList;
import java.util.List;

/**
 * Provides default game upgrades.
 */
public final class UpgradeRepository {

    private UpgradeRepository() {

    }

    /**
     * Returns the default upgrade list.
     *
     * @return list of upgrades
     */
    @NonNull
    public static List<Upgrade> getUpgrades() {

        List<Upgrade> upgrades = new ArrayList<>();

        upgrades.add(new Upgrade(
                1,
                R.string.upgrade_1_name,
                R.string.upgrade_1_description,
                R.drawable.ic_upgrade_1,
                10,
                1
        ));

        upgrades.add(new Upgrade(
                2,
                R.string.upgrade_2_name,
                R.string.upgrade_2_description,
                R.drawable.ic_upgrade_2,
                50,
                2
        ));

        upgrades.add(new Upgrade(
                3,
                R.string.upgrade_3_name,
                R.string.upgrade_3_description,
                R.drawable.ic_upgrade_3,
                150,
                5
        ));

        upgrades.add(new Upgrade(
                4,
                R.string.upgrade_4_name,
                R.string.upgrade_4_description,
                R.drawable.ic_upgrade_4,
                500,
                10
        ));

        upgrades.add(new Upgrade(
                5,
                R.string.upgrade_5_name,
                R.string.upgrade_5_description,
                R.drawable.ic_upgrade_5,
                1_500,
                20
        ));

        upgrades.add(new Upgrade(
                6,
                R.string.upgrade_6_name,
                R.string.upgrade_6_description,
                R.drawable.ic_upgrade_6,
                5_000,
                40
        ));

        upgrades.add(new Upgrade(
                7,
                R.string.upgrade_7_name,
                R.string.upgrade_7_description,
                R.drawable.ic_upgrade_7,
                12_000,
                75
        ));

        upgrades.add(new Upgrade(
                8,
                R.string.upgrade_8_name,
                R.string.upgrade_8_description,
                R.drawable.ic_upgrade_8,
                30_000,
                150
        ));

        upgrades.add(new Upgrade(
                9,
                R.string.upgrade_9_name,
                R.string.upgrade_9_description,
                R.drawable.ic_upgrade_9,
                75_000,
                300
        ));

        upgrades.add(new Upgrade(
                10,
                R.string.upgrade_10_name,
                R.string.upgrade_10_description,
                R.drawable.ic_upgrade_10,
                150_000,
                600
        ));

        upgrades.add(new Upgrade(
                11,
                R.string.upgrade_11_name,
                R.string.upgrade_11_description,
                R.drawable.ic_upgrade_11,
                300_000,
                1_000
        ));

        upgrades.add(new Upgrade(
                12,
                R.string.upgrade_12_name,
                R.string.upgrade_12_description,
                R.drawable.ic_upgrade_12,
                700_000,
                2_000
        ));

        upgrades.add(new Upgrade(
                13,
                R.string.upgrade_13_name,
                R.string.upgrade_13_description,
                R.drawable.ic_upgrade_13,
                1_500_000,
                4_000
        ));

        upgrades.add(new Upgrade(
                14,
                R.string.upgrade_14_name,
                R.string.upgrade_14_description,
                R.drawable.ic_upgrade_14,
                3_000_000,
                8_000
        ));

        upgrades.add(new Upgrade(
                15,
                R.string.upgrade_15_name,
                R.string.upgrade_15_description,
                R.drawable.ic_upgrade_15,
                7_000_000,
                15_000
        ));

        upgrades.add(new Upgrade(
                16,
                R.string.upgrade_16_name,
                R.string.upgrade_16_description,
                R.drawable.ic_upgrade_16,
                15_000_000,
                30_000
        ));

        upgrades.add(new Upgrade(
                17,
                R.string.upgrade_17_name,
                R.string.upgrade_17_description,
                R.drawable.ic_upgrade_17,
                35_000_000,
                60_000
        ));

        upgrades.add(new Upgrade(
                18,
                R.string.upgrade_18_name,
                R.string.upgrade_18_description,
                R.drawable.ic_upgrade_18,
                80_000_000,
                120_000
        ));

        upgrades.add(new Upgrade(
                19,
                R.string.upgrade_19_name,
                R.string.upgrade_19_description,
                R.drawable.ic_upgrade_19,
                180_000_000,
                250_000
        ));

        upgrades.add(new Upgrade(
                20,
                R.string.upgrade_20_name,
                R.string.upgrade_20_description,
                R.drawable.ic_upgrade_20,
                500_000_000,
                500_000
        ));

        return upgrades;
    }
}