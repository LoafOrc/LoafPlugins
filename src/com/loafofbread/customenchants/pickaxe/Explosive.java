package com.loafofbread.customenchants.pickaxe;

import com.sucy.enchant.api.CustomEnchantment;
import com.sucy.enchant.api.ItemSet;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.block.BlockEvent;

public class Explosive extends CustomEnchantment {
        public Explosive() {
            super("Explosive","Creates an Explosion");

            addNaturalItems(ItemSet.PICKAXES.getItems());

        }

    @Override
    public void applyBreak(LivingEntity user, Block block, int level, BlockEvent event) {
        World w = user.getWorld();
        w.createExplosion(block.getLocation(), 3, false);
    }
}
