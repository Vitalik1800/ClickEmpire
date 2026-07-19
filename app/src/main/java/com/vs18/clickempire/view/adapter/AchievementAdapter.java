package com.vs18.clickempire.view.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.vs18.clickempire.R;
import com.vs18.clickempire.databinding.ItemAchievementBinding;
import com.vs18.clickempire.model.Achievement;
import com.vs18.clickempire.view.holder.AchievementViewHolder;

import java.util.List;

/**
 * Adapter for achievement list.
 */
public class AchievementAdapter
    extends RecyclerView.Adapter<AchievementViewHolder> {

    private final List<Achievement> achievements;

    /**
     * Creates a new achievement adapter.
     *
     * @param achievements achievement list
     */
    public AchievementAdapter(@NonNull List<Achievement> achievements) {
        this.achievements = achievements;
    }

    @NonNull
    @Override
    public AchievementViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        ItemAchievementBinding binding =
                ItemAchievementBinding.inflate(
                        LayoutInflater.from(parent.getContext()),
                        parent,
                        false
                );

        return new AchievementViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull AchievementViewHolder holder, int position) {
        bindAchievement(holder, achievements.get(position));
    }

    @Override
    public int getItemCount() {
        return achievements.size();
    }

    private void bindAchievement(
            @NonNull AchievementViewHolder holder,
            @NonNull Achievement achievement
    ) {

        if (achievement.isUnlocked()) {

            holder.binding.imageAchievement.setImageResource(
                    R.drawable.ic_achievement
            );

            holder.binding.textTitle.setText(
                    achievement.getTitleResId()
            );

            holder.binding.textDescription.setText(
                    achievement.getDescriptionResId()
            );

            holder.binding.textStatus.setText(
                    R.string.unlocked
            );

        } else {

            holder.binding.imageAchievement.setImageResource(
                    R.drawable.ic_lock
            );

            holder.binding.textTitle.setText(
                    R.string.achievement_hidden
            );

            holder.binding.textDescription.setText(
                    R.string.achievement_hidden
            );

            holder.binding.textStatus.setText(
                    R.string.locked
            );
        }

    }
}
