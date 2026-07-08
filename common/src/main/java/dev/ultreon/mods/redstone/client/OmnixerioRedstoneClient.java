package dev.ultreon.mods.redstone.client;

import dev.architectury.event.events.client.ClientLifecycleEvent;
import dev.architectury.registry.client.rendering.BlockEntityRendererRegistry;
import dev.ultreon.mods.redstone.client.blockentity.renderer.TimerRenderer;
import dev.ultreon.mods.redstone.init.ModBlockEntityTypes;

public class OmnixerioRedstoneClient {
    public static void init() {
        ClientLifecycleEvent.CLIENT_STARTED.register(instance -> {
            BlockEntityRendererRegistry.register(ModBlockEntityTypes.TIMER.get(), context -> new TimerRenderer(context));
        });
    }
}
