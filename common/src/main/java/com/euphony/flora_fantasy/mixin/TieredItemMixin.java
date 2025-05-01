package com.euphony.flora_fantasy.mixin;

import com.euphony.flora_fantasy.common.init.FFDataComponents;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TieredItem;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.*;

@Mixin(TieredItem.class)
public class TieredItemMixin extends Item {
    @Mutable
    @Shadow
    @Final
    private Tier tier;
    @Unique
    private static int flora_fantasy$timer = 0;

    public TieredItemMixin(Tier tier, Properties properties) {
        super(properties.component(FFDataComponents.NETHERMEND_REMAINING.get(), 0));
        this.tier = tier;
    }

    @Override
    public void inventoryTick(ItemStack itemStack, Level level, Entity entity, int i, boolean bl) {
        super.inventoryTick(itemStack, level, entity, i, bl);
        if(flora_fantasy$timer < 60) {
            flora_fantasy$timer ++;
            return;
        }
        flora_fantasy$timer = 0;

        if(itemStack.has(FFDataComponents.NETHERMEND_REMAINING.get())) {
            int remaining = itemStack.getOrDefault(FFDataComponents.NETHERMEND_REMAINING.get(), 0);
            if (remaining > 0) {
                int damage = itemStack.getDamageValue();
                if(damage <= 0) {
                    return;
                }
                itemStack.setDamageValue(damage - 15);
                itemStack.set(FFDataComponents.NETHERMEND_REMAINING.get(), remaining - 60);
            }
        }
    }
}
