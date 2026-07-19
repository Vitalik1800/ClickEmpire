package com.vs18.clickempire.view.activity;

import android.os.Bundle;
import android.widget.Toast;

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
import com.vs18.clickempire.repository.UpgradeRepository;
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
        upgrades = UpgradeRepository.getUpgrades();
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
                NumberFormatter.format(player.getCoins())
        );

        binding.textIncome.setText(
                NumberFormatter.format(player.getIncome())
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

        if (!result.isSuccess()) {

            Toast.makeText(
                    this,
                    R.string.not_enough_coins,
                    Toast.LENGTH_SHORT
            ).show();

            return;

        }

        updateUi();

        Toast.makeText(
                this,
                R.string.purchase_success,
                Toast.LENGTH_SHORT
        ).show();

        UiUtils.showAchievement(this, result);

    }

    @Override
    protected void onResume() {
        super.onResume();
        updateUi();
    }
}