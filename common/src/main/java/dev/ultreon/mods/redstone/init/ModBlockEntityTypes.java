package dev.ultreon.mods.redstone.init;

import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import dev.ultreon.mods.redstone.OmnixerioRedstone;
import dev.ultreon.mods.redstone.blocks.entity.TimerBlockEntity;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.entity.BlockEntityType;

import java.util.Set;

public class ModBlockEntityTypes {
    private static final DeferredRegister<BlockEntityType<?>> REGISTRY = DeferredRegister.create(OmnixerioRedstone.MOD_ID, Registries.BLOCK_ENTITY_TYPE);

    public static final RegistrySupplier<BlockEntityType<TimerBlockEntity>> TIMER = REGISTRY.register("timer", () -> new BlockEntityType<>(TimerBlockEntity::new, Set.of(ModBlocks.TIMER.get()))) ;

    public static void init() {
        REGISTRY.register();
    }
}
