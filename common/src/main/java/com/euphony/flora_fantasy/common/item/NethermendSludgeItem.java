package com.euphony.flora_fantasy.common.item;

import com.euphony.flora_fantasy.common.init.FFDataComponents;
import com.euphony.flora_fantasy.common.tag.FFTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

public class NethermendSludgeItem extends Item {
    public static final int USE_DURATION = 40;

    public NethermendSludgeItem(Properties properties) {
        super(properties);
    }

    @Override
    public @NotNull InteractionResultHolder<ItemStack> use(Level level, @NotNull Player player, @NotNull InteractionHand hand) {
        if(!level.isClientSide()) {
            if(hand == InteractionHand.OFF_HAND && player.getMainHandItem().is(FFTags.NETHERMEND_SLUDGE_TOOLS)) {
                player.startUsingItem(hand);
            }
        }

        return new InteractionResultHolder<>(InteractionResult.PASS, player.getItemInHand(hand));
    }

    @Override
    public @NotNull ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity livingEntity) {
        if (livingEntity instanceof Player player && !level.isClientSide()) {
            ItemStack mainHandItem = player.getMainHandItem();
            if(mainHandItem.is(FFTags.NETHERMEND_SLUDGE_TOOLS)) {
                mainHandItem.set(FFDataComponents.NETHERMEND_REMAINING.get(), 2400);
                stack = Items.GLASS_BOTTLE.getDefaultInstance();
            }
        }
        return stack;
    }

    @Override
    public int getUseDuration(ItemStack stack, LivingEntity entity) {
        return USE_DURATION;
    }

    @Override
    public @NotNull UseAnim getUseAnimation(ItemStack stack) {
        return UseAnim.BOW;
    }
}
