package me.fastcrafter.llibrary.bukkit.config;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class Config {
    private  File file;
    private String filename;
    private  FileConfiguration config;

    public Config(String filename, boolean setup) {
        this.filename = filename;
        if (setup)
            setup();
    }

    public  void setup() {
        file = new File(Bukkit.getServer().getPluginManager().getPlugin(filename).getDataFolder(), "customconfig.yml");

        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException ignored) {
            }
        }
        config = YamlConfiguration.loadConfiguration(file);
    }

    public FileConfiguration getConfig() {
        return config;
    }

    public  void save() {
        try {
            config.save(file);
        } catch (IOException e) {
            System.out.println("Couldn't save file");
        }
    }

    public  void reload() {
        config = YamlConfiguration.loadConfiguration(file);
    }
}
