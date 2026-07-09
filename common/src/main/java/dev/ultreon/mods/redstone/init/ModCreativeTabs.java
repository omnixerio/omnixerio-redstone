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
        output.accept(ModItems.SWITCH.get());
        output.accept(ModItems.NAND_GATE.get());
        output.accept(ModItems.WHITE_REDSTONE_LAMP.get());
        output.accept(ModItems.ORANGE_REDSTONE_LAMP.get());
        output.accept(ModItems.MAGENTA_REDSTONE_LAMP.get());
        output.accept(ModItems.LIGHT_BLUE_REDSTONE_LAMP.get());
        output.accept(ModItems.YELLOW_REDSTONE_LAMP.get());
        output.accept(ModItems.LIME_REDSTONE_LAMP.get());
        output.accept(ModItems.PINK_REDSTONE_LAMP.get());
        output.accept(ModItems.GRAY_REDSTONE_LAMP.get());
        output.accept(ModItems.LIGHT_GRAY_REDSTONE_LAMP.get());
        output.accept(ModItems.CYAN_REDSTONE_LAMP.get());
        output.accept(ModItems.PURPLE_REDSTONE_LAMP.get());
        output.accept(ModItems.BLUE_REDSTONE_LAMP.get());
        output.accept(ModItems.BROWN_REDSTONE_LAMP.get());
        output.accept(ModItems.GREEN_REDSTONE_LAMP.get());
        output.accept(ModItems.RED_REDSTONE_LAMP.get());
        output.accept(ModItems.BLACK_REDSTONE_LAMP.get());
    }

    public static void init() {
        REGISTRY.register();
    }
}
