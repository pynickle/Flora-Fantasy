package com.euphony.flora_fantasy.common.block;

import com.euphony.flora_fantasy.common.init.FFItems;
import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.BushBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.NotNull;

public class LuminBerryBushBlock extends BushBlock {
    public static final MapCodec<LuminBerryBushBlock> CODEC = simpleCodec(LuminBerryBushBlock::new);
    public static final IntegerProperty AGE;

    public LuminBerryBushBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(AGE, 0));
    }

    @Override
    protected long getSeed(BlockState blockState, BlockPos blockPos) {
        return super.getSeed(blockState, blockPos);
    }

    @Override
    protected @NotNull MapCodec<? extends BushBlock> codec() {
        return CODEC;
    }

    @Override
    protected boolean mayPlaceOn(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos) {
        return blockState.is(Blocks.DEEPSLATE);
    }

    @Override
    public @NotNull ItemStack getCloneItemStack(LevelReader levelReader, BlockPos blockPos, BlockState blockState) {
        return new ItemStack(FFItems.LUMIN_BERRIES.get());
    }

    @Override
    protected boolean isRandomlyTicking(BlockState blockState) {
        return blockState.getValue(AGE) < 1;
    }

    @Override
    protected void randomTick(BlockState blockState, ServerLevel serverLevel, BlockPos blockPos, RandomSource randomSource) {
        int i = blockState.getValue(AGE);
        if (i < 1 && randomSource.nextInt(5) == 0 && serverLevel.getRawBrightness(blockPos.above(), 0) <= 10) {
            BlockState blockState2 = blockState.setValue(AGE, 1);
            serverLevel.setBlock(blockPos, blockState2, 2);
            serverLevel.gameEvent(GameEvent.BLOCK_CHANGE, blockPos, GameEvent.Context.of(blockState2));
        }

    }

    @Override
    protected @NotNull InteractionResult useWithoutItem(BlockState blockState, Level level, BlockPos blockPos, Player player, BlockHitResult blockHitResult) {
        int i = blockState.getValue(AGE);
        if (i == 1) {
            int j = 1 + level.random.nextInt(2);
            popResource(level, blockPos, new ItemStack(FFItems.LUMIN_BERRIES.get(), j));
            level.playSound(null, blockPos, SoundEvents.SWEET_BERRY_BUSH_PICK_BERRIES, SoundSource.BLOCKS, 1.0F, 0.8F + level.random.nextFloat() * 0.4F);
            BlockState blockState2 = blockState.setValue(AGE, 0);
            level.setBlock(blockPos, blockState2, 2);
            level.gameEvent(GameEvent.BLOCK_CHANGE, blockPos, GameEvent.Context.of(player, blockState2));
            return InteractionResult.sidedSuccess(level.isClientSide);
        } else {
            return super.useWithoutItem(blockState, level, blockPos, player, blockHitResult);
        }
    }


    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(AGE);
    }

    static {
        AGE = BlockStateProperties.AGE_1;
    }
}
