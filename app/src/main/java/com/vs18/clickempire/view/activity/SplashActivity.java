package com.vs18.clickempire.view.activity;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.vs18.clickempire.databinding.ActivitySplashBinding;
import com.vs18.clickempire.manager.GameManager;

public class SplashActivity extends AppCompatActivity {

    private ActivitySplashBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivitySplashBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        GameManager.initializeSaveManager(this);
        GameManager.loadGame();

        openMainScreen();
    }

    private void openMainScreen() {

        startActivity(
                new Intent(this, MainActivity.class)
        );

        finish();
    }
}
