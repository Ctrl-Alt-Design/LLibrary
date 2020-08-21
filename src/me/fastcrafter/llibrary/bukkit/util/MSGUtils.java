package me.fastcrafter.llibrary.bukkit.util;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class MSGUtils {

    private String prefix;

    public MSGUtils(String prefix) {
        this.prefix = prefix;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public void sendConsoleMessage(String msg) {
        updateColor();
        Bukkit.getConsoleSender().sendMessage(prefix + ChatColor.translateAlternateColorCodes('&', msg));
    }

    public void sendPlayerMessage(Player p, String msg) {
        updateColor();
        p.sendMessage(prefix + ChatColor.translateAlternateColorCodes('&', msg));
    }

    public void broadcastMessage(String msg) {
        updateColor();
        Bukkit.getConsoleSender().sendMessage(prefix + ChatColor.translateAlternateColorCodes('&', msg));
        Bukkit.getOnlinePlayers().forEach(p -> p.sendMessage(prefix + ChatColor.translateAlternateColorCodes('&', msg)));
    }

    public void sendPlayerMessage(Player[] players, String msg) {
        updateColor();
        Bukkit.getConsoleSender().sendMessage(prefix + ChatColor.translateAlternateColorCodes('&', msg));
        for (Player p : players) {
            p.sendMessage(prefix + ChatColor.translateAlternateColorCodes('&', msg));
        }
    }

    public static void sendError(String pluginName, String msg) {
        Bukkit.getConsoleSender().sendMessage("&c" + ChatColor.stripColor("[ERROR] | " + pluginName + " >>> " + msg));
    }

    private void updateColor() {
        this.prefix = ChatColor.translateAlternateColorCodes('&', this.prefix);
    }
}
