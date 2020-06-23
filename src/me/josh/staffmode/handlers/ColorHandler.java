package me.josh.staffmode.handlers;

import org.bukkit.ChatColor;

import java.util.List;

/**
 * Created by Josh on 14/12/2017.
 */

public class ColorHandler {

    public static String translate (String message) {
        return ChatColor.translateAlternateColorCodes('&', message);
    }
    public static List<String> translateList (List<String> message) {
        for (String s : message) {
            message.remove(s);
            message.add(ColorHandler.translate(s));
        }
        return message;
    }
}
