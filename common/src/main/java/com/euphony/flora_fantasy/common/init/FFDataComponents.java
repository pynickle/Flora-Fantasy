package com.euphony.flora_fantasy.common.init;

import com.euphony.flora_fantasy.FloraFantasy;
import com.mojang.serialization.Codec;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.codec.ByteBufCodecs;

public class FFDataComponents {
    public static final DeferredRegister<DataComponentType<?>> DATA_COMPONENT_TYPES =
            DeferredRegister.create(FloraFantasy.MOD_ID, Registries.DATA_COMPONENT_TYPE);

    public static final RegistrySupplier<DataComponentType<Integer>> NETHERMEND_REMAINING =
            DATA_COMPONENT_TYPES.register("nethermend_remaining", () -> DataComponentType.<Integer>builder().persistent(Codec.INT).networkSynchronized(ByteBufCodecs.INT).build());

    public static final RegistrySupplier<DataComponentType<Integer>> EROSION_ENERGY =
            DATA_COMPONENT_TYPES.register("erosion_energy", () -> DataComponentType.<Integer>builder().persistent(Codec.INT).networkSynchronized(ByteBufCodecs.INT).build());
}
