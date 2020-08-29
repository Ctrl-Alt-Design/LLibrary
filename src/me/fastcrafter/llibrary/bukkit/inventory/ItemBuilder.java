package me.fastcrafter.llibrary.bukkit.inventory;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Objects;

public class ItemBuilder {
    private ItemStack is;

    public ItemBuilder(Material m) {
        this.is = new ItemStack(m);
    }

    public ItemBuilder setName(String name) {
        ItemMeta im = is.getItemMeta();
        Objects.requireNonNull(im).setDisplayName(ChatColor.translateAlternateColorCodes('&', name));
        is.setItemMeta(im);
        return this;
    }

    public ItemBuilder setAmount(int amount) {
        if (amount >= 1 && amount <= 64)
            is.setAmount(amount);
        return this;
    }

    public ItemStack build() {
        return is;
    }
}
