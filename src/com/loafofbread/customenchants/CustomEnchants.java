package com.loafofbread.customenchants;

import com.loafofbread.customenchants.commands.Commands;
import com.loafofbread.customenchants.commands.EnchantGui;
import com.loafofbread.customenchants.events.EnchantCheck;
import com.loafofbread.customenchants.events.Events;
import com.loafofbread.customenchants.events.GUIEvents;
import com.loafofbread.customenchants.util.Config;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandExecutor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class CustomEnchants extends JavaPlugin {

    public static int test = 4;

    @Override
    public void onEnable() {

        Config.config = getConfig();

        Config.DefaultConfig();
        saveConfig();

        Commands commands = new Commands();

        getServer().getPluginManager().registerEvents(new Events(), this);
        getServer().getPluginManager().registerEvents(new GUIEvents(), this);
        getServer().getPluginManager().registerEvents(new EnchantCheck(), this);
        getCommand("heal").setExecutor(commands);
        getCommand("farmtime").setExecutor(commands);
        getCommand("enchantgui").setExecutor(new EnchantGui());

        System.out.println(ChatColor.GREEN + "[CustomEnchants]: Plugin is enabled!");
    }

    @Override
    public void onDisable() {

        System.out.println(ChatColor.RED + "[CustomEnchants]: Plugin is disabled!");

    }

}
