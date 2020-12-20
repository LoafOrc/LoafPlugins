package com.loafofbread.customenchants.gui;

import com.loafofbread.customenchants.CustomEnchants;
import com.loafofbread.customenchants.util.Utility;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;

import static org.bukkit.Bukkit.getServer;

public class EnchantingTable implements InventoryHolder {

    private Inventory Inv;


    private Utility Utility = new Utility();

    private int Size = 36;

    public EnchantingTable(ItemStack PlayerItem) {
        Inv = Bukkit.createInventory(this, Size, "Enchanting Table");

        fill(Utility.createItem(Material.LIGHT_GRAY_STAINED_GLASS, ""));
        Inv.setItem(4, PlayerItem);

        Inv.setItem(13, Utility.createItem(Material.BOOK, "potato"));

    }


    private void border(ItemStack border) {
        //Top
        for (int i = 0; i < 9; i++) {
            Inv.setItem(i, border);
        }

        for (int i = 9; i < Size - 9; i++) {
            if (i % 9 == 0) { Inv.setItem(i, border); }
            if (i == 17) { Inv.setItem(i, border); }
            if (i == 26) { Inv.setItem(i, border); }
            if (i == 35) { Inv.setItem(i, border); }
        }

        //Bottom
        for (int i = Size - 9; i < Size; i++) {
            Inv.setItem(i, border);
        }
    }

    private void fill(ItemStack fill) {
        for (int i = 0; i < Size; i++) {
            Inv.setItem(i, fill);
        }
    }

    @Override
    public Inventory getInventory() {
        return Inv;
    }
    public int getSize() {
        return Size;
    }
}
