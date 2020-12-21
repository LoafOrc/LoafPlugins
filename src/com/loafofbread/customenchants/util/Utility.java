package com.loafofbread.customenchants.util;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Utility {

    public ItemStack createItem(Material mat, String name) {
        ItemStack item = new ItemStack(mat, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(name);
        item.setItemMeta(meta);
        return item;
    }

    public ItemStack createItem(Material mat, String name, List<String> lore) {
        ItemStack item = new ItemStack(mat, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(name);
        meta.setLore(lore);
        item.setItemMeta(meta);
        return item;
    }

    public List<Player> OnlinePlayers() {
        List<Player> online = new ArrayList<Player>((Collection<? extends Player>) Bukkit.getOnlinePlayers());
        return online;
    }

    public String ToolType(ItemStack item) {

        if (item.getType() == Material.AIR) return null; //If there is no item selected return with null

        //Pickaxe
        if (item.getType() == Material.IRON_PICKAXE || item.getType() == Material.DIAMOND_PICKAXE || item.getType() == Material.NETHERITE_PICKAXE) return "pickaxe";
        //Sword
        if (item.getType() == Material.IRON_SWORD || item.getType() == Material.DIAMOND_SWORD || item.getType() == Material.NETHERITE_SWORD) return "sword";

        return null;
    }

}
