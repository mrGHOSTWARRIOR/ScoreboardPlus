package me.mrghostwarrior.tablistplus.manager;

import me.mrghostwarrior.tablistplus.ScoreboardPlus;
import me.mrghostwarrior.tablistplus.hexcolor.HexColor;
import me.mrghostwarrior.tablistplus.intance.PluginInstace;
import net.luckperms.api.LuckPerms;
import net.luckperms.api.LuckPermsProvider;
import net.luckperms.api.model.group.Group;
import net.luckperms.api.model.user.User;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scoreboard.*;



import java.util.HashMap;



public class ScoreboradManager {

    private final ScoreboardPlus scoreboardplus;

    private static final HashMap<String, Character> groupschar = new HashMap<>();
    private static final HashMap<Integer, String> groupweight = new HashMap<>();

    public ScoreboradManager(ScoreboardPlus scoreboardplus) {
        this.scoreboardplus = scoreboardplus;
    }


    public void startanimationtitle() {
        new BukkitRunnable() {
            int count = 0;
            final int max = LangManager.getAnimatedbarLines() + 1;

            public void run() {
                if (count == max) {
                    count = 0;
                }
                for (Player player : Bukkit.getOnlinePlayers()){
                    if (player.getScoreboard().getObjective(DisplaySlot.SIDEBAR) == null) {
                        return;
                    }
                    if (!player.getScoreboard().getObjective(DisplaySlot.SIDEBAR).getName().equalsIgnoreCase("mainscoreboard")) {
                        return;
                    }
                    if (LangManager.getAminatedSideBarTitleBoolean()) {
                        player.getScoreboard().getObjective(DisplaySlot.SIDEBAR).setDisplayName(HexColor.translate(player, LangManager.getAnimatedSidebarTile(count)));
                    }
                }
                count++;
            }
        }.runTaskTimer(scoreboardplus, 0, LangManager.getSidebarAmintationTicksTitle());
    }

    public void updatesidebar() {
        new BukkitRunnable() {
            public void run() {
                int lines = LangManager.getSideBarLinesInt();
                int linenumber = 1;
                if (lines <= 0 || lines > 15) {
                    lines = 15;
                }
                while (lines >= 1) {
                    String name = lines + "line" + linenumber;
                    for (Player people : Bukkit.getOnlinePlayers()) {
                        if (people.getScoreboard().getObjective(DisplaySlot.SIDEBAR) == null ||
                                !people.getScoreboard().getObjective(DisplaySlot.SIDEBAR).getName().equalsIgnoreCase("mainscoreboard")) {
                            return;
                        }
                        if (people.getScoreboard().getTeam(name) != null) {
                            people.getScoreboard().getTeam(name).setSuffix(HexColor.translate(people, LangManager.getSidebarLine(linenumber)));
                        }
                    }
                    lines--;
                    linenumber++;
                }
            }
        }.runTaskTimer(scoreboardplus, 0, 2);
    }

    public void updatetablistfooterandheater() {
        new BukkitRunnable() {

            int linesfooter = LangManager.getFooterLines();
            int linesheaster = LangManager.getHeaderLines();

            public void run() {
                for (Player player : Bukkit.getOnlinePlayers()){
                    if (linesheaster == 5) {
                        player.setPlayerListHeader(HexColor.translate(player,
                                LangManager.getHeaderLine(1) + "\n" + LangManager.getHeaderLine(2) + "\n" + LangManager.getHeaderLine(3) + "\n" +
                                        LangManager.getHeaderLine(4) + "\n" + LangManager.getHeaderLine(5)));
                    }
                    if (linesheaster == 4) {
                        player.setPlayerListHeader(HexColor.translate(player,
                                LangManager.getHeaderLine(1) + "\n" + LangManager.getHeaderLine(2) + "\n" + LangManager.getHeaderLine(3) + "\n" +
                                        LangManager.getHeaderLine(4)));
                    }
                    if (linesheaster == 3) {
                        player.setPlayerListHeader(HexColor.translate(player,
                                LangManager.getHeaderLine(1) + "\n" + LangManager.getHeaderLine(2) + "\n" + LangManager.getHeaderLine(3)));
                    }
                    if (linesheaster == 2) {
                        player.setPlayerListHeader(HexColor.translate(player,
                                LangManager.getHeaderLine(1) + "\n" + LangManager.getHeaderLine(2)));
                    }
                    if (linesheaster == 1) {
                        player.setPlayerListHeader(HexColor.translate(player,
                                LangManager.getHeaderLine(1)));
                    }

                    if (linesfooter == 5) {
                        player.setPlayerListFooter(HexColor.translate(player,
                                LangManager.getFooterLine(1) + "\n" + LangManager.getFooterLine(2) + "\n" + LangManager.getFooterLine(3) + "\n" +
                                        LangManager.getFooterLine(4) + "\n" + LangManager.getFooterLine(5)));

                    }
                    if (linesfooter == 4) {
                        player.setPlayerListFooter(HexColor.translate(player,
                                LangManager.getFooterLine(1) + "\n" + LangManager.getFooterLine(2) + "\n" + LangManager.getFooterLine(3) + "\n" +
                                        LangManager.getFooterLine(4)));
                    }
                    if (linesfooter == 3) {
                        player.setPlayerListFooter(HexColor.translate(player,
                                LangManager.getFooterLine(1) + "\n" + LangManager.getFooterLine(2) + "\n" + LangManager.getFooterLine(3)));
                    }
                    if (linesfooter == 2) {
                        player.setPlayerListFooter(HexColor.translate(player,
                                LangManager.getFooterLine(1) + "\n" + LangManager.getFooterLine(2)));
                    }
                    if (linesfooter == 1) {
                        player.setPlayerListFooter(HexColor.translate(player,
                                LangManager.getFooterLine(1)));
                    }
                }






            }
        }.runTaskTimer(scoreboardplus, 0, LangManager.getAnimatedHeaderAndFooterTicks());
    }

