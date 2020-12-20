package com.loafofbread.customenchants.util;

import com.loafofbread.customenchants.CustomEnchants;
import org.bukkit.configuration.file.FileConfiguration;

import java.util.concurrent.ThreadLocalRandom;

public class Config {

    public static FileConfiguration config;

    public static void DefaultConfig() {

        config.addDefault("sword.max", 2);

        SwordEnchant(1, "Life-Steal",20);
        SwordEnchant(2, "Hard-Hitting",45);
        config.options().copyDefaults(true);

    }

    public static void SwordEnchant(Integer id, String name, Integer cost) {
        config.addDefault("sword." + id + ".name", name);
        config.addDefault("sword." + id + ".cost", cost);
    }

    public static Integer getRandomID(String Type) {
        return ThreadLocalRandom.current().nextInt(0, config.getInt(Type + ".max"));
    }

}
