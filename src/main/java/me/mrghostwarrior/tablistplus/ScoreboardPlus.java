package me.mrghostwarrior.tablistplus;

import me.mrghostwarrior.tablistplus.command.ReloadConmmand;
import me.mrghostwarrior.tablistplus.intance.PluginInstace;
import me.mrghostwarrior.tablistplus.listener.ConnectListener;
import me.mrghostwarrior.tablistplus.manager.ConfigManager;
import me.mrghostwarrior.tablistplus.manager.LangManager;
import me.mrghostwarrior.tablistplus.manager.ScoreboradManager;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public final class ScoreboardPlus extends JavaPlugin {

    private ScoreboradManager scoreboradManager;

    @Override
    public void onEnable() {

        ConfigManager.setupConfig(this);
        LangManager.setupLangFile(this);

        Bukkit.getPluginManager().registerEvents(new ConnectListener(this), this);

        scoreboradManager = new ScoreboradManager(this);
        getScoreboradManager().addtohashmap();



        getCommand("spreload").setExecutor(new ReloadConmmand(this));

        Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', "&f&l----------------------------------------"));
        Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', " &f&l&c&lThanks for using &b&lScoreboard&f&lPlus"));
        Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', "&f&l----------------------------------------"));

        //Bukkit Runnable
        getScoreboradManager().updateTabListName();
        if (!LangManager.getAminatedSideBarBoolean()){
            getScoreboradManager().updatesidebar();
        }else {
            getScoreboradManager().animatedSidebar();
        }
        if (LangManager.getAnimatedHeaderAndFooter()){
            getScoreboradManager().animatedheaterandfooter();
        }else {
            if (LangManager.getUpdateFooterAndHeader()){
                getScoreboradManager().updatetablistfooterandheater();
            }
        }
        if (LangManager.getAminatedSideBarTitleBoolean()){
            getScoreboradManager().startanimationtitle();
        }


    }



    @Override
    public void onDisable() {
    }

    public ScoreboradManager getScoreboradManager() { return  scoreboradManager; }
}
