package com.vs18.clickempire.view.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.vs18.clickempire.R;
import com.vs18.clickempire.databinding.ItemUpgradeBinding;
import com.vs18.clickempire.model.Player;
import com.vs18.clickempire.model.Upgrade;
import com.vs18.clickempire.util.AnimationUtilsEx;
import com.vs18.clickempire.util.Constants;
import com.vs18.clickempire.view.holder.UpgradeViewHolder;

import java.util.List;

public class UpgradeAdapter extends RecyclerView.Adapter<UpgradeViewHolder> {

    public interface OnBuyClickListener {
        void onBuyClick(Upgrade upgrade);
    }

    private final Player player;
    private final List<Upgrade> upgrades;
    private final OnBuyClickListener listener;

    public UpgradeAdapter(
            Player player,
            List<Upgrade> upgrades,
            OnBuyClickListener listener
    ) {
        this.player = player;
        this.upgrades = upgrades;
        this.listener = listener;
    }

    @NonNull
    @Override
    public UpgradeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        ItemUpgradeBinding binding =
                ItemUpgradeBinding.inflate(
                        LayoutInflater.from(parent.getContext()),
                        parent,
                        false
                );

        return new UpgradeViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull UpgradeViewHolder holder, int position) {

        Upgrade upgrade = upgrades.get(position);

        holder.binding.imageUpgrade.setImageResource(upgrade.getIcon());

        holder.binding.textUpgradeName.setText(upgrade.getNameResId());

        holder.binding.textUpgradeDescription.setText(
                upgrade.getDescriptionResId()
        );

        holder.binding.textUpgradeLevel.setText(
                holder.itemView.getContext().getString(
                        R.string.default_upgrade_level,
                        upgrade.getLevel()
                )
        );

        holder.binding.textUpgradeIncome.setText(
                holder.itemView.getContext().getString(
                        R.string.default_upgrade_income,
                        upgrade.getIncome()
                )
        );

        holder.binding.textPrice.setText(
                holder.itemView.getContext().getString(
                        R.string.default_upgrade_price,
                        upgrade.getPrice()
                )
        );

        boolean canBuy = player.canBuy(upgrade.getPrice());

        holder.binding.buttonBuy.setEnabled(canBuy);
        holder.binding.buttonBuy.setAlpha(canBuy ? Constants.BUTTON_ENABLED_ALPHA : Constants.BUTTON_DISABLED_ALPHA);

        holder.binding.buttonBuy.setOnClickListener(v -> {

            AnimationUtilsEx.animateButton(v);

            listener.onBuyClick(upgrade);

            notifyDataSetChanged();

        });
    }

    @Override
    public int getItemCount() {
        return upgrades.size();
    }
}
