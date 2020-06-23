package me.josh.staffmode.handlers;

import me.josh.staffmode.StaffMode;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scoreboard.DisplaySlot;

import java.io.IOException;

/**
 * Created by Josh on 14/12/2017.
 */

public class StaffHandler {

    public static void enableStaff(Player player) {

        StaffMode.getInstance().staff.add(player);

        try {
            InventoryHandler.saveInventory(player);
        }catch (IOException e) {
            Bukkit.getLogger().severe("ERROR: Failed to save inventory!");
            e.printStackTrace();
        }
        Inventory inv = player.getInventory();
        inv.clear();

        ItemStack vanishOn = new ItemStack(Material.INK_SACK, 1, (short) 10);
        ItemMeta vanishOnM = vanishOn.getItemMeta();
        vanishOnM.setDisplayName(ColorHandler.translate("&aDisable Vanish"));
        vanishOn.setItemMeta(vanishOnM);

        ItemStack compass = new ItemStack(ItemHandler.generateItem(Material.COMPASS, "&aPhase Compass"));
        ItemStack inventoryInspector = new ItemStack(ItemHandler.generateItem(Material.BOOK, "&aInventory Inspector"));
        ItemStack minerTP = new ItemStack(ItemHandler.generateItem(Material.WOOD_PICKAXE, "&aMiner Teleport"));
        ItemStack freeze = new ItemStack(ItemHandler.generateItem(Material.PACKED_ICE, "&aFreeze Player"));
        ItemStack randomTP = new ItemStack(ItemHandler.generateItem(Material.BLAZE_ROD, "&aRandom Teleport"));

        inv.setItem(0, compass);
        inv.setItem(1, inventoryInspector);
        inv.setItem(2, minerTP);
        inv.setItem(6, freeze);
        inv.setItem(7, randomTP);
        inv.setItem(8, vanishOn);

        player.setGameMode(GameMode.CREATIVE);
        player.setAllowFlight(true);
        VanishHandler.enableVanish(player);
        player.sendMessage(ColorHandler.translate("&eYou have enabled staff mode."));
    }
    public static void disableStaff(Player player) {

        StaffMode.getInstance().staff.remove(player);

        try {
            InventoryHandler.restoreInventory(player);
        }catch (IOException e) {
            Bukkit.getLogger().severe("ERROR: Failed to restore inventory!");
            e.printStackTrace();
        }

        player.setAllowFlight(false);
        player.setGameMode(GameMode.SURVIVAL);
        player.getScoreboard().clearSlot(DisplaySlot.SIDEBAR);
        VanishHandler.disableVanish(player);
        player.sendMessage(ColorHandler.translate("&cYou have disabled staff mode."));
    }
}
