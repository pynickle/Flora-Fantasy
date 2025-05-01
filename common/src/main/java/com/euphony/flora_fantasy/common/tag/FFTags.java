package com.euphony.flora_fantasy.common.tag;

import com.euphony.flora_fantasy.utils.Utils;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class FFTags {
    public static final TagKey<Item> NETHERMEND_SLUDGE_TOOLS = createItemTag("nethermend_sludge_tools");

    public static final TagKey<Block> IRONBANE_FERN_CAN_SURVIVE_ON = createBlockTag("ironbane_fern_can_survive_on");

    public static final TagKey<Block> MINEABLE_WITH_KNIFE = createBlockTag("mineable/knife");

    public static TagKey<Block> createBlockTag(String tagName) {
        return TagKey.create(Registries.BLOCK, Utils.prefix(tagName));
    }

    public static TagKey<Item> createItemTag(String tagName) {
        return TagKey.create(Registries.ITEM, Utils.prefix(tagName));
    }
}
