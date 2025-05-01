package com.euphony.flora_fantasy.common.feature;

import com.euphony.flora_fantasy.common.feature.config.GrowthConfiguration;
import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;

public class GrowthFeature extends Feature<GrowthConfiguration> {
    public GrowthFeature(Codec<GrowthConfiguration> codec) {
        super(codec);
    }

    public boolean place(FeaturePlaceContext<GrowthConfiguration> featurePlaceContext) {
        WorldGenLevel worldGenLevel = featurePlaceContext.level();
        BlockPos blockPos = featurePlaceContext.origin();
        GrowthConfiguration growthConfiguration = featurePlaceContext.config();

        GrowthConfiguration.TargetBlockState target = growthConfiguration.targetState;
        GrowthConfiguration.TargetBlockState base = growthConfiguration.baseState;
        GrowthConfiguration.TargetBlockState growth = growthConfiguration.growthState;

        if (target.target.test(worldGenLevel.getBlockState(blockPos), featurePlaceContext.random())
                && base.target.test(worldGenLevel.getBlockState(blockPos.below()), featurePlaceContext.random())
                && growth.target.test(worldGenLevel.getBlockState(blockPos.above()), featurePlaceContext.random())) {
            worldGenLevel.setBlock(blockPos, target.state, 2);
            worldGenLevel.setBlock(blockPos.above(), growth.state, 2);
            worldGenLevel.setBlock(blockPos.below(), base.state, 2);
            for(int i = blockPos.getX() - 1; i <= blockPos.getX() + 1; i++) {
                for(int j = blockPos.getZ() - 1; j <= blockPos.getZ() + 1; j++) {
                    for(int k = blockPos.getY() - 1; k <= blockPos.getY(); k++) {
                        if(target.target.test(worldGenLevel.getBlockState(new BlockPos(i, k, j)), featurePlaceContext.random())) {
                            if(worldGenLevel.getRandom().nextFloat() > 0.5f) {
                                worldGenLevel.setBlock(new BlockPos(i, k, j), target.state, 2);
                            }
                        }
                    }
                }
            }
        }

        return true;
    }
}
