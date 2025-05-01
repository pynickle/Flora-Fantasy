package com.euphony.flora_fantasy.common.item;

import com.euphony.flora_fantasy.common.init.FFDataComponents;
import com.euphony.flora_fantasy.utils.ItemUtils;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

import java.util.List;

public class AbyssalErosionPickaxeItem extends PickaxeItem {
    public AbyssalErosionPickaxeItem(Tier tier, Properties properties) {
        super(tier, properties.component(FFDataComponents.EROSION_ENERGY.get(), 0));
    }

    @Override
    public boolean mineBlock(ItemStack itemStack, Level level, BlockState blockState, BlockPos blockPos, LivingEntity livingEntity) {
        boolean res = super.mineBlock(itemStack, level, blockState, blockPos, livingEntity);
        if(blockState.is(BlockTags.IRON_ORES)) {
            itemStack.set(FFDataComponents.EROSION_ENERGY.get(), itemStack.getOrDefault(FFDataComponents.EROSION_ENERGY.get(), 0) + level.random.nextInt(4) + 4);
        } else {
            itemStack.set(FFDataComponents.EROSION_ENERGY.get(), itemStack.getOrDefault(FFDataComponents.EROSION_ENERGY.get(), 0) + level.random.nextInt(2));
        }
        return res;
    }

    @Override
    public void inventoryTick(ItemStack itemStack, Level level, Entity entity, int q, boolean bl) {
        if(itemStack.getOrDefault(FFDataComponents.EROSION_ENERGY.get(), 0) >= 100) {
            RandomSource randomSource = level.random;
            double g, h, i;
            for(int j = 0; j < 50; j++) {
                g = (randomSource.nextDouble() - 0.5) / 5;
                h = (randomSource.nextDouble() - 0.5) / 5;
                i = (randomSource.nextDouble() - 0.5) / 5;
                level.addParticle(ParticleTypes.DRAGON_BREATH, entity.getX(), entity.getY() + 1, entity.getZ(), g, h, i);
            }

            itemStack.set(FFDataComponents.EROSION_ENERGY.get(), 0);
            itemStack.setDamageValue(itemStack.getDamageValue() - 50);
        }
    }

    @Override
    public void appendHoverText(ItemStack itemStack, TooltipContext tooltipContext, List<Component> list, TooltipFlag tooltipFlag) {
        list.add(ItemUtils.createTooltip("tooltip.flora_fantasy.abyssal_erosion_pickaxe", itemStack.getOrDefault(FFDataComponents.EROSION_ENERGY.get(), 0)).append("%"));
    }
}
