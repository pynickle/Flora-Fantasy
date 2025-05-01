package com.euphony.flora_fantasy.common.block;

import com.euphony.flora_fantasy.common.init.FFBlocks;
import com.euphony.flora_fantasy.common.tag.FFTags;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;

public class IronbaneFernBlock extends Block {
    public IronbaneFernBlock(Properties properties) {
        super(properties);
    }

    protected boolean mayPlaceOn(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos) {
        return blockState.is(FFTags.IRONBANE_FERN_CAN_SURVIVE_ON);
    }

    @Override
    protected void randomTick(BlockState blockState, ServerLevel serverLevel, BlockPos blockPos, RandomSource randomSource) {
        BlockPos below = blockPos.below();

        if(serverLevel.getBlockState(below).is(Blocks.DEEPSLATE_IRON_ORE)) {
            if(randomSource.nextInt(5) == 0) {
                BlockState blockState2 = FFBlocks.IRONBANE_FROND_FERN.get().defaultBlockState();

                serverLevel.setBlockAndUpdate(blockPos, blockState2);
                serverLevel.setBlockAndUpdate(below, Blocks.DEEPSLATE.defaultBlockState());
            }
        }
    }

    @Override
    protected boolean canSurvive(BlockState blockState, LevelReader levelReader, BlockPos blockPos) {
        BlockPos blockPos2 = blockPos.below();
        return this.mayPlaceOn(levelReader.getBlockState(blockPos2), levelReader, blockPos2);
    }
}
