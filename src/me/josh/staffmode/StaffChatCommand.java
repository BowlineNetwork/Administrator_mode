package me.josh.staffmode;

import me.josh.staffmode.StaffMode;
import me.josh.staffmode.handlers.ColorHandler;
import me.josh.staffmode.handlers.StaffHandler;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * Created by Josh on 14/12/2017.
 */

public class StaffChatCommand implements CommandExecutor{

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String string, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(ColorHandler.translate("&cYou cannot execute this command from the console!"));
            return false;
        }
        Player player = (Player) sender;

        if (!(player.hasPermission("staffmode.sc"))) {
            player.sendMessage(ColorHandler.translate("&cYou don't have enough permissions to execute this command!"));
            return false;
        }
        if (args.length >= 0) {
            if (StaffMode.getInstance().staffChat.contains(player)) {
                StaffMode.getInstance().staffChat.remove(player);
                player.sendMessage(ColorHandler.translate("&eYou have left the Staff Chat!"));
                return true;
            }else {
                StaffMode.getInstance().staffChat.add(player);
                player.sendMessage(ColorHandler.translate("&eYou have joined the Staff Chat!"));
                return true;
            }
        }
        return false;
}
}
