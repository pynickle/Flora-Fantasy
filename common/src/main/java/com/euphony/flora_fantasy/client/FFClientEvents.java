package com.euphony.flora_fantasy.client;

import com.euphony.flora_fantasy.client.event.RenderTypeEvent;
import dev.architectury.event.events.client.ClientLifecycleEvent;

public class FFClientEvents {
    public static void init() {
        ClientLifecycleEvent.CLIENT_SETUP.register(RenderTypeEvent::registerRenderType);
    }
}
