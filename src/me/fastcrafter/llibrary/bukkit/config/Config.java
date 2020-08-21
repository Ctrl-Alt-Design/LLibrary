package me.fastcrafter.llibrary.bukkit.config;

import me.fastcrafter.llibrary.bukkit.util.MSGUtils;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Config {

    private File file;
    private final String filename;
    private final File folder;
    private FileConfiguration config;
    private final JavaPlugin plugin;

    public Config(JavaPlugin plugin, String filename, boolean setup, boolean copyDefaults) {
        this.plugin = plugin;
        this.filename = filename;
        this.folder = plugin.getDataFolder();
        if (setup)
            setup();
        if (copyDefaults)
            copyDefaults();
    }

    public Config(JavaPlugin plugin, String filename, boolean setup, boolean copyDefaults, String defaultLocation) {
        this.plugin = plugin;
        this.filename = filename;
        this.folder = plugin.getDataFolder();
        if (setup)
            setup();
        if (copyDefaults)
            copyDefaults(defaultLocation);

    }

    public Config(JavaPlugin plugin, String path, String filename, boolean setup, boolean copyDefaults) {
        this.plugin = plugin;
        this.filename = filename;
        this.folder = new File(plugin.getDataFolder().getAbsolutePath() + "/" + path);
        if (setup)
            setup();
        if (copyDefaults)
            copyDefaults();
    }

    public Config(JavaPlugin plugin, String path, String filename, boolean setup, boolean copyDefaults, String defaultLocation) {
        this.plugin = plugin;
        this.filename = filename;
        this.folder = new File(plugin.getDataFolder().getAbsolutePath() + "/" + path);
        if (setup)
            setup();
        if (copyDefaults)
            copyDefaults(defaultLocation);

    }

    public void setup() {
        file = new File(folder, filename);

        if (!folder.exists())
            folder.mkdirs();

        if (!file.exists()) {
            try {
                //noinspection ResultOfMethodCallIgnored
                file.createNewFile();
            } catch (IOException ignored) {
                MSGUtils.sendError("Bedwars", "Could not create Config file: " + filename + "! Skipping file! Are the File-Permissions set correctly for this folder?");
            }
        }
        config = YamlConfiguration.loadConfiguration(file);
    }

    public void copyDefaults() {
        InputStream defaultConfigStream = plugin.getResource(filename);
        YamlConfiguration defaultConfig = YamlConfiguration.loadConfiguration(new InputStreamReader(defaultConfigStream));
        config.setDefaults(defaultConfig);
        config.options().copyDefaults(true);
        save();
    }

    public void copyDefaults(String location) {
        InputStream defaultConfigStream = plugin.getResource(location);
        YamlConfiguration defaultConfig = YamlConfiguration.loadConfiguration(new InputStreamReader(defaultConfigStream));
        config.setDefaults(defaultConfig);
        config.options().copyDefaults(true);
        save();
    }

    public void copyDefaults(boolean b) {
        InputStream defaultConfigStream = plugin.getResource(filename);
        YamlConfiguration defaultConfig = YamlConfiguration.loadConfiguration(new InputStreamReader(defaultConfigStream));
        config.setDefaults(defaultConfig);
        config.options().copyDefaults(b);
        save();
    }

    public void copyDefaults(String location, boolean b) {
        InputStream defaultConfigStream = plugin.getResource(location);
        YamlConfiguration defaultConfig = YamlConfiguration.loadConfiguration(new InputStreamReader(defaultConfigStream));
        config.setDefaults(defaultConfig);
        config.options().copyDefaults(b);
        save();
    }

    public FileConfiguration getConfig() {
        return config;
    }

    public void save() {
        try {
            config.save(file);
        } catch (IOException e) {
            System.out.println("Couldn't save file");
        }
    }

    public void reload() {
        config = YamlConfiguration.loadConfiguration(file);
    }
}
