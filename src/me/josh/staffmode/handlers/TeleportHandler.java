package me.josh.staffmode.handlers;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Josh on 15/12/2017.
 */

public class TeleportHandler {

    public static void minerTP(Player player) {
        ArrayList<Player> players = new ArrayList<Player>();
        for (Player online : Bukkit.getOnlinePlayers()) players.add(online);
        Player randomPlayer = players.get(new Random().nextInt(players.size()));
        if (players.size() == 1) {
            player.sendMessage(ColorHandler.translate("&cThere aren't enough players online to use this feature."));
        }else if (randomPlayer.getLocation().getBlockY() <= 20) {
            if (randomPlayer != player) {
                player.teleport(randomPlayer.getLocation());
                player.sendMessage(ColorHandler.translate("&eYou've been teleported to " + randomPlayer.getName()));
                return;
            }else {
                return;
            }
        }else {
            player.sendMessage(ColorHandler.translate("&cThere are no current miners."));
            return;
        }
    }
    public static void randomTP(Player player) {
        ArrayList<Player> players = new ArrayList<Player>();
        for (Player online : Bukkit.getOnlinePlayers()) players.add(online);
        Player randomPlayer = players.get(new Random().nextInt(players.size()));
        if (players.size() == 1) {
            player.sendMessage(ColorHandler.translate("&cThere aren't enough players online to use this feature."));
        }else if (randomPlayer != player) {
                player.teleport(randomPlayer.getLocation());
                player.sendMessage(ColorHandler.translate("&eYou've been teleported to " + randomPlayer.getName()));
            }else {
                return;
        }
}
}