package me.mrghostwarrior.tablistplus.manager;

import me.mrghostwarrior.tablistplus.ScoreboardPlus;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;

public class LangManager {

    private static YamlConfiguration lang;

    public static void setupLangFile(ScoreboardPlus scoreboardPlus) {
        File file = new File(scoreboardPlus.getDataFolder(), "lang.yml");
        if (!file.exists()){
            scoreboardPlus.saveResource("lang.yml", false);
        }
        lang = YamlConfiguration.loadConfiguration(file);
    }

    public static void reloadFile(ScoreboardPlus scoreboardPlus) {
        File file = new File(scoreboardPlus.getDataFolder(), "lang.yml");
        if (!file.exists()){
            scoreboardPlus.saveResource("lang.yml", false);
        }
        lang = YamlConfiguration.loadConfiguration(file);
    }

    //tab list prefix and suffix

    public static boolean getUpdateTabListName(){ return lang.getBoolean("update-tablist-prefix-and-sufix");}
    public static String getTabListPrefix(){ return lang.getString("tab-list-prefix");}
    public static String getTabListSuffix(){ return lang.getString("tab-list-suffix");}
    public static String getTabListBelowName(){ return lang.getString("tab-list-belowname");}
    public static boolean getTabListBelownameBoolean() { return  lang.getBoolean("tab-list-belowname-boolean"); }
    public static String getTabListName() { return lang.getString("tab-list-name"); }
    public static boolean getCustomName() {return lang.getBoolean("custom-name"); }
    public static boolean getSortByLuckPermsGroupWeight() { return lang.getBoolean("sort-by-luckperms-group-weight"); }
    //sidebar
    public static Boolean getAminatedSideBarBoolean() { return lang.getBoolean("animated-sidebar");}
    public static Integer getSideBarLinesInt(){ return lang.getInt("sidebar-lines");}

    public static String getSidebarLine(Integer line) {
        if (line <= 0 || line >15){
            line = 1;
        }
        return lang.getString("sidebar-line-"+line);
    }
    public static Integer getAnimatedSideBarLinesInt(){
        int count = lang.getInt("animation-sidebar-lines");
        if (count <= 0 || count >10){
            count = 10;
        }
            return count;}
    public static String getAnimatedSidebarLine(Integer animation, Integer line) {
        if (line <= 0 || line >15){
            line = 1;
        }
        if (animation <= 0 || animation >10){
            animation = 1;
        }
        String finalline = lang.getString("animation-"+animation+"-sidebar-line-"+line);
        if (finalline == null){
            Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', "&4 &F[&BSCOREBOARD&FPLUS]&4 [ERROR]- &c"+
                    "animation-"+animation+"-sidebar-line-"+line
                    + " &4Its null! check that line"));
            finalline = "NULL";
        }
        return finalline;
    }

    public static Integer getSidebarAmintationTicksTitle(){ return lang.getInt("animation-sidebar-ticks-title");}


    public static Boolean getAminatedSideBarTitleBoolean() { return lang.getBoolean("animated-sidebar-title"); }
    public static String getSidebarTitle() { return lang.getString("sidebar-title"); }
    public static Integer getAnimatedbarLines() {return  lang.getInt("animation-bar-lines"); }
    public static Integer getAnimatedbarTicks() {return  lang.getInt("animated-bar-ticks"); }

    public static String getAnimatedSidebarTile(Integer line) {
        if (line <= 0 || line >100){
            line = 1;
        }
        String finalline = lang.getString("animated-bar-line-"+line);
        if (finalline == null){
            Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', "&4 &F[&BSCOREBOARD&FPLUS]&4 [ERROR]- &c"+
                    "animated-bar-line-"+line
                    + " &4Its null! check that line"));
            finalline = "NULL";
        }
        return finalline;
    }

    public static Integer getFooterLines() {return  lang.getInt("tab-footer-lines"); }
    public static String getFooterLine(Integer line) {
        if (line <= 0 || line >5){
            line = 1;
        }
        String finalline = lang.getString("tab-footer-line-"+line);
        if (finalline == null){
            Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', "&4 &F[&BSCOREBOARD&FPLUS]&4 [ERROR]- &canimated-"+"tab-footer-line-"+line +
                    " &4Its null! check that line"));
            finalline = "NULL";
        }
        return finalline;
    }


    public static Integer getHeaderLines() {return  lang.getInt("tab-header-lines"); }
    public static String getHeaderLine(Integer line) {
        if (line <= 0 || line >5){
            line = 1;
        }
        String finalline = lang.getString("tab-header-line-"+line);
        if (finalline == null){
            Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', "&4 &F[&BSCOREBOARD&FPLUS]&4 [ERROR]- &c"+
                    "tab-header-line-"+line
                    + " &4Its null! check that line"));
            finalline = "NULL";
        }
        return finalline;
    }

    public static boolean getAnimatedHeaderAndFooter(){ return lang.getBoolean("animated-header-and-footer"); }

    public static boolean getUpdateFooterAndHeader(){ return lang.getBoolean("update-footer-header"); }

    public static int getAnimatedHeaderLineInt(){ return lang.getInt("animated-tab-header-lines"); }
    public static int getAnimatedFooterLineInt(){ return lang.getInt("animated-tab-footer-lines"); }

    public static int getAnimatedHeaderAndFooterTicks(){ return lang.getInt("animated-tab-footer-and-header-ticks"); }

    public static Integer getAnimationHeaderAndFooterInt() {
        int animation = lang.getInt("animatios-header-and-footer");
        if (animation <0||animation>10){
            animation = 10;
        }
        return  animation; }

    public static String getAnimatedHeaderAndFooterLine(Integer animation, Integer line, String type) {
        if (line <= 0 || line >10){
            line = 1;
        }
        if (animation <= 0 || animation >10){
            animation = 1;
        }
        String finalline = lang.getString("animated-"+animation+"-tab-"+type+"-line-"+line);
        if (finalline == null){
            Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', "&4 &F[&BSCOREBOARD&FPLUS]&4 [ERROR]- &canimated-"+animation+"-tab-"+type+"-line-"+line +
                    " &4Its null! check that line"));
            finalline = "NULL";
        }

        return finalline;
    }
}
