package com.vs18.clickempire.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.vs18.clickempire.R;
import com.vs18.clickempire.controller.AchievementController;
import com.vs18.clickempire.controller.MainController;
import com.vs18.clickempire.controller.StatisticsController;
import com.vs18.clickempire.databinding.ActivityMainBinding;
import com.vs18.clickempire.manager.GameManager;
import com.vs18.clickempire.model.GameActionResult;
import com.vs18.clickempire.model.Player;
import com.vs18.clickempire.model.Statistics;
import com.vs18.clickempire.util.Constants;
import com.vs18.clickempire.util.NumberFormatter;
import com.vs18.clickempire.util.UiUtils;

/**
 * Main game screen.
 */
public class MainActivity extends AppCompatActivity {

    private Player player;
    private Statistics statistics;

    private MainController mainController;
    private StatisticsController statisticsController;
    private AchievementController achievementController;

    private ActivityMainBinding binding;

    private final Handler handler = new Handler(Looper.getMainLooper());

    private final Runnable passiveIncomeRunnable = new Runnable() {
        @Override
        public void run() {

            Log.d(Constants.TAG, "Passive income tick");

            GameActionResult result = mainController.addPassiveIncome();

            updateUi();

            UiUtils.showAchievement(MainActivity.this, result);

            handler.postDelayed(this, Constants.PASSIVE_INCOME_INTERVAL);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.bottomNavigation.setSelectedItemId(R.id.navigation_home);

        initializeModels();
        initializeControllers();

        initializeViews();
        setupListeners();
        setupBottomNavigation();

        updateUi();
    }

    /**
     * Initializes game models.
     */
    private void initializeModels() {
        player = GameManager.getPlayer();
        statistics = GameManager.getStatistics();

        player.setIncome(10);
        player.setClickPower(5);
        player.setLevel(7);
    }

    /**
     * Initializes controllers.
     */
    private void initializeControllers() {
        statisticsController = new StatisticsController(statistics);

        achievementController = new AchievementController(
                GameManager.getAchievements(),
                player,
                statistics
        );

        mainController = new MainController(player, statisticsController, achievementController);


    }

    /**
     * Initializes UI components.
     */
    private void initializeViews() {

    }

    /**
     * Initializes click listeners.
     */
    private void setupListeners() {

        binding.buttonCoin.setOnClickListener(view -> {

            playClickAnimation();

            GameActionResult result = mainController.click();

            updateUi();

            UiUtils.showAchievement(this, result);
        });

    }

    /**
     * Updates all game information.
     */
    private void updateUi() {

        binding.textBalance.setText(
                NumberFormatter.format(player.getCoins())
        );

        binding.textIncome.setText(
                NumberFormatter.format(player.getIncome())
        );

        binding.textClickPower.setText(
                NumberFormatter.format(player.getClickPower())
        );

        binding.textLevel.setText(
                String.valueOf(player.getLevel())
        );
    }

    /**
     * Starts passive income timer.
     */
    private void startPassiveIncome() {
        handler.postDelayed(
                passiveIncomeRunnable,
                Constants.PASSIVE_INCOME_INTERVAL
        );
    }

    /**
     * Plays coin click animation.
     */
    private void playClickAnimation() {

        binding.buttonCoin.animate()
                .scaleX(Constants.CLICK_ANIMATION_SCALE)
                .scaleY(Constants.CLICK_ANIMATION_SCALE)
                .setDuration(Constants.CLICK_ANIMATION_DURATION)
                .withEndAction(() ->
                        binding.buttonCoin.animate()
                                .scaleX(Constants.DEFAULT_ANIMATION_SCALE)
                                .scaleY(Constants.DEFAULT_ANIMATION_SCALE)
                                .setDuration(Constants.CLICK_ANIMATION_DURATION)
                );
    }

    /**
     * Initializes bottom navigation.
     */
    private void setupBottomNavigation() {

        binding.bottomNavigation.setOnItemSelectedListener(item -> {

            int id = item.getItemId();

            if (id == R.id.navigation_shop) {

                Intent intent = new Intent(this, ShopActivity.class);

                startActivity(intent);

                return true;
            }

            if (id == R.id.navigation_statistics) {

                Intent intent = new Intent(this, StatisticsActivity.class);

                startActivity(intent);

                return true;
            }

            if (id == R.id.navigation_settings) {

                Intent intent = new Intent(this, SettingsActivity.class);

                startActivity(intent);

                return true;
            }

            return false;
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        startPassiveIncome();
    }

    @Override
    protected void onPause() {
        super.onPause();
        handler.removeCallbacks(passiveIncomeRunnable);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        handler.removeCallbacks(passiveIncomeRunnable);
    }
}