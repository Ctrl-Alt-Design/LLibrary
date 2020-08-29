package me.fastcrafter.llibrary.bukkit.inventory;

import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class InventoryUtils {
    public static void removeItems(Inventory inventory, Material type, int amount) {
        if (amount <= 0) return;
        int size = inventory.getSize();
        for (int slot = 0; slot < size; slot++) {
            ItemStack is = (ItemStack) inventory.getItem(slot);
            if (is == null)
                continue;
            if (type == is.getType()) {
                int newAmount = is.getAmount() - amount;
                if (newAmount > 0) {
                    is.setAmount(newAmount);
                    break;
                } else {
                    inventory.clear(slot);
                    amount = -newAmount;
                    if (amount == 0) break;
                }
            }
        }
    }

    public static void removeItems(Inventory inventory, ItemStack item, int amount) {
        if (amount <= 0) return;
        int size = inventory.getSize();
        for (int slot = 0; slot < size; slot++) {
            ItemStack is = inventory.getItem(slot);
            if (is == null)
                continue;
            if (item.equals(is)) {
                int newAmount = is.getAmount() - amount;
                if (newAmount > 0) {
                    is.setAmount(newAmount);
                    break;
                } else {
                    inventory.clear(slot);
                    amount = -newAmount;
                    if (amount == 0) break;
                }
            }
        }
    }

    public static int getTotalItemAmount(Inventory inv, ItemStack is) {
        int amount = 0;
        for (int i = 0; i < inv.getSize(); i++) {
            ItemStack item = inv.getItem(i);
            if (item != null) {
                System.out.println(1);
                if (item.getType().equals(is.getType())) {
                    System.out.println(2);
                    if (item.getItemMeta().getDisplayName().equals(is.getItemMeta().getDisplayName())) {
                        System.out.println(3);
                        amount++;
                    }
                }
            }
        }
        return amount;
    }
}
