package me.fastcrafter.llibrary.bukkit.inventory;

import org.bukkit.Bukkit;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class InventoryBuilder {

    private int size;
    private String title;
    private Inventory inventory;

    public InventoryBuilder(int rows, String title) {
        this.size = rows * 9;
        this.title = title;
        this.inventory = Bukkit.createInventory(null, size, title);
    }

    public InventoryBuilder setItem(int slot, ItemStack is) {
        if (size >= slot) {
            inventory.setItem(slot, is);
        }
        return this;
    }

    public Inventory build() {
        return inventory;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }
}
