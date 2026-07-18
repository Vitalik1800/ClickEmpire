package com.vs18.clickempire.view.holder;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.vs18.clickempire.databinding.ItemUpgradeBinding;

public class UpgradeViewHolder extends RecyclerView.ViewHolder {

    public final ItemUpgradeBinding binding;

    public UpgradeViewHolder(@NonNull ItemUpgradeBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

}
