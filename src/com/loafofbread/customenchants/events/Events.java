package com.loafofbread.customenchants.events;

import com.loafofbread.customenchants.gui.EnchantingTable;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;

public class Events implements Listener {

    @EventHandler
    public static void onEnchantingTable(PlayerInteractEvent event) {
        if (event.getAction() != Action.RIGHT_CLICK_BLOCK) return;
        if (event.getClickedBlock().getType() == Material.ENCHANTING_TABLE) {
            event.setCancelled(true);
            Player player = event.getPlayer();
            player.openInventory(new EnchantingTable(player.getItemInHand()).getInventory());
        }
    }

}
