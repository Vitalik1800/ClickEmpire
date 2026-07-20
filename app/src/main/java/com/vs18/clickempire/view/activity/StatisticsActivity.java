package com.vs18.clickempire.view.activity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;

import androidx.appcompat.app.AppCompatActivity;

import com.vs18.clickempire.controller.StatisticsController;
import com.vs18.clickempire.databinding.ActivityStatisticsBinding;
import com.vs18.clickempire.manager.GameManager;
import com.vs18.clickempire.model.Player;
import com.vs18.clickempire.model.Statistics;
import com.vs18.clickempire.util.Constants;
import com.vs18.clickempire.util.NumberFormatter;
import com.vs18.clickempire.util.TimeFormatter;

/**
 * Displays player statistics.
 */
public class StatisticsActivity extends AppCompatActivity {

    private ActivityStatisticsBinding binding;

    private Player player;
    private Statistics statistics;

    private StatisticsController statisticsController;

    private final Handler handler = new Handler(Looper.getMainLooper());

    private final Runnable statisticsRunnable = new Runnable() {
        @Override
        public void run() {

            updateUi();

            handler.postDelayed(this, Constants.PASSIVE_INCOME_INTERVAL);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityStatisticsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        initializeModels();
        initializeControllers();

        updateUi();
    }

    /**
     * Initializes models.
     */
    private void initializeModels() {
        player = GameManager.getPlayer();
        statistics = GameManager.getStatistics();
    }

    /**
     * Initializes controllers.
     */
    private void initializeControllers() {
        statisticsController = new StatisticsController(statistics);
    }

    /**
     * Updates statistics UI.
     */
    private void updateUi() {

        binding.statisticsCard.textPlayTime.setText(
                TimeFormatter.format(
                        statisticsController.getPlayTime()
                )
        );

        binding.statisticsCard.textClicks.setText(
                NumberFormatter.format(
                        statisticsController.getClicks()
                )
        );

        binding.statisticsCard.textPurchases.setText(
                NumberFormatter.format(
                        statisticsController.getPurchases()
                )
        );

        binding.statisticsCard.textEarnedCoins.setText(
                NumberFormatter.format(
                        statisticsController.getEarnedCoins()
                )
        );

        binding.statisticsCard.textHighestBalance.setText(
                NumberFormatter.format(
                        statisticsController.getHighestBalance()
                )
        );

        binding.statisticsCard.textIncomePerSecond.setText(
                NumberFormatter.format(
                        player.getIncome()
                )
        );

    }

    @Override
    protected void onResume() {
        super.onResume();

        handler.post(statisticsRunnable);
    }

    @Override
    protected void onPause() {
        super.onPause();

        handler.removeCallbacks(statisticsRunnable);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        handler.removeCallbacks(statisticsRunnable);
    }
}