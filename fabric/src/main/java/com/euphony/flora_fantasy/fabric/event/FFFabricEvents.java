package com.euphony.flora_fantasy.fabric.event;

import com.euphony.flora_fantasy.fabric.event.event.BrewingRecipeEvent;
import net.fabricmc.fabric.api.registry.FabricBrewingRecipeRegistryBuilder;

public class FFFabricEvents {
    public static void init() {
        FabricBrewingRecipeRegistryBuilder.BUILD.register(BrewingRecipeEvent::registerPotionsRecipes);
    }
}
