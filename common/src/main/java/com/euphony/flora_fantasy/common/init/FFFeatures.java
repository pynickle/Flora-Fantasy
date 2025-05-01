package com.euphony.flora_fantasy.common.init;

import com.euphony.flora_fantasy.FloraFantasy;
import com.euphony.flora_fantasy.common.feature.GrowthFeature;
import com.euphony.flora_fantasy.common.feature.config.GrowthConfiguration;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.feature.Feature;

public class FFFeatures {
    public static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(FloraFantasy.MOD_ID, Registries.FEATURE);

    public static final RegistrySupplier<Feature<?>> GROWTH = FEATURES.register("growth", () -> new GrowthFeature(GrowthConfiguration.CODEC));
}
