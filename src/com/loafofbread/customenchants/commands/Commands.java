package com.loafofbread.customenchants.commands;

import com.loafofbread.customenchants.util.Config;
import org.bukkit.attribute.Attribute;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

public class Commands implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (!(sender instanceof Player)) { return true; }

        Player player = (Player) sender;

        // /Heal
        if(cmd.getName().equalsIgnoreCase("heal")) {
            player.sendMessage(Config.config.getString("sword.1.name"));
        }

        else if(cmd.getName().equalsIgnoreCase("FarmTime")) {
            if (args.length >= 2) {
                try {
                    EntityType entityType = EntityType.valueOf(args[0].toUpperCase());
                    int amount = Integer.parseInt(args[1]);

                    for (int i = 0; i < amount; i++) {
                        player.getWorld().spawnEntity(player.getLocation(), entityType);
                    }
                } catch (IllegalArgumentException e) {
                    player.sendMessage("@r @cProvide a valid entity");
                }

            } else {
                player.sendMessage("@r @c/farmtime <mob> <amount>");
            }
        }

        return true;
    }

}
