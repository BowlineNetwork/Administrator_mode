package me.josh.staffmode;

import me.josh.staffmode.StaffMode;
import me.josh.staffmode.handlers.ColorHandler;
import me.josh.staffmode.handlers.VanishHandler;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

/**
 * Created by Josh on 14/12/2017.
 */

public class VanishCommand implements CommandExecutor, Listener {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String string, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(ColorHandler.translate("&cYou cannot execute this command from the console!"));
            return false;
        }
        Player player = (Player) sender;

        if (!(player.hasPermission("staffmode.vanish"))) {
            player.sendMessage(ColorHandler.translate("&cYou don't have enough permissions to execute this command!"));
            return false;
        }
        if (args.length >= 0) {
            if (StaffMode.getInstance().vanish.contains(player)) {
                VanishHandler.disableVanish(player);
    }else {
             VanishHandler.enableVanish(player);
            }
        }
        return true;
    }
    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        for (Player vanished : StaffMode.getInstance().vanish) {
            player.hidePlayer(vanished);
        }
    }
}
