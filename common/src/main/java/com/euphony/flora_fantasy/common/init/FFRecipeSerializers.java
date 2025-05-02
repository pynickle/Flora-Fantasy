package com.euphony.flora_fantasy.common.init;

import com.euphony.flora_fantasy.FloraFantasy;
import com.euphony.flora_fantasy.common.recipe.DurabilityShapelessRecipe;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.crafting.RecipeSerializer;

public class FFRecipeSerializers {
    public static final DeferredRegister<RecipeSerializer<?>> RECIPE_SERIALIZERS = DeferredRegister.create(FloraFantasy.MOD_ID, Registries.RECIPE_SERIALIZER);

    public static final RegistrySupplier<RecipeSerializer<DurabilityShapelessRecipe>> DURABILITY_SHAPELESS_RECIPE =
            RECIPE_SERIALIZERS.register("durability_shapeless", DurabilityShapelessRecipe.Serializer::new);
}
