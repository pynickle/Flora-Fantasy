package com.euphony.flora_fantasy.common.feature.config;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;

public class GrowthConfiguration implements FeatureConfiguration {
    public static final Codec<GrowthConfiguration> CODEC = RecordCodecBuilder.create(
            (instance) ->
                    instance.group(
                            GrowthConfiguration.TargetBlockState.CODEC
                                    .fieldOf("target")
                                    .forGetter((arg) -> arg.targetState),
                            GrowthConfiguration.TargetBlockState.CODEC
                                    .fieldOf("growth")
                                    .forGetter((arg) -> arg.growthState),
                            GrowthConfiguration.TargetBlockState.CODEC
                                    .fieldOf("base")
                                    .forGetter((arg) -> arg.baseState)
                    ).apply(instance, GrowthConfiguration::new));
    public final TargetBlockState targetState;
    public final TargetBlockState growthState;
    public final TargetBlockState baseState;

    public GrowthConfiguration(TargetBlockState list1, TargetBlockState list2, TargetBlockState list3) {
        this.targetState = list1;
        this.growthState = list2;
        this.baseState = list3;
    }

    public static class TargetBlockState {
        public static final Codec<TargetBlockState> CODEC = RecordCodecBuilder.create((instance) -> instance.group(RuleTest.CODEC.fieldOf("target").forGetter((arg) -> arg.target), BlockState.CODEC.fieldOf("state").forGetter((arg) -> arg.state)).apply(instance, GrowthConfiguration.TargetBlockState::new));
        public final RuleTest target;
        public final BlockState state;

        TargetBlockState(RuleTest arg, BlockState arg2) {
            this.target = arg;
            this.state = arg2;
        }
    }
}
