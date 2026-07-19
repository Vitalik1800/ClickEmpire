package com.vs18.clickempire.view.holder;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.vs18.clickempire.databinding.ItemAchievementBinding;

public class AchievementViewHolder extends RecyclerView.ViewHolder {

    public final ItemAchievementBinding binding;

    public AchievementViewHolder(@NonNull ItemAchievementBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

}
