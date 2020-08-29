package me.fastcrafter.llibrary.bukkit.util;

import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class MSGUtils {

    private String prefix;

    public MSGUtils(String prefix) {
        this.prefix = prefix;
    }

    public static void sendError(String pluginName, String msg) {
        Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', "&c" + ChatColor.stripColor("[ERROR] | " + pluginName + " >>> " + msg)));
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

    public void sendActionBar(Player p, String text) {
        updateColor();
        p.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(ChatColor.translateAlternateColorCodes('&', text)));
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

    private void updateColor() {
        this.prefix = ChatColor.translateAlternateColorCodes('&', this.prefix);
    }
}
