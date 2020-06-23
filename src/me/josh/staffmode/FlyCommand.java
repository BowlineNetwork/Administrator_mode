package me.josh.staffmode;

import me.josh.staffmode.handlers.ColorHandler;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * Created by Josh on 14/12/2017.
 */

public class FlyCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String string, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(ColorHandler.translate("&cYou cannot execute this command from the console!"));
            return false;
        }
        Player player = (Player) sender;

        if (!(player.hasPermission("staffmode.fly"))) {
            player.sendMessage(ColorHandler.translate("&cYou don't have enough permissions to execute this command!"));
            return false;
        }
        if (args.length >= 0) {
            if (player.getAllowFlight()) {
                player.setAllowFlight(false);
                player.sendMessage(ColorHandler.translate("&eFlight mode of " + player.getName() +  " &eset to false."));
                return true;
            }else {
                player.setAllowFlight(true);
                player.sendMessage(ColorHandler.translate("&eFlight mode of " + player.getName() +  " &eset to true."));
                return true;
            }
        }
        return false;
    }
}
