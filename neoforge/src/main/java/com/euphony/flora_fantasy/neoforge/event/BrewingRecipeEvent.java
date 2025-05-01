package com.euphony.flora_fantasy.neoforge.event;

import com.euphony.flora_fantasy.FloraFantasy;
import com.euphony.flora_fantasy.common.init.FFItems;
import com.euphony.flora_fantasy.common.init.FFPotions;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.PotionBrewing;
import net.minecraft.world.item.alchemy.Potions;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.brewing.RegisterBrewingRecipesEvent;

@EventBusSubscriber(modid = FloraFantasy.MOD_ID)
public class BrewingRecipeEvent {
    @SubscribeEvent
    public static void init(RegisterBrewingRecipesEvent event) {
        PotionBrewing.Builder builder = event.getBuilder();

        builder.addMix(Potions.AWKWARD, FFItems.IRONBANE_FROND.get(), FFPotions.IRONFERN);
        builder.addMix(FFPotions.IRONFERN, Items.REDSTONE, FFPotions.LONG_IRONFERN);
        builder.addMix(FFPotions.IRONFERN, Items.GLOWSTONE_DUST, FFPotions.STRONG_IRONFERN);
    }
}
