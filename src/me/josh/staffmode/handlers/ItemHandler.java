package me.josh.staffmode.handlers;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

/**
 * Created by Josh on 14/12/2017.
 */

public class ItemHandler {

    public static ItemStack generateItem(Material material, int data, String name) {
        ItemStack item = new ItemStack(material);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ColorHandler.translate(name));
        item.setItemMeta(meta);
        return item;
    }
}
