package me.fastcrafter.llibrary.bukkit.command;

import me.fastcrafter.llibrary.bukkit.util.MSGUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public abstract class AbstractCMD implements CommandExecutor {

    public MSGUtils msg;

    public AbstractCMD(JavaPlugin plugin, MSGUtils msg, String command) {
        this.msg = msg;
        plugin.getCommand(command).setExecutor(this);
    }

    @Override
    public abstract boolean onCommand(CommandSender sender, Command cmd, String label, String[] args);

    public abstract void showHelp(Player p);
}
