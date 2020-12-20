package com.loafofbread.customenchants.commands;

import com.loafofbread.customenchants.gui.EnchantingTable;
import org.bukkit.attribute.Attribute;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class EnchantGui implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) { return true; }
        Player player = (Player) sender;

        if(cmd.getName().equalsIgnoreCase("enchantgui")) {
            player.openInventory(new EnchantingTable(player.getItemInHand()).getInventory());
        }


        return true;
    }
}