    public void animatedheaterandfooter() {
        new BukkitRunnable() {
            int animation = 1;
            final int linesfooter = LangManager.getAnimatedFooterLineInt();
            final int linesheaster = LangManager.getAnimatedHeaderLineInt();

            public void run() {
                if (animation > LangManager.getAnimationHeaderAndFooterInt()) {
                    animation = 1;
                }
                if (animation < 0 || animation > 10) {
                    animation = 1;
                }
                for (Player player : Bukkit.getOnlinePlayers()){
                    if (linesheaster == 5) {
                        player.setPlayerListHeader(HexColor.translate(player,
                                LangManager.getAnimatedHeaderAndFooterLine(animation, 1, "header") + "\n" +
                                        LangManager.getAnimatedHeaderAndFooterLine(animation, 2, "header") + "\n" +
                                        LangManager.getAnimatedHeaderAndFooterLine(animation, 3, "header") + "\n" +
                                        LangManager.getAnimatedHeaderAndFooterLine(animation, 4, "header") + "\n" +
                                        LangManager.getAnimatedHeaderAndFooterLine(animation, 5, "header")));
                    }
                    if (linesfooter == 5) {
                        player.setPlayerListFooter(HexColor.translate(player,
                                LangManager.getAnimatedHeaderAndFooterLine(animation, 1, "footer") + "\n" +
                                        LangManager.getAnimatedHeaderAndFooterLine(animation, 2, "footer") + "\n" +
                                        LangManager.getAnimatedHeaderAndFooterLine(animation, 3, "footer") + "\n" +
                                        LangManager.getAnimatedHeaderAndFooterLine(animation, 4, "footer") + "\n" +
                                        LangManager.getAnimatedHeaderAndFooterLine(animation, 5, "footer")));
                    }
                    if (linesheaster == 4) {
                        player.setPlayerListHeader(HexColor.translate(player,
                                LangManager.getAnimatedHeaderAndFooterLine(animation, 1, "header") + "\n" +
                                        LangManager.getAnimatedHeaderAndFooterLine(animation, 2, "header") + "\n" +
                                        LangManager.getAnimatedHeaderAndFooterLine(animation, 3, "header") + "\n" +
                                        LangManager.getAnimatedHeaderAndFooterLine(animation, 4, "header")));
                    }
                    if (linesfooter == 4) {
                        player.setPlayerListFooter(HexColor.translate(player,
                                LangManager.getAnimatedHeaderAndFooterLine(animation, 1, "footer") + "\n" +
                                        LangManager.getAnimatedHeaderAndFooterLine(animation, 2, "footer") + "\n" +
                                        LangManager.getAnimatedHeaderAndFooterLine(animation, 3, "footer") + "\n" +
                                        LangManager.getAnimatedHeaderAndFooterLine(animation, 4, "footer")));
                    }
                    if (linesheaster == 3) {
                        player.setPlayerListHeader(HexColor.translate(player,
                                LangManager.getAnimatedHeaderAndFooterLine(animation, 1, "header") + "\n" +
                                        LangManager.getAnimatedHeaderAndFooterLine(animation, 2, "header") + "\n" +
                                        LangManager.getAnimatedHeaderAndFooterLine(animation, 3, "header")));
                    }
                    if (linesfooter == 3) {
                        player.setPlayerListFooter(HexColor.translate(player,
                                LangManager.getAnimatedHeaderAndFooterLine(animation, 1, "footer") + "\n" +
                                        LangManager.getAnimatedHeaderAndFooterLine(animation, 2, "footer") + "\n" +
                                        LangManager.getAnimatedHeaderAndFooterLine(animation, 3, "footer")));
                    }
                    if (linesheaster == 2) {
                        player.setPlayerListHeader(HexColor.translate(player,
                                LangManager.getAnimatedHeaderAndFooterLine(animation, 1, "header") + "\n" +
                                        LangManager.getAnimatedHeaderAndFooterLine(animation, 2, "header")));
                    }
                    if (linesfooter == 2) {
                        player.setPlayerListFooter(HexColor.translate(player,
                                LangManager.getAnimatedHeaderAndFooterLine(animation, 1, "footer") + "\n" +
                                        LangManager.getAnimatedHeaderAndFooterLine(animation, 2, "footer")));
                    }
                    if (linesheaster == 1) {
                        player.setPlayerListHeader(HexColor.translate(player,
                                LangManager.getAnimatedHeaderAndFooterLine(animation, 1, "header")));
                    }
                    if (linesfooter == 1) {
                        player.setPlayerListFooter(HexColor.translate(player,
                                LangManager.getAnimatedHeaderAndFooterLine(animation, 1, "footer")));
                    }
                }

                animation++;
            }
        }.runTaskTimer(scoreboardplus, 0, LangManager.getAnimatedHeaderAndFooterTicks());
    }

