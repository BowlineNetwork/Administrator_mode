package me.josh.staffmode.handlers;

import me.josh.staffmode.StaffMode;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;

/**
 * Created by Josh on 15/12/2017.
 */

public class ScoreboardHandler {

    public static String getVisibility(Player player) {
        if (StaffMode.getInstance().vanish.contains(player)) {
            return "&aVanished";
        }else {
            return "&cVisible";
        }
    }
    public static String getGamemode(Player player) {
        if (player.getGameMode() == GameMode.CREATIVE) {
            return "&aCreative";
        }else if (player.getGameMode() == GameMode.SURVIVAL) {
            return "&cSurvival";
        }else if (player.getGameMode() == GameMode.ADVENTURE) {
            return "&cAdventure";
        }else {
            return "&cSpectator";
        }
    }
    public static String getChatMode(Player player) {
        if (StaffMode.getInstance().staffChat.contains(player)) {
            return "&aStaff Chat";
        }else {
            return "&cGlobal Chat";
        }
    }
}
