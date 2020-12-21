package com.loafofbread.customenchants.events;

import com.loafofbread.customenchants.CustomEnchants;
import com.loafofbread.customenchants.gui.EnchantingTable;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class GUIEvents implements Listener {

    @EventHandler
    public void EnchantGUI(InventoryClickEvent e) {
        if (e.getClickedInventory() == null || !(e.getClickedInventory().getHolder() instanceof EnchantingTable)) { return; }

        e.setCancelled(true);
        Player player = (Player) e.getWhoClicked();

        if (e.getCurrentItem() == null) { return; }
        if (e.getCurrentItem().getType() == Material.BOOK) {

            ItemStack PlayerItem = player.getInventory().getItemInMainHand();
            ItemMeta PlayerMeta = PlayerItem.getItemMeta();

            if (PlayerMeta == null) {
                System.out.println(ChatColor.RED + "[CustomEnchants] The player's item had no item meta data");
                return;
            }
            List<String> Lore = new ArrayList<String>();
            if (PlayerMeta.getLore() != null)
                Lore = PlayerMeta.getLore();

            Lore.add(ChatColor.GRAY + e.getCurrentItem().getItemMeta().getDisplayName());

            PlayerMeta.setLore(Lore);
            PlayerItem.setItemMeta(PlayerMeta);

            player.closeInventory();

        }

    }
}
