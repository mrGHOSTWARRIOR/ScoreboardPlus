package me.mrghostwarrior.tablistplus.hexcolor;

import me.clip.placeholderapi.PlaceholderAPI;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HexColor {
    public static Pattern pattern = Pattern.compile("#[a-fA-F0-9]{6}");

    public static String translatehex (String input) {
        Matcher matcher = pattern.matcher(input);
        while (matcher.find()) {
            String color = input.substring(matcher.start(), matcher.end());
            input = input.replace(color, ChatColor.of(color) + "");
            matcher = pattern.matcher(input);
        }
        return input;
    }
    //translate all codes
    public static String translate(Player player, String input){
        if (Bukkit.getServer().getPluginManager().getPlugin("PlaceholderAPI")!=null){
            return org.bukkit.ChatColor.translateAlternateColorCodes('&', translatehex(PlaceholderAPI.setPlaceholders(player, input)));
        }
        return org.bukkit.ChatColor.translateAlternateColorCodes('&', translatehex(input));
    }

}