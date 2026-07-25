package com.vs18.clickempire.view.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.vs18.clickempire.databinding.ActivitySplashBinding;
import com.vs18.clickempire.manager.GameManager;
import com.vs18.clickempire.util.ActivityAnimation;

@SuppressLint("CustomSplashScreen")
public class SplashActivity extends AppCompatActivity {

    private ActivitySplashBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivitySplashBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        GameManager.initialize(this);
        GameManager.loadGame();

        openMainScreen();
    }

    private void openMainScreen() {

        binding.getRoot().postDelayed(() -> {
            startActivity(new Intent(this, MainActivity.class));
            ActivityAnimation.open(this);

            finish();
            ActivityAnimation.close(this);
        }, 1000);
    }
}
