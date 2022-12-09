package me.mrghostwarrior.tablistplus.manager;

import me.mrghostwarrior.tablistplus.ScoreboardPlus;
import org.bukkit.configuration.file.FileConfiguration;

public class ConfigManager {

    private static FileConfiguration config;

    public static void setupConfig(ScoreboardPlus scoreboardPlus){
        ConfigManager.config = scoreboardPlus.getConfig();
        scoreboardPlus.saveDefaultConfig();

    }

    public static boolean getTabListBoolean() { return config.getBoolean("tab-list"); }
    public static boolean getSideBarBoolean() { return config.getBoolean("side-bar"); }
    public static boolean getTabListHeaderBoolean() { return config.getBoolean("tab-list-header"); }
    public static boolean getTabListFooterBoolean() { return config.getBoolean("tab-list-footer"); }

}
