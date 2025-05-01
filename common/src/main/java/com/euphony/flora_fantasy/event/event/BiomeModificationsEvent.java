package com.euphony.flora_fantasy.event.event;

import com.euphony.flora_fantasy.utils.Utils;
import dev.architectury.registry.level.biome.BiomeModifications;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

public class BiomeModificationsEvent {
    public static final ResourceKey<PlacedFeature> LUMIN_BERRY_BUSH = Utils.key(Registries.PLACED_FEATURE, "lumin_berry_bush");
    public static final ResourceKey<PlacedFeature> IRONBANE_FERN = Utils.key(Registries.PLACED_FEATURE, "ironbane_fern");
    public static final ResourceKey<PlacedFeature> SALTSPUD = Utils.key(Registries.PLACED_FEATURE, "saltspud");

    public static void init() {
        BiomeModifications.addProperties(
                biomeContext -> biomeContext.hasTag(BiomeTags.IS_OVERWORLD),
                (biomeContext, mutable) -> {
                    mutable.getGenerationProperties().addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, LUMIN_BERRY_BUSH);
                }
        );
        BiomeModifications.addProperties(
                biomeContext -> biomeContext.hasTag(BiomeTags.IS_OVERWORLD),
                (biomeContext, mutable) -> {
                    mutable.getGenerationProperties().addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, IRONBANE_FERN);
                }
        );
        BiomeModifications.addProperties(
                biomeContext -> biomeContext.getKey().get().getPath().equals("desert"),
                (biomeContext, mutable) -> {
                    mutable.getGenerationProperties().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, SALTSPUD);
                }
        );
    }
}
