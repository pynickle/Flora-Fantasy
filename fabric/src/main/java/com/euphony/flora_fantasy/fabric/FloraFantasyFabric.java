package com.euphony.flora_fantasy.fabric;

import com.euphony.flora_fantasy.FloraFantasy;
import com.euphony.flora_fantasy.fabric.event.FFFabricEvents;
import net.fabricmc.api.ModInitializer;

public final class FloraFantasyFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        FloraFantasy.init();

        FFFabricEvents.init();
    }
}