    public void animatedSidebar() {

        new BukkitRunnable() {
            int animation = 1;
            int lines;
            int linenumber;

            public void run() {

                lines = LangManager.getSideBarLinesInt();
                linenumber = 1;
                if (animation > LangManager.getAnimatedSideBarLinesInt()) {
                    animation = 1;
                }
                if (lines <= 0 || lines > 15) {
                    lines = 15;
                }
                if (linenumber > 15) {
                    linenumber = 1;
                }
                while (lines >= 1) {
                    for (Player people : Bukkit.getOnlinePlayers()){
                        if (people.getScoreboard().getObjective(DisplaySlot.SIDEBAR) == null ||
                                !people.getScoreboard().getObjective(DisplaySlot.SIDEBAR).getName().equalsIgnoreCase("mainscoreboard")) {
                            return;
                    }
                        String name = lines + "line" + linenumber;
                        if (people.getScoreboard().getTeam(name) != null) {
                            people.getScoreboard().getTeam(name).setSuffix(HexColor.translate(people, LangManager.getAnimatedSidebarLine(animation, linenumber)));
                        }
                    }
                    lines--;
                    linenumber++;
                }
                animation++;
            }
        }.runTaskTimer(scoreboardplus, 0, LangManager.getAnimatedbarTicks());
    }


    public void updateTabListName() {
        new BukkitRunnable() {
            public void run() {
                for (Player people : Bukkit.getOnlinePlayers()) {
                    if (people.getScoreboard().getObjective("tablist") == null){
                        return;
                    }
                    Scoreboard board = people.getScoreboard();
                    if (PluginInstace.checkLuckPermsAPI() && LangManager.getSortByLuckPermsGroupWeight()) {
                        LuckPerms luckPerms = LuckPermsProvider.get();
                        for (Player players : Bukkit.getOnlinePlayers()) {
                            Team team = board.getEntryTeam(players.getName());
                            if (team == null) {
                                return;
                            }
                            User user = luckPerms.getUserManager().getUser(players.getUniqueId());
                            String groupname = user.getCachedData().getMetaData().getPrimaryGroup();
                            if (!team.getName().equals(groupschar.get(groupname) + groupname + players.getName())){
                                    Scoreboard scoreboard = people.getScoreboard();
                                    team.removeEntry(players.getName());
                                    team.unregister();


                                addToTeam(players);
                            }else{
                                team.setSuffix(HexColor.translate(players, LangManager.getTabListSuffix()));
                                team.setPrefix(HexColor.translate(players, LangManager.getTabListPrefix()));
                            }


                        }
                    }else {
                        for (Player players : Bukkit.getOnlinePlayers()) {
                            Team team = board.getEntryTeam(players.getName());
                            if (team == null) {
                                return;
                            }
                            team.setSuffix(HexColor.translate(players, LangManager.getTabListSuffix()));
                            team.setPrefix(HexColor.translate(players, LangManager.getTabListPrefix()));
                        }
                    }
                }
            }
        }.runTaskTimer(scoreboardplus, 0, 2);
    }

