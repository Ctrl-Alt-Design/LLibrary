package me.fastcrafter.llibrary.bukkit.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public abstract class AbstractCMD implements CommandExecutor {
    public AbstractCMD(JavaPlugin plugin, String command) {
        plugin.getCommand(command).setExecutor(this);
    }

    @Override
    public abstract boolean onCommand(CommandSender sender, Command cmd, String label, String[] args);
}
