package me.josh.staffmode.handlers;

import me.josh.staffmode.StaffMode;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

/**
 * Created by Josh on 15/12/2017.
 */

public class  VanishHandler {

    public static void enableVanish(Player player) {
        StaffMode.getInstance().vanish.add(player);
        for (Player players : Bukkit.getOnlinePlayers()) {
            players.hidePlayer(player);
        }
        player.sendMessage(ColorHandler.translate("&eVanish mode of " + player.getName() + " set to true."));
    }
    public static void disableVanish(Player player) {
        StaffMode.getInstance().vanish.remove(player);
        for (Player players : Bukkit.getOnlinePlayers()) {
            players.showPlayer(player);
        }
        player.sendMessage(ColorHandler.translate("&eVanish mode of " + player.getName() + " set to false."));
    }
}
