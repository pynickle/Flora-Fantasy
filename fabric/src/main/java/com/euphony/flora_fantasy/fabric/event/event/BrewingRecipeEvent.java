package com.euphony.flora_fantasy.fabric.event.event;

import com.euphony.flora_fantasy.common.init.FFItems;
import com.euphony.flora_fantasy.common.init.FFPotions;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.PotionBrewing;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.item.crafting.Ingredient;

public class BrewingRecipeEvent {
    public static void registerPotionsRecipes(PotionBrewing.Builder builder){
        builder.registerPotionRecipe(Potions.AWKWARD, Ingredient.of(FFItems.IRONBANE_FROND.get()), FFPotions.IRONFERN);
        builder.registerPotionRecipe(FFPotions.IRONFERN, Ingredient.of(Items.REDSTONE), FFPotions.LONG_IRONFERN);
        builder.registerPotionRecipe(FFPotions.IRONFERN, Ingredient.of(Items.GLOWSTONE_DUST), FFPotions.STRONG_IRONFERN);
    }
}
