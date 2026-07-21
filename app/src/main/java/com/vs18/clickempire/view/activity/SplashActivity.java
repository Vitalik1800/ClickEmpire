package com.vs18.clickempire.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.vs18.clickempire.databinding.ActivitySplashBinding;
import com.vs18.clickempire.manager.GameManager;
import com.vs18.clickempire.util.Constants;

public class SplashActivity extends AppCompatActivity {

    private ActivitySplashBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivitySplashBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        GameManager.initializeSaveManager(this);
        GameManager.loadGame();

        Log.d(Constants.TAG,
                "Splash player = "
                        + GameManager.getPlayer().getCoins()
                        + " hash="
                        + System.identityHashCode(GameManager.getPlayer()));

        openMainScreen();
    }

    private void openMainScreen() {

        binding.getRoot().postDelayed(() -> {
            startActivity(new Intent(this, MainActivity.class));
            finish();
        }, 1000);
    }
}
