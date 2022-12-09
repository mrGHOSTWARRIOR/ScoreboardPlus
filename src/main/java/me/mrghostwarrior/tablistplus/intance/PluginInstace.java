package me.mrghostwarrior.tablistplus.intance;

import org.bukkit.Bukkit;

public class PluginInstace {

    public static boolean checkPlaceholderAPI(){
        return Bukkit.getServer().getPluginManager().getPlugin("PlaceholderAPI") != null;
    }

    public static boolean checkLuckPermsAPI(){
        return Bukkit.getServer().getPluginManager().getPlugin("LuckPerms") != null;
    }

}
