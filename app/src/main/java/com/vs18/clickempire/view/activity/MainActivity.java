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
import com.vs18.clickempire.manager.SaveManager;
import com.vs18.clickempire.model.GameActionResult;
import com.vs18.clickempire.model.Player;
import com.vs18.clickempire.model.Statistics;
import com.vs18.clickempire.util.ActivityAnimation;
import com.vs18.clickempire.util.AnimationUtilsEx;
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

            statisticsController.addPlayTime(1);

            updateUi();

            UiUtils.showAchievement(binding.getRoot(), result);

            handler.postDelayed(this, Constants.PASSIVE_INCOME_INTERVAL);
        }
    };

    private final Runnable autoSaveRunnable = new Runnable() {
        @Override
        public void run() {
            GameManager.saveGame();
            handler.postDelayed(this, Constants.SAVE_INTERVAL);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.d(Constants.TAG,
                "Main onCreate player = "
                        + GameManager.getPlayer().getCoins()
                        + " hash="
                        + System.identityHashCode(GameManager.getPlayer()));

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.bottomNavigation.setSelectedItemId(R.id.navigation_home);

        initializeModels();
        initializeControllers();

        long offlineSeconds = GameManager.getOfflineSeconds();
        long offlineCoins = GameManager.applyOfflineIncome();

        initializeViews();
        setupListeners();
        setupBottomNavigation();

        updateUi();

        Log.d(Constants.TAG,
                "Dialog: seconds=" + offlineSeconds
                        + ", coins=" + offlineCoins);

        UiUtils.showOfflineIncome(
                MainActivity.this,
                offlineSeconds,
                offlineCoins
        );
    }

    /**
     * Initializes game models.
     */
    private void initializeModels() {
        player = GameManager.getPlayer();

        Log.d(Constants.TAG,
                "initializeModels player = "
                        + player.getCoins()
                        + " hash="
                        + System.identityHashCode(player));

        statistics = GameManager.getStatistics();

        Log.d(Constants.TAG,
                "Player hash = " + System.identityHashCode(player));
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

        binding.cardCoin.setOnClickListener(view -> {

            AnimationUtilsEx.animateButton(view);

            playClickAnimation();

            GameManager.getSoundManager().play(
                    GameManager.getSoundManager().getClickSound()
            );

            GameManager.getVibrationManager().vibrate();

            GameActionResult result = mainController.click();

            updateUi();

            UiUtils.showAchievement(binding.getRoot(), result);

            if (result.isLevelUp()) {
                handler.postDelayed(() ->
                                GameManager.getSoundManager().play(
                                        GameManager.getSoundManager().getLevelUpSound()
                                ),
                        600
                );
            }
        });

    }

    /**
     * Updates all game information.
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

        binding.textClickPower.setText(
                getString(
                        R.string.click_power_format,
                        NumberFormatter.format(player.getClickPower())
                )
        );

        binding.textLevel.setText(
                getString(
                        R.string.level_format,
                        player.getLevel()
                )
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
                ActivityAnimation.open(this);

                return true;
            }

            if (id == R.id.navigation_statistics) {

                Intent intent = new Intent(this, StatisticsActivity.class);

                startActivity(intent);
                ActivityAnimation.open(this);

                return true;
            }

            if (id == R.id.navigation_achievements) {

                Intent intent = new Intent(this, AchievementActivity.class);

                startActivity(intent);
                ActivityAnimation.open(this);

                return true;
            }

            if (id == R.id.navigation_settings) {

                Intent intent = new Intent(this, SettingsActivity.class);

                startActivity(intent);
                ActivityAnimation.open(this);

                return true;
            }

            return false;
        });
    }

    @Override
    protected void onResume() {
        super.onResume();

        Log.d(Constants.TAG,
                "onResume coins="
                        + player.getCoins()
                        + " hash="
                        + System.identityHashCode(player));

        handler.removeCallbacks(autoSaveRunnable);
        handler.postDelayed(autoSaveRunnable, Constants.SAVE_INTERVAL);

        handler.removeCallbacks(passiveIncomeRunnable);
        startPassiveIncome();
    }

    @Override
    protected void onPause() {
        super.onPause();
        handler.removeCallbacks(passiveIncomeRunnable);
        handler.removeCallbacks(autoSaveRunnable);

        GameManager.saveGame();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        handler.removeCallbacks(passiveIncomeRunnable);
        handler.removeCallbacks(autoSaveRunnable);
    }
}