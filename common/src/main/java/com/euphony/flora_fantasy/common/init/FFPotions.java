package com.euphony.flora_fantasy.common.init;

import com.euphony.flora_fantasy.FloraFantasy;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.alchemy.Potion;

public class FFPotions {
    public static final DeferredRegister<Potion> POTIONS =
            DeferredRegister.create(FloraFantasy.MOD_ID, Registries.POTION);


    public static final RegistrySupplier<Potion> IRONFERN =
            POTIONS.register("ironfern", () -> new Potion(
                    new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 800, 1),
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 800, 0)
            ));

    public static final RegistrySupplier<Potion> LONG_IRONFERN =
            POTIONS.register("long_ironfern", () -> new Potion(
                    new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 1600, 1),
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 1600, 0)
            ));

    public static final RegistrySupplier<Potion> STRONG_IRONFERN =
            POTIONS.register("strong_ironfern", () -> new Potion(
                    new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 400, 2),
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 400, 1)
            ));
}
