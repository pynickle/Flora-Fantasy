package com.euphony.flora_fantasy.client.event;

import com.euphony.flora_fantasy.common.init.FFBlocks;
import dev.architectury.registry.client.rendering.RenderTypeRegistry;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderType;

public class RenderTypeEvent {
    public static void registerRenderType(Minecraft minecraft) {
        RenderTypeRegistry.register(RenderType.cutout(), FFBlocks.LUMIN_BERRY_BUSH.get(),
                FFBlocks.IRONBANE_FERN.get(), FFBlocks.IRONBANE_FROND_FERN.get(),
                FFBlocks.SALTSPUD.get());
    }
}
