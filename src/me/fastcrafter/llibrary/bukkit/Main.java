package me.fastcrafter.llibrary.bukkit;

import me.fastcrafter.llibrary.bukkit.util.MSGUtils;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

   private static MSGUtils utils;

    @Override
    public void onEnable() {
        utils = new MSGUtils("&b[&eLLibrary&b] &a");
        utils.sendConsoleMessage("was added to classpath successfully!");
    }

    public static MSGUtils getUtils() {
        return utils;
    }

    public static void setUtils(MSGUtils utils) {
        Main.utils = utils;
    }
}
