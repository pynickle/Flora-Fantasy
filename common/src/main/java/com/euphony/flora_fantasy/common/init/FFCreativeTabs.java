package com.euphony.flora_fantasy.common.init;

import com.euphony.flora_fantasy.FloraFantasy;
import dev.architectury.registry.registries.DeferredRegister;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class FFCreativeTabs {
    public static final DeferredRegister<CreativeModeTab> TABS = DeferredRegister.create(FloraFantasy.MOD_ID, Registries.CREATIVE_MODE_TAB);

    static {
        TABS.register(
                "items",
                () ->
                        CreativeModeTab.builder(CreativeModeTab.Row.TOP, 1)
                                .title(Component.translatable("itemGroup.flora_fantasy.items"))
                                .icon(() -> new ItemStack(FFItems.LUMIN_BERRIES.get()))
                                .displayItems(
                                        (parameters, output) -> {
                                            output.accept(FFItems.LUMIN_BERRIES.get());
                                            output.accept(FFItems.NETHERMEND_SLUDGE_BOTTLE.get());
                                            output.accept(FFItems.NIGHT_VISION_COOKIE.get());
                                            output.accept(FFItems.IRONBANE_FROND.get());
                                            output.accept(FFItems.ABYSSAL_EROSION_PICKAXE.get());
                                            output.accept(FFItems.SALTSPUD.get());
                                            output.accept(FFItems.BLAZE_IRON_KNIFE.get());
                                            output.accept(FFItems.SALT_CRYSTAL.get());
                                        })
                                .build());
        TABS.register(
                "blocks",
                () ->
                        CreativeModeTab.builder(CreativeModeTab.Row.TOP, 1)
                                .title(Component.translatable("itemGroup.flora_fantasy.blocks"))
                                .icon(() -> new ItemStack(FFItems.IRONBANE_FERN.get()))
                                .displayItems(
                                        (parameters, output) -> {
                                            output.accept(FFItems.IRONBANE_FERN.get());
                                            output.accept(FFItems.IRONBANE_FROND_FERN.get());
                                            output.accept(FFItems.SALT_CRYSTAL_LAMP.get());
                                        })
                                .build());
    }
}
