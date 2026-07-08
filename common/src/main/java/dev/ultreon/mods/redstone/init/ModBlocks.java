package dev.ultreon.mods.redstone.init;

import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import dev.ultreon.mods.redstone.OmnixerioRedstone;
import dev.ultreon.mods.redstone.blocks.TimerBlock;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;

import java.util.function.Function;

public class ModBlocks {
    private static final DeferredRegister<Block> REGISTRY = DeferredRegister.create(OmnixerioRedstone.MOD_ID, Registries.BLOCK);

    public static final RegistrySupplier<TimerBlock> TIMER = register("timer", BlockBehaviour.Properties.ofFullCopy(Blocks.REPEATER), (properties) -> new TimerBlock(properties));

    private static <T extends Block> RegistrySupplier<T> register(String name, BlockBehaviour.Properties properties, Function<BlockBehaviour.Properties, T> factory) {
        return REGISTRY.register(name, () -> factory.apply(properties.setId(ResourceKey.create(Registries.BLOCK, OmnixerioRedstone.id(name)))));
    }

    public static void init() {
        REGISTRY.register();
    }
}
