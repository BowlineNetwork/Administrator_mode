package me.josh.staffmode.events;

import me.josh.staffmode.StaffMode;
import me.josh.staffmode.handlers.*;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

/**
 * Created by Josh on 15/12/2017.
 */

public class InteractEvent implements Listener {

    @EventHandler
    public void onInteract(PlayerInteractEvent event) {
        ItemStack vanishOn = new ItemStack(Material.INK_SACK, 1, (short) 10);
        ItemMeta vanishOnM = vanishOn.getItemMeta();
        vanishOnM.setDisplayName(ColorHandler.translate("&aDisable Vanish"));
        vanishOn.setItemMeta(vanishOnM);
        ItemStack vanishOff = new ItemStack(Material.INK_SACK, 1, (short) 8);
        ItemMeta vanishOffM = vanishOff.getItemMeta();
        vanishOffM.setDisplayName(ColorHandler.translate("&aEnable Vanish"));
        vanishOff.setItemMeta(vanishOffM);
        Player player = event.getPlayer();
        ItemStack item = event.getItem();
        Action action = event.getAction();
        if (StaffMode.getInstance().staff.contains(player)) {
            if (item != null && item.getType() != Material.AIR && item.hasItemMeta()) {
                if (action == Action.RIGHT_CLICK_BLOCK || (action == Action.RIGHT_CLICK_AIR)) {
                    ItemMeta meta = item.getItemMeta();
                    if (meta.getDisplayName().equalsIgnoreCase(ColorHandler.translate("&aMiner Teleport"))) {
                        TeleportHandler.minerTP(player);
                    }else if (meta.getDisplayName().equalsIgnoreCase(ColorHandler.translate("&aRandom Teleport"))) {
                        TeleportHandler.randomTP(player);
                    }else if (meta.getDisplayName().equalsIgnoreCase(ColorHandler.translate("&aDisable Vanish"))) {
                        player.setItemInHand(vanishOff);
                        VanishHandler.disableVanish(player);
                    }else if (meta.getDisplayName().equalsIgnoreCase(ColorHandler.translate("&aEnable Vanish"))) {
                        player.setItemInHand(vanishOn);
                        VanishHandler.enableVanish(player);
                    }
                }else {
                    return;
                }
            }else {
                return;
            }
        }else {
            return;
        }
    }
    @EventHandler
    public void onEntityInteract(PlayerInteractEntityEvent event) {
        if (event.getRightClicked() instanceof Player) {
            Player player = event.getPlayer();
            Player target = (Player) event.getRightClicked();
            ItemStack item = event.getPlayer().getItemInHand();
            if (StaffMode.getInstance().staff.contains(player)) {
                if (item.getType() != Material.AIR && item.hasItemMeta()) {
                    ItemMeta meta = item.getItemMeta();
                    if (meta.getDisplayName().equalsIgnoreCase(ColorHandler.translate("&aInventory Inspector"))) {
                        player.sendMessage(ColorHandler.translate("&eOpening " + target.getName() + "'s inventory."));
                        InspectHandler.inspect(target, player);
                    }
                }else {
                    return;
                }
            }else {
                return;
            }
        }else {
            return;
        }
    }
}
