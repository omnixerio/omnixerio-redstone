package dev.ultreon.mods.redstone.init;

import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import dev.ultreon.mods.redstone.OmnixerioRedstone;
import dev.ultreon.mods.redstone.blocks.entity.DFlipFlopBlockEntity;
import dev.ultreon.mods.redstone.blocks.entity.JkFlipFlopBlockEntity;
import dev.ultreon.mods.redstone.blocks.entity.PulseExtenderBlockEntity;
import dev.ultreon.mods.redstone.blocks.entity.PulseGeneratorBlockEntity;
import dev.ultreon.mods.redstone.blocks.entity.SrLatchBlockEntity;
import dev.ultreon.mods.redstone.blocks.entity.SwitchBlockEntity;
import dev.ultreon.mods.redstone.blocks.entity.TimerBlockEntity;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.entity.BlockEntityType;

import java.util.Set;

public class ModBlockEntityTypes {
    private static final DeferredRegister<BlockEntityType<?>> REGISTRY = DeferredRegister.create(OmnixerioRedstone.MOD_ID, Registries.BLOCK_ENTITY_TYPE);

    public static final RegistrySupplier<BlockEntityType<TimerBlockEntity>> TIMER = REGISTRY.register("timer", () -> new BlockEntityType<>(TimerBlockEntity::new, Set.of(ModBlocks.TIMER.get())));
    public static final RegistrySupplier<BlockEntityType<SwitchBlockEntity>> SWITCH = REGISTRY.register("switch", () -> new BlockEntityType<>(SwitchBlockEntity::new, Set.of(ModBlocks.SWITCH.get())));
    public static final RegistrySupplier<BlockEntityType<SrLatchBlockEntity>> SR_LATCH = REGISTRY.register("sr_latch", () -> new BlockEntityType<>(SrLatchBlockEntity::new, Set.of(ModBlocks.SR_LATCH.get())));
    public static final RegistrySupplier<BlockEntityType<DFlipFlopBlockEntity>> D_FLIP_FLOP = REGISTRY.register("d_flip_flop", () -> new BlockEntityType<>(DFlipFlopBlockEntity::new, Set.of(ModBlocks.D_FLIP_FLOP.get())));
    public static final RegistrySupplier<BlockEntityType<JkFlipFlopBlockEntity>> JK_FLIP_FLOP = REGISTRY.register("jk_flip_flop", () -> new BlockEntityType<>(JkFlipFlopBlockEntity::new, Set.of(ModBlocks.JK_FLIP_FLOP.get())));
    public static final RegistrySupplier<BlockEntityType<PulseGeneratorBlockEntity>> PULSE_GENERATOR = REGISTRY.register("pulse_generator", () -> new BlockEntityType<>(PulseGeneratorBlockEntity::new, Set.of(ModBlocks.PULSE_GENERATOR.get())));
    public static final RegistrySupplier<BlockEntityType<PulseExtenderBlockEntity>> PULSE_EXTENDER = REGISTRY.register("pulse_extender", () -> new BlockEntityType<>(PulseExtenderBlockEntity::new, Set.of(ModBlocks.PULSE_EXTENDER.get())));

    public static void init() {
        REGISTRY.register();
    }
}
