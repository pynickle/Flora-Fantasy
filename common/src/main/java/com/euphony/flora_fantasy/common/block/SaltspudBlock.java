package com.euphony.flora_fantasy.common.block;

import com.euphony.flora_fantasy.common.init.FFItems;
import net.minecraft.core.BlockPos;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.PotatoBlock;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

public class SaltspudBlock extends PotatoBlock {
    public SaltspudBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected @NotNull ItemLike getBaseSeedId() {
        return FFItems.SALTSPUD.get();
    }

    protected boolean mayPlaceOn(BlockState arg, BlockGetter arg2, BlockPos arg3) {
        return arg.is(BlockTags.SAND);
    }
}
