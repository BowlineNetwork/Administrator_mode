package me.josh.staffmode.events;

import me.josh.staffmode.StaffMode;
import me.josh.staffmode.handlers.ColorHandler;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

/**
 * Created by Josh on 14/12/2017.
 */

public class StaffChatEvent implements Listener{

    @EventHandler
    public void onStaffChatMessage(AsyncPlayerChatEvent event) {
        Player player = event.getPlayer();
        if (StaffMode.getInstance().staffChat.contains(player)) {
            event.setCancelled(true);
            for (Player staffMember : Bukkit.getOnlinePlayers()) {
                if (staffMember.hasPermission("staffmode.sc")) {
                    staffMember.sendMessage(ColorHandler.translate("&b" + player.getName() + ": " + event.getMessage()));
                }
            }
        }else {
            return;
        }
    }
}
