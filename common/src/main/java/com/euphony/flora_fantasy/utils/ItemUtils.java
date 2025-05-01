package com.euphony.flora_fantasy.utils;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;

public class ItemUtils {
    public static MutableComponent createTooltip(String key) {
        return Component.translatable(key).withStyle(ChatFormatting.GRAY);
    }

    public static MutableComponent createTooltip(String key, Object... args) {
        return Component.translatable(key, args).withStyle(ChatFormatting.GRAY);
    }
}
