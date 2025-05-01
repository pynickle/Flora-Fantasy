package com.euphony.flora_fantasy.common.block;

import com.euphony.flora_fantasy.common.init.FFBlocks;
import com.euphony.flora_fantasy.common.init.FFItems;
import com.euphony.flora_fantasy.common.tag.FFTags;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.NotNull;

public class IronbaneFrondFernBlock extends Block {
    public IronbaneFrondFernBlock(Properties properties) {
        super(properties);
    }

    protected boolean mayPlaceOn(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos) {
        return blockState.is(FFTags.IRONBANE_FERN_CAN_SURVIVE_ON);
    }

    @Override
    protected @NotNull ItemInteractionResult useItemOn(ItemStack itemStack, BlockState blockState, Level level, BlockPos blockPos, Player player, InteractionHand interactionHand, BlockHitResult blockHitResult) {
        if(itemStack.is(Items.SHEARS)) {
            if(!level.isClientSide) {
                level.setBlockAndUpdate(blockPos, FFBlocks.IRONBANE_FERN.get().defaultBlockState());
                Block.popResource(level, blockPos, new ItemStack(FFItems.IRONBANE_FROND, level.getRandom().nextInt(2) + 1));

                level.playSound(player, blockPos, SoundEvents.SHEEP_SHEAR, SoundSource.PLAYERS, 1.0F, 1.0F);
                itemStack.hurtAndBreak(1, player, LivingEntity.getSlotForHand(interactionHand));
                player.swing(interactionHand, true);
                return ItemInteractionResult.SUCCESS;
            }
        }
        return ItemInteractionResult.CONSUME;
    }

    @Override
    protected boolean canSurvive(BlockState blockState, LevelReader levelReader, BlockPos blockPos) {
        BlockPos blockPos2 = blockPos.below();
        return this.mayPlaceOn(levelReader.getBlockState(blockPos2), levelReader, blockPos2);
    }
}
