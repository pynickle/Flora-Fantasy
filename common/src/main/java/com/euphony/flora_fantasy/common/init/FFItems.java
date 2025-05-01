package com.euphony.flora_fantasy.common.init;

import com.euphony.flora_fantasy.FloraFantasy;
import com.euphony.flora_fantasy.common.food.FFFoods;
import com.euphony.flora_fantasy.common.item.AbyssalErosionPickaxeItem;
import com.euphony.flora_fantasy.common.item.KnifeItem;
import com.euphony.flora_fantasy.common.item.NethermendSludgeItem;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.*;

public class FFItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(FloraFantasy.MOD_ID, Registries.ITEM);

    public static final RegistrySupplier<ItemNameBlockItem> LUMIN_BERRIES =
            ITEMS.register("lumin_berries", () -> new ItemNameBlockItem(FFBlocks.LUMIN_BERRY_BUSH.get(),
                    (new Item.Properties()).food(FFFoods.LUMIN_BERRIES)));

    public static final RegistrySupplier<BlockItem> IRONBANE_FERN =
            ITEMS.register("ironbane_fern", () -> new BlockItem(FFBlocks.IRONBANE_FERN.get(), new Item.Properties()));
    public static final RegistrySupplier<BlockItem> IRONBANE_FROND_FERN =
            ITEMS.register("ironbane_frond_fern", () -> new BlockItem(FFBlocks.IRONBANE_FROND_FERN.get(), new Item.Properties()));

    public static final RegistrySupplier<NethermendSludgeItem> NETHERMEND_SLUDGE_BOTTLE =
            ITEMS.register("nethermend_sludge_bottle", () -> new NethermendSludgeItem(new Item.Properties().stacksTo(16)));

    public static final RegistrySupplier<Item> NIGHT_VISION_COOKIE =
            ITEMS.register("night_vision_cookie", () -> new Item(new Item.Properties().food(FFFoods.NIGHT_VISION_COOKIE)));

    public static final RegistrySupplier<Item> IRONBANE_FROND =
            ITEMS.register("ironbane_frond", () -> new Item(new Item.Properties()));

    public static final RegistrySupplier<AbyssalErosionPickaxeItem> ABYSSAL_EROSION_PICKAXE =
            ITEMS.register("abyssal_erosion_pickaxe", () -> new AbyssalErosionPickaxeItem(Tiers.DIAMOND, new Item.Properties()));

    public static final RegistrySupplier<ItemNameBlockItem> SALTSPUD =
            ITEMS.register("saltspud", () -> new ItemNameBlockItem(FFBlocks.SALTSPUD.get(), new Item.Properties().food(FFFoods.SALTSPUD)));

    public static final RegistrySupplier<KnifeItem> BLAZE_IRON_KNIFE =
            ITEMS.register("blaze_iron_knife", () -> new KnifeItem(Tiers.IRON, (new Item.Properties()).durability(200).attributes(DiggerItem.createAttributes(Tiers.IRON, 1.5F, -2.0F))));

    public static final RegistrySupplier<Item> SALT_CRYSTAL =
            ITEMS.register("salt_crystal", () -> new Item(new Item.Properties()));

    public static final RegistrySupplier<BlockItem> SALT_CRYSTAL_LAMP =
            ITEMS.register("salt_crystal_lamp", () -> new BlockItem(FFBlocks.SALT_CRYSTAL_LAMP.get(), new Item.Properties())); // Register the BlockItem for the salt crystal lamp
}
