package com.euphony.flora_fantasy.utils;

import com.euphony.flora_fantasy.FloraFantasy;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;

public class Utils {
    public static <T> ResourceKey<T> key(ResourceKey<? extends Registry<T>> registry, String path) {
        return ResourceKey.create(registry, prefix(path));
    }

    public static ResourceLocation id(String path, String... args) {
        return ResourceLocation.fromNamespaceAndPath(FloraFantasy.MOD_ID, String.format(path, (Object[]) args));
    }

    public static ResourceLocation prefix(String path) {
        return ResourceLocation.fromNamespaceAndPath(FloraFantasy.MOD_ID, path);
    }
}
