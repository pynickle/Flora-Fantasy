package com.euphony.flora_fantasy.event;

import com.euphony.flora_fantasy.event.event.BiomeModificationsEvent;
import dev.architectury.event.events.common.LifecycleEvent;

public class FFEvents {
    public static void init() {
        LifecycleEvent.SETUP.register(BiomeModificationsEvent::init);
    }
}
