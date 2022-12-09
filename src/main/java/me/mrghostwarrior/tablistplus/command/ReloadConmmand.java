package me.mrghostwarrior.tablistplus.command;


import me.mrghostwarrior.tablistplus.ScoreboardPlus;
import me.mrghostwarrior.tablistplus.manager.LangManager;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import sun.jvm.hotspot.runtime.ThreadLocalAllocBuffer;

public class ReloadConmmand implements CommandExecutor {

    private ScoreboardPlus scoreboardPlus;

    public ReloadConmmand(ScoreboardPlus scoreboardPlus){
        this.scoreboardPlus = scoreboardPlus;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        if (sender instanceof Player){
            Player p = (Player) sender;
            if (!p.isOp()){
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c&lYou don't have permission to use this command"));
                return false;
            }
            p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c&l-----------------------------------------------"));
            p.sendMessage(ChatColor.translateAlternateColorCodes('&', "    &2&lReloading &b&lScoreboard&f&lPlus"));
            p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c&l-----------------------------------------------"));
        }
        Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', "&f&l----------------------------------------"));
        Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', "    &2&lReloading &b&lScoreboard&f&lPlus"));
        Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', "&f&l----------------------------------------"));
        scoreboardPlus.reloadConfig();
        LangManager.reloadFile(scoreboardPlus);
        Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', "&f&l----------------------------------------"));
        Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', "    &b&lScoreboard&f&lPlus &2&lReloaded"));
        Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', "&f&l----------------------------------------"));
        if (sender instanceof Player){
            Player p = (Player) sender;
            p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c&l-----------------------------------------------"));
            p.sendMessage(ChatColor.translateAlternateColorCodes('&', "     &b&lScoreboard&f&lPlus &2&lReloaded"));
            p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c&l-----------------------------------------------"));
        }
        return false;
    }
}
