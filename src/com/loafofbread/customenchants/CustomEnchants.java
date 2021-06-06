package com.loafofbread.customenchants;

import com.loafofbread.customenchants.pickaxe.Explosive;
import com.sucy.enchant.api.EnchantPlugin;
import com.sucy.enchant.api.EnchantmentRegistry;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public class CustomEnchants extends JavaPlugin implements EnchantPlugin {

    public static int test = 4;

    @Override
    public void onEnable() {

        System.out.println(ChatColor.GREEN + "[CustomEnchants]: Plugin is enabled!");

    }

    @Override
    public void onDisable() {

        System.out.println(ChatColor.RED + "[CustomEnchants]: Plugin is disabled!");

    }

    @Override
    public void registerEnchantments(final EnchantmentRegistry enchantmentRegistry) {
        enchantmentRegistry.register(
                new Explosive()
        );
    }
}
