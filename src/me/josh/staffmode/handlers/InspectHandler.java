package me.josh.staffmode.handlers;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

/**
 * Created by Josh on 15/12/2017.
 */

public class InspectHandler {

    public static void inspect(Player target, Player player) {

        ItemStack filler = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 11);
        ItemStack freeze = new ItemStack(ItemHandler.generateItem(Material.PACKED_ICE, "&aFreeze " + target.getName()));
        ItemStack clearInventory = new ItemStack(ItemHandler.generateItem(Material.BUCKET, "&aClear inventory of " + target.getName()));

        Inventory inv = Bukkit.createInventory(null, 54, ColorHandler.translate("&e" + target.getName() + "'s Inventory"));
        inv.setContents(target.getInventory().getContents());

        inv.setItem(36, filler);
        inv.setItem(37, filler);
        inv.setItem(38, filler);
        inv.setItem(39, filler);
        inv.setItem(40, filler);
        inv.setItem(41, filler);
        inv.setItem(42, filler);
        inv.setItem(43, filler);
        inv.setItem(44, filler);
        inv.setItem(49, filler);
        inv.setItem(50, clearInventory);
        inv.setItem(51, freeze);
        inv.setItem(45, target.getInventory().getHelmet());
        inv.setItem(46, target.getInventory().getChestplate());
        inv.setItem(47, target.getInventory().getLeggings());
        inv.setItem(48, target.getInventory().getBoots());

        player.openInventory(inv);
    }
}
