package com.vs18.clickempire.view.activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.vs18.clickempire.R;
import com.vs18.clickempire.controller.AchievementController;
import com.vs18.clickempire.controller.ShopController;
import com.vs18.clickempire.controller.StatisticsController;
import com.vs18.clickempire.databinding.ActivityShopBinding;
import com.vs18.clickempire.manager.GameManager;
import com.vs18.clickempire.model.GameActionResult;
import com.vs18.clickempire.model.Player;
import com.vs18.clickempire.model.Statistics;
import com.vs18.clickempire.model.Upgrade;
import com.vs18.clickempire.util.NumberFormatter;
import com.vs18.clickempire.util.UiUtils;
import com.vs18.clickempire.view.adapter.UpgradeAdapter;

import java.util.List;

public class ShopActivity extends AppCompatActivity {

    private ActivityShopBinding binding;

    private Player player;
    private Statistics statistics;

    private StatisticsController statisticsController;
    private ShopController shopController;
    private AchievementController achievementController;

    private List<Upgrade> upgrades;

    private UpgradeAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityShopBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        initializeModels();
        initializeControllers();
        initializeRecyclerView();

        updateUi();
    }

    /**
     * Initializes models.
     */
    private void initializeModels() {
        player = GameManager.getPlayer();
        statistics = GameManager.getStatistics();
        upgrades = GameManager.getUpgrades();
    }

    /**
     * Initializes controllers.
     */
    private void initializeControllers() {

        achievementController = new AchievementController(
                GameManager.getAchievements(),
                player,
                statistics
        );

        statisticsController = new StatisticsController(statistics);

        shopController = new ShopController(player, statisticsController, achievementController);
    }

    /**
     * Initializes RecyclerView.
     */
    private void initializeRecyclerView() {

        adapter = new UpgradeAdapter(
                player,
                upgrades,
                this::buyUpgrade
        );

        binding.recyclerViewUpgrades.setLayoutManager(
                new LinearLayoutManager(this)
        );

        binding.recyclerViewUpgrades.setAdapter(adapter);
    }

    /**
     * Updates shop UI.
     */
    private void updateUi() {

        binding.textBalance.setText(
                getString(
                        R.string.balance_format,
                        NumberFormatter.format(player.getCoins())
                )
        );

        binding.textIncome.setText(
                getString(
                        R.string.income_format,
                        NumberFormatter.format(player.getIncome())
                )
        );

        adapter.notifyDataSetChanged();
    }

    /**
     * Buys selected upgrade.
     *
     * @param upgrade selected upgrade
     */
    private void buyUpgrade(Upgrade upgrade) {

        GameActionResult result = shopController.buyUpgrade(upgrade);

        UiUtils.showUpgradeWithAchievement(
                binding.getRoot(),
                upgrade,
                result
        );

        if (!result.isSuccess()) {
            return;
        }

        GameManager.saveGame();
        updateUi();
    }

    @Override
    protected void onPause() {
        super.onPause();
        GameManager.saveGame();
    }

    @Override
    protected void onResume() {
        super.onResume();
        updateUi();
    }
}