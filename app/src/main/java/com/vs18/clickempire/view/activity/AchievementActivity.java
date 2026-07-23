package com.vs18.clickempire.view.activity;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.vs18.clickempire.databinding.ActivityAchievementBinding;
import com.vs18.clickempire.manager.GameManager;
import com.vs18.clickempire.view.adapter.AchievementAdapter;

/**
 * Displays all achievements.
 */
public class AchievementActivity extends AppCompatActivity {

    private ActivityAchievementBinding binding;

    private AchievementAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityAchievementBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        initializeRecyclerView();
    }

    /**
     * Initializes RecyclerView.
     */
    private void initializeRecyclerView() {

        adapter = new AchievementAdapter(
                this,
                GameManager.getAchievements()
        );

        binding.recyclerViewAchievements.setLayoutManager(
                new LinearLayoutManager(this)
        );

        binding.recyclerViewAchievements.setAdapter(adapter);
    }
}