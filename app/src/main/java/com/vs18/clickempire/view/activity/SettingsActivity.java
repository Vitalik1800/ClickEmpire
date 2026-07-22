package com.vs18.clickempire.view.activity;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.vs18.clickempire.BuildConfig;
import com.vs18.clickempire.R;
import com.vs18.clickempire.databinding.ActivitySettingsBinding;
import com.vs18.clickempire.manager.GameManager;
import com.vs18.clickempire.manager.SettingsManager;
import com.vs18.clickempire.util.UiUtils;

public class SettingsActivity extends AppCompatActivity {

    private ActivitySettingsBinding binding;

    private SettingsManager settingsManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivitySettingsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        settingsManager = new SettingsManager(this);

        binding.textVersion.setText(
                getString(
                        R.string.version_format,
                        BuildConfig.VERSION_NAME
                )
        );

        binding.switchSound.setChecked(
                settingsManager.isSoundEnabled()
        );

        binding.switchSound.setOnCheckedChangeListener(
                (buttonView, isChecked) ->
                        settingsManager.setSoundEnabled(isChecked)
        );

        binding.switchVibration.setChecked(
                settingsManager.isVibrationEnabled()
        );

        binding.switchVibration.setOnCheckedChangeListener(
                (buttonView, isChecked) ->
                        settingsManager.setVibrationEnabled(isChecked)
        );

        binding.buttonResetProgress.setOnClickListener(v -> {
            UiUtils.showResetDialog(this, () -> {

                GameManager.resetGame();

                Intent intent = new Intent(this, SplashActivity.class);
                intent.addFlags(
                        Intent.FLAG_ACTIVITY_NEW_TASK
                                | Intent.FLAG_ACTIVITY_CLEAR_TASK
                );

                startActivity(intent);

                finish();
            });
        });
    }
}