    public void mainScoreBoard(Player player) {

        Objective objective = player.getScoreboard().registerNewObjective("mainscoreboard", "dummy");
        objective.setDisplaySlot(DisplaySlot.SIDEBAR);
        objective.setDisplayName(HexColor.translate(player, LangManager.getSidebarTitle()));


        int lines = LangManager.getSideBarLinesInt();
        int number = 15;
        int linenumber = 1;
        char chart = 'a';
        if (lines <= 0 || lines > 15){
            Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', "&c&lSideBar Lines cannot be longer than 15!"));
            lines = 15;
        }
        while(lines >=1 ){
            if (linenumber <=9){
                String color = ChatColor.getByChar(linenumber +"").toString();
                String name = lines + "line"+linenumber;

                Team team = objective.getScoreboard().registerNewTeam(name);
                team.setSuffix(HexColor.translate(player, LangManager.getSidebarLine(linenumber)));
                team.addEntry(color);
                objective.getScore(color).setScore(number);
            }else{
                String color = ChatColor.getByChar(chart).toString();
                String name = lines + "line"+linenumber;

                Team team = objective.getScoreboard().registerNewTeam(name);
                team.setSuffix(HexColor.translate(player, LangManager.getSidebarLine(linenumber)));
                team.addEntry(color);
                objective.getScore(color).setScore(number);
                chart++;
            }

            number--;
            lines--;
            linenumber++;
        }
    }

    public void createGroupChar(){
        LuckPerms luckPerms = LuckPermsProvider.get();
        char letter = 'A';
        int count = 100;
        while (count >= 0) {
            if (groupweight.get(count) != null){
                Group group = luckPerms.getGroupManager().getGroup(groupweight.get(count));
                int weight = group.getWeight().orElse(0);
                if (weight == count){
                    groupschar.put(group.getName(), letter);
                    letter++;
                }
            }
            count--;
        }
    }

    public void addtohashmap(){
        LuckPerms luckPerms = LuckPermsProvider.get();
        for (Group group : luckPerms.getGroupManager().getLoadedGroups()) {
            int weight = group.getWeight().orElse(0);

                groupweight.put(weight, group.getName());
        }
        createGroupChar();
    }

    public void createTabList(Player player){
        ScoreboardManager manager = Bukkit.getScoreboardManager();
        Scoreboard board = manager.getNewScoreboard();
        Objective objective = board.registerNewObjective("tablist", "dummy");
        objective.setDisplaySlot(DisplaySlot.PLAYER_LIST);

        if (LangManager.getTabListBelownameBoolean()){
            Objective obj = board.registerNewObjective("below", "dummy");
            obj.setDisplaySlot(DisplaySlot.BELOW_NAME);
            obj.setDisplayName(HexColor.translate(player, LangManager.getTabListBelowName()));
        }

        player.setScoreboard(board);

        if (PluginInstace.checkLuckPermsAPI() && LangManager.getSortByLuckPermsGroupWeight()) {
            LuckPerms luckPerms = LuckPermsProvider.get();
            for (Player people : Bukkit.getOnlinePlayers()) {
                User user = luckPerms.getUserManager().getUser(people.getUniqueId());
                String groupname = user.getCachedData().getMetaData().getPrimaryGroup();
                Team team = board.registerNewTeam(groupschar.get(groupname) + groupname + people.getName());
                team.setPrefix(HexColor.translate(people, LangManager.getTabListPrefix()));
                team.setSuffix(HexColor.translate(people, LangManager.getTabListSuffix()));
                team.addEntry(people.getName());
                System.out.println("score owner: " + player.getName() + "  player "+people.getName()+" added to : " + team.getName());
            }
        }else{
            for (Player people : Bukkit.getOnlinePlayers()) {
                Team team = board.registerNewTeam(people.getName());
                team.setPrefix(HexColor.translate(people, LangManager.getTabListPrefix()));
                team.setSuffix(HexColor.translate(people, LangManager.getTabListSuffix()));
                team.addEntry(people.getName());
            }
        }

    }
    public void addToTeam(Player player){
        if (PluginInstace.checkLuckPermsAPI() && LangManager.getSortByLuckPermsGroupWeight()) {
            LuckPerms luckPerms = LuckPermsProvider.get();

            for (Player people : Bukkit.getOnlinePlayers()) {
                if (people.getScoreboard().getEntryTeam(player.getName()) != null) {
                    Team team = people.getScoreboard().getEntryTeam(player.getName());
                    team.setPrefix(HexColor.translate(player, LangManager.getTabListPrefix()));
                    team.setSuffix(HexColor.translate(player, LangManager.getTabListSuffix()));
                    team.addEntry(player.getName());
                }else{
                    User user = luckPerms.getUserManager().getUser(player.getUniqueId());
                    String groupname = user.getCachedData().getMetaData().getPrimaryGroup();


                    Team team = people.getScoreboard().registerNewTeam(groupschar.get(groupname) + groupname + player.getName());

                    team.setPrefix(HexColor.translate(player, LangManager.getTabListPrefix()));
                    team.setSuffix(HexColor.translate(player, LangManager.getTabListSuffix()));
                    team.addEntry(player.getName());

                }

            }
        }else{
            for (Player people : Bukkit.getOnlinePlayers()) {
                if (people.getScoreboard().getEntryTeam(player.getName()) != null) {
                    return;
                }
                if (people.getScoreboard().getEntryTeam(player.getName()) != null) {
                    Team team = people.getScoreboard().getEntryTeam(player.getName());
                    team.setPrefix(HexColor.translate(player, LangManager.getTabListPrefix()));
                    team.setSuffix(HexColor.translate(player, LangManager.getTabListSuffix()));
                    team.addEntry(player.getName());
                }else {
                    Team team = people.getScoreboard().registerNewTeam(player.getName());
                    team.setPrefix(HexColor.translate(player, LangManager.getTabListPrefix()));
                    team.setSuffix(HexColor.translate(player, LangManager.getTabListSuffix()));
                    team.addEntry(player.getName());
                }
            }
        }
    }

