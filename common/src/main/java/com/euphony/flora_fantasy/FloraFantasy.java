package com.euphony.flora_fantasy;

import com.euphony.flora_fantasy.client.FFClientEvents;
import com.euphony.flora_fantasy.common.init.*;
import com.euphony.flora_fantasy.event.FFEvents;

public final class FloraFantasy {
    public static final String MOD_ID = "flora_fantasy";

    public static void init() {
        FFDataComponents.DATA_COMPONENT_TYPES.register();

        FFBlocks.BLOCKS.register();
        FFItems.ITEMS.register();
        FFPotions.POTIONS.register();

        FFFeatures.FEATURES.register();
        FFCreativeTabs.TABS.register();

        FFClientEvents.init();
        FFEvents.init();
    }
}
