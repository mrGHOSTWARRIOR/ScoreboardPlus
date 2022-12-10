package me.mrghostwarrior.tablistplus.listener;

import me.mrghostwarrior.tablistplus.ScoreboardPlus;
import me.mrghostwarrior.tablistplus.manager.ConfigManager;;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class ConnectListener implements Listener {
    private final ScoreboardPlus scoreboardplus;

    public ConnectListener(ScoreboardPlus scoreboardplus){
        this.scoreboardplus = scoreboardplus;
    }

    @EventHandler
    public void onJoinEvent(PlayerJoinEvent e){
        Player p = e.getPlayer();
        if (ConfigManager.getTabListBoolean()){
            scoreboardplus.getScoreboradManager().createTabList(p);
            scoreboardplus.getScoreboradManager().addToTeam(p);

        }
        if (ConfigManager.getSideBarBoolean()){
            scoreboardplus.getScoreboradManager().mainScoreBoard(p);
        }
        if (ConfigManager.getTabListFooterBoolean()){
            scoreboardplus.getScoreboradManager().setFooter(p);
        }
        if (ConfigManager.getTabListHeaderBoolean()){
            scoreboardplus.getScoreboradManager().setHeader(p);
        }
    }
    @EventHandler
    public void onQuitEvent(PlayerQuitEvent e){
        Player p = e.getPlayer();
        scoreboardplus.getScoreboradManager().removeTeam(p);
    }
}