    public void removeTeam (Player player) {
        for (Player people : Bukkit.getOnlinePlayers()) {
            Scoreboard scoreboard = people.getScoreboard();

            Team team = scoreboard.getEntryTeam(player.getName());
            if (team != null){
                team.removeEntry(player.getName());
                team.unregister();
            }
        }
    }

    public void setFooter(Player player){
        int lines = LangManager.getFooterLines();
        if (lines <= 0 || lines >5){
            lines = 5;
        }
        if (lines == 5){
            player.setPlayerListFooter(HexColor.translate(player,
                    LangManager.getFooterLine(1) + "\n"+LangManager.getFooterLine(2) + "\n"+LangManager.getFooterLine(3) + "\n"+
                            LangManager.getFooterLine(4) + "\n"+LangManager.getFooterLine(5)));

        }
        if (lines == 4){
            player.setPlayerListFooter(HexColor.translate(player,
                    LangManager.getFooterLine(1) + "\n"+LangManager.getFooterLine(2) + "\n"+LangManager.getFooterLine(3) + "\n"+
                    LangManager.getFooterLine(4)));
        }
        if (lines == 3){
            player.setPlayerListFooter(HexColor.translate(player,
                    LangManager.getFooterLine(1) + "\n"+LangManager.getFooterLine(2) + "\n"+LangManager.getFooterLine(3)));
        }
        if (lines == 2){
            player.setPlayerListFooter(HexColor.translate(player,
                    LangManager.getFooterLine(1) + "\n"+LangManager.getFooterLine(2)));
        }
        if (lines == 1){
            player.setPlayerListFooter(HexColor.translate(player,
                    LangManager.getFooterLine(1)));
        }


    }

    public void setHeader(Player player){
        int lines = LangManager.getHeaderLines();
        if (lines <= 0 || lines >5){
            lines = 5;
        }

        if (lines == 5){
            player.setPlayerListHeader(HexColor.translate(player,
                    LangManager.getHeaderLine(1) + "\n"+LangManager.getHeaderLine(2) + "\n"+LangManager.getHeaderLine(3) + "\n"+
                    LangManager.getHeaderLine(4) + "\n"+LangManager.getHeaderLine(5)));
        }
        if (lines == 4){
            player.setPlayerListHeader(HexColor.translate(player,
                    LangManager.getHeaderLine(1) + "\n"+LangManager.getHeaderLine(2) + "\n"+LangManager.getHeaderLine(3) + "\n"+
                    LangManager.getHeaderLine(4)));
        }
        if (lines == 3){
            player.setPlayerListHeader(HexColor.translate(player,
                    LangManager.getHeaderLine(1) + "\n"+LangManager.getHeaderLine(2) + "\n"+LangManager.getHeaderLine(3)));
        }
        if (lines == 2){
            player.setPlayerListHeader(HexColor.translate(player,
                    LangManager.getHeaderLine(1) + "\n"+LangManager.getHeaderLine(2)));
        }
        if (lines == 1){
            player.setPlayerListHeader(HexColor.translate(player,
                    LangManager.getHeaderLine(1)));
        }
    }


}



