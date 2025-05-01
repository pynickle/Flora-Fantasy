package com.euphony.flora_fantasy.integration.jei;

import com.euphony.flora_fantasy.utils.Utils;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.recipe.vanilla.IVanillaRecipeFactory;
import mezz.jei.api.registration.IRecipeRegistration;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

@JeiPlugin
public class JEI implements IModPlugin {
    @Override
    public @NotNull ResourceLocation getPluginUid() {
        return Utils.prefix("jei_plugin");
    }

    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        IVanillaRecipeFactory factory = registration.getVanillaRecipeFactory();
    }
}
