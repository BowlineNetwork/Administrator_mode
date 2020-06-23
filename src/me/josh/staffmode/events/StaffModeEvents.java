package me.josh.staffmode.events;

import me.josh.staffmode.StaffMode;
import me.josh.staffmode.handlers.ColorHandler;
import me.josh.staffmode.handlers.StaffHandler;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityTargetLivingEntityEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.event.player.PlayerQuitEvent;

/**
 * Created by Josh on 14/12/2017.
 */

public class StaffModeEvents implements Listener {

    @EventHandler
    public void onBreak(BlockBreakEvent event) {
        Player player = event.getPlayer();
        if (StaffMode.getInstance().staff.contains(player)) {
            event.setCancelled(true);
            return;
        }
    }

    @EventHandler
    public void onPlace(BlockPlaceEvent event) {
        Player player = event.getPlayer();
        if (StaffMode.getInstance().staff.contains(player)) {
            event.setCancelled(true);
            return;
        }
    }

    @EventHandler
    public void onDamage(EntityDamageEvent event) {
        if (event.getEntity() instanceof Player) {
            Player player = (Player) event.getEntity();
            if (StaffMode.getInstance().staff.contains(player)) {
                event.setCancelled(true);
                return;
            }
        }else {
            return;
        }
    }
    @EventHandler
    public void onFoodLevelChange(FoodLevelChangeEvent event) {
        if (event.getEntity() instanceof Player) {
            Player player = (Player) event.getEntity();
            if (StaffMode.getInstance().staff.contains(player)) {
                event.setCancelled(true);
            }
        }else {
            return;
        }
    }
    @EventHandler
    public void onItemDrop(PlayerDropItemEvent event) {
        Player player = event.getPlayer();
        if (StaffMode.getInstance().staff.contains(player)) {
            event.setCancelled(true);
            return;
        }
    }
    @EventHandler
    public void onItemPickup(PlayerPickupItemEvent event) {
        Player player = event.getPlayer();
        if (StaffMode.getInstance().staff.contains(player)) {
            event.setCancelled(true);
            return;
        }
    }
    @EventHandler
    public void onEntityDamage(EntityDamageByEntityEvent event) {
        if (event.getEntity() instanceof Player && event.getDamager() instanceof Player) {
            Player player = (Player) event.getEntity();
            Player damager = (Player) event.getDamager();
            if (StaffMode.getInstance().staff.contains(player)) {
                event.setCancelled(true);
                damager.sendMessage(ColorHandler.translate("&cYou cannot damage a player in staff mode!"));
                return;
            }else if (StaffMode.getInstance().staff.contains(damager)) {
                event.setCancelled(true);
                return;
            }
        }else {
            return;
        }
    }
    @EventHandler
    public void onInvClick(InventoryClickEvent event) {
        if (event.getWhoClicked() instanceof Player) {
            Player player = (Player) event.getWhoClicked();
            if (StaffMode.getInstance().staff.contains(player)) {
                event.setCancelled(true);
                return;
            }
        }else {
            return;
        }
    }
    @EventHandler
    public void onQuit(PlayerQuitEvent event) {
        Player player = event.getPlayer();
        if (StaffMode.getInstance().staff.contains(player)) {
            StaffMode.getInstance().staff.remove(player);
            StaffHandler.disableStaff(player);
            return;
        }else {
            return;
        }
    }

}