package me.fastcrafter.llibrary.bukkit.config;

import me.fastcrafter.llibrary.bukkit.util.MSGUtils;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;

public class Config {
    private File file;
    private final String filename;
    private final File folder;
    private FileConfiguration config;
    private final MSGUtils msgInstance;
    private final JavaPlugin plugin;

    public Config(JavaPlugin plugin, MSGUtils msgInstance, String filename, boolean setup, boolean copyDefaults) {
        this.msgInstance = msgInstance;
        this.plugin = plugin;
        this.filename = filename;
        this.folder = plugin.getDataFolder();
        if (setup)
            setup();
        if (copyDefaults)
            copyDefaults();
    }

    public Config(JavaPlugin plugin, MSGUtils msgInstance, String filename, boolean setup, boolean copyDefaults, String defaultLocation) {
        this.msgInstance = msgInstance;
        this.plugin = plugin;
        this.filename = filename;
        this.folder = plugin.getDataFolder();
        if (setup)
            setup();
        if (copyDefaults)
            copyDefaults(defaultLocation);

    }

    public Config(JavaPlugin plugin, MSGUtils msgInstance, String path, String filename, boolean setup, boolean copyDefaults) {
        this.msgInstance = msgInstance;
        this.plugin = plugin;
        this.filename = filename;
        this.folder = new File(plugin.getDataFolder().getAbsolutePath() + "/" + path);
        if (setup)
            setup();
        if (copyDefaults)
            copyDefaults();
    }

    public Config(JavaPlugin plugin, MSGUtils msgInstance, String path, String filename, boolean setup, boolean copyDefaults, String defaultLocation) {
        this.msgInstance = msgInstance;
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
                msgInstance.sendConsoleMessage("&cCouldn't create " + filename + "! Skipping config file!");
            }
        }
        config = YamlConfiguration.loadConfiguration(file);
    }

    // TODO: 21.08.2020 copy defaults not working right now! 

    public void copyDefaults() {
        Reader defConfigStream = new InputStreamReader(plugin.getResource(filename), StandardCharsets.UTF_8);
        YamlConfiguration defConfig = YamlConfiguration.loadConfiguration(defConfigStream);
        config.setDefaults(defConfig);
        config.options().copyDefaults(true);
    }

    public void copyDefaults(String location) {
        Reader defConfigStream = new InputStreamReader(plugin.getResource(location), StandardCharsets.UTF_8);
        YamlConfiguration defConfig = YamlConfiguration.loadConfiguration(defConfigStream);
        config.setDefaults(defConfig);
        config.options().copyDefaults(true);
    }

    public void copyDefaults(boolean b) {
        Reader defConfigStream = new InputStreamReader(plugin.getResource(filename), StandardCharsets.UTF_8);
        YamlConfiguration defConfig = YamlConfiguration.loadConfiguration(defConfigStream);
        config.setDefaults(defConfig);
        config.options().copyDefaults(b);
    }

    public void copyDefaults(String location, boolean b) {
        System.out.println(location);
        Reader defConfigStream = new InputStreamReader(plugin.getResource(location), StandardCharsets.UTF_8);
        YamlConfiguration defConfig = YamlConfiguration.loadConfiguration(defConfigStream);
        config.setDefaults(defConfig);
        config.options().copyDefaults(b);
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
