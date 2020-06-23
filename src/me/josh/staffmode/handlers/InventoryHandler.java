package me.josh.staffmode.handlers;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

/**
 * Created by Josh on 14/12/2017.
 */

public class InventoryHandler {

    public static void saveInventory(Player player) throws IOException {
        File PD = new File(Bukkit.getServer().getPluginManager().getPlugin("StaffMode").getDataFolder(),
                File.separator + "Inventories");
        File f = new File(PD, File.separator +  player.getUniqueId().toString() + ".yml");
        FileConfiguration data = YamlConfiguration.loadConfiguration(f);
        data.set("Inventory.Armor", player.getInventory().getArmorContents());
        data.set("Inventory.Contents", player.getInventory().getContents());
        data.set("Stats.Food", player.getFoodLevel());
        data.set("Stats.Health", player.getHealth());
        data.set("Stats.XP", player.getExp());
        data.save(f);
    }
    @SuppressWarnings("unchecked")
    public static void restoreInventory(Player player) throws IOException {
        UUID uuid = player.getUniqueId();
        File file = getPlayerFile(uuid);
        FileConfiguration data = YamlConfiguration.loadConfiguration(file);

        ItemStack[] contents = ((List<ItemStack>) data.get("Inventory.Contents")).toArray(new ItemStack[0]);
        ItemStack[] armor = ((List<ItemStack>) data.get("Inventory.Armor")).toArray(new ItemStack[0]);
        int foodLevel = data.getInt("Stats.Food");
        double health = data.getInt("Stats.Health");
        float XP = data.getInt("Stats.XP");

        player.getInventory().setArmorContents(armor);
        player.getInventory().setContents(contents);
        player.setFoodLevel(foodLevel);
        player.setHealth(health);
        player.setExp(XP);

        data.set("Inventory", null);
        data.set("Stats", null);

        saveUserFile(data, file, uuid);
    }
    public static File getPlayerFile(UUID UUID) {
        File playerFile = new File(Bukkit.getPluginManager().getPlugin("StaffMode").getDataFolder() + File.separator + "Inventories", UUID + ".yml");
        return playerFile;
    }
    private static void saveUserFile(FileConfiguration data, File PD, UUID UUID) {
        try {
            data.save(PD);
        } catch (IOException ex) {
            Bukkit.getServer().getLogger().severe("Could not save " + UUID + "'s data file!");
            ex.printStackTrace();
        }
    }

}
