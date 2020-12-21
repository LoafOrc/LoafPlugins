package com.loafofbread.customenchants.events;

import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

public class EnchantCheck implements Listener {
    @EventHandler
    public static void onMine(BlockBreakEvent event) {
        Player player = event.getPlayer();
        if (checkForEnchant(player.getInventory().getItemInMainHand(), "Explosive")) {
            player.getWorld().createExplosion(event.getBlock().getLocation(), 4F);
        }
    }

    public static boolean checkForEnchant(ItemStack item, String Enchant) {
        for (int i = 0; i < item.getItemMeta().getLore().size(); i++) {
            if (item.getItemMeta().getLore().get(i).equals(ChatColor.GRAY + Enchant)) return true;
        }
        return false;
    }
}
