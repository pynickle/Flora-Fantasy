package com.euphony.flora_fantasy.common.food;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class FFFoods {
    public static final FoodProperties LUMIN_BERRIES;
    public static final FoodProperties NIGHT_VISION_COOKIE;
    public static final FoodProperties SALTSPUD;

    static {
        LUMIN_BERRIES = (new FoodProperties.Builder())
                .nutrition(2)
                .saturationModifier(0.1F)
                .effect(new MobEffectInstance(MobEffects.GLOWING, 60, 0), 1.0F)
                .build();
        NIGHT_VISION_COOKIE = (new FoodProperties.Builder())
                .nutrition(2)
                .saturationModifier(0.4F)
                .effect(new MobEffectInstance(MobEffects.NIGHT_VISION, 600, 0), 1.0F)
                .build();
        SALTSPUD = (new FoodProperties.Builder())
                .nutrition(2)
                .saturationModifier(0.4F)
                .effect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 200, 0), 1.0F)
                .build();
    }

}
