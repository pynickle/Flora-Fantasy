package com.euphony.flora_fantasy.common.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;

public class SnapBeanBlock extends CropBlock {
    public static final MapCodec<SnapBeanBlock> CODEC = simpleCodec(SnapBeanBlock::new);
    private static final VoxelShape[] SHAPE_BY_AGE = new VoxelShape[]{Block.box(0.0F, 0.0F, 0.0F, 16.0F, 2.0F, 16.0F), Block.box(0.0F, 0.0F, 0.0F, 16.0F, 3.0F, 16.0F), Block.box(0.0F, 0.0F, 0.0F, 16.0F, 4.0F, 16.0F), Block.box(0.0F, 0.0F, 0.0F, 16.0F, 5.0F, 16.0F), Block.box(0.0F, 0.0F, 0.0F, 16.0F, 6.0F, 16.0F), Block.box(0.0F, 0.0F, 0.0F, 16.0F, 7.0F, 16.0F), Block.box(0.0F, 0.0F, 0.0F, 16.0F, 8.0F, 16.0F), Block.box(0.0F, 0.0F, 0.0F, 16.0F, 9.0F, 16.0F)};
    
    public SnapBeanBlock(Properties properties) {
        super(properties);
    }
    
    public @NotNull MapCodec<SnapBeanBlock> codec() {
        return CODEC;
    }

    protected ItemLike getBaseSeedId() {
        return Items.POTATO;
    }

    protected @NotNull VoxelShape getShape(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos, CollisionContext collisionContext) {
        return SHAPE_BY_AGE[this.getAge(blockState)];
    }
}
