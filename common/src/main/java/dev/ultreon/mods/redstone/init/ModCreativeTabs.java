package dev.ultreon.mods.redstone.init;

import dev.architectury.registry.CreativeTabRegistry;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import dev.ultreon.mods.redstone.OmnixerioRedstone;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;

public class ModCreativeTabs {
    private static final DeferredRegister<CreativeModeTab> REGISTRY = DeferredRegister.create(OmnixerioRedstone.MOD_ID, Registries.CREATIVE_MODE_TAB);

    public static final RegistrySupplier<CreativeModeTab> REDSTONE_TAB = REGISTRY.register("redstone", () -> CreativeTabRegistry.create(it -> {
        it.icon(() -> ModItems.TIMER.get().getDefaultInstance());
        it.displayItems(ModCreativeTabs::creativeTabItems);
        it.title(Component.literal("Omnixerio Redstone"));
    }));

    private static void creativeTabItems(CreativeModeTab.ItemDisplayParameters parameters, CreativeModeTab.Output output) {
        output.accept(ModItems.TIMER.get());
        output.accept(ModItems.AND_GATE.get());
        output.accept(ModItems.OR_GATE.get());
        output.accept(ModItems.XOR_GATE.get());
    }

    public static void init() {
        REGISTRY.register();
    }
}
