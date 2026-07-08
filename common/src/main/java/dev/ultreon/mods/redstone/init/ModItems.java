package dev.ultreon.mods.redstone.init;

import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import dev.ultreon.mods.redstone.OmnixerioRedstone;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

import java.util.function.Function;

public class ModItems {
    private static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(OmnixerioRedstone.MOD_ID, Registries.ITEM);

    public static final RegistrySupplier<BlockItem> TIMER = registerBlockItem("timer", ModBlocks.TIMER, new Item.Properties());
    public static final RegistrySupplier<BlockItem> AND_GATE = registerBlockItem("and_gate", ModBlocks.AND_GATE, new Item.Properties());
    public static final RegistrySupplier<BlockItem> OR_GATE = registerBlockItem("or_gate", ModBlocks.OR_GATE, new Item.Properties());
    public static final RegistrySupplier<BlockItem> XOR_GATE = registerBlockItem("xor_gate", ModBlocks.XOR_GATE, new Item.Properties());

    private static <T extends Item> RegistrySupplier<T> register(String name, Item.Properties properties, Function<Item.Properties, T> supplier) {
        return REGISTRY.register(name, () -> supplier.apply(properties.setId(ResourceKey.create(Registries.ITEM, OmnixerioRedstone.id(name)))));
    }

    private static RegistrySupplier<BlockItem> registerBlockItem(String name, RegistrySupplier<? extends Block> block, Item.Properties properties) {
        return register(name, properties, (props) -> new BlockItem(block.get(), props));
    }

    public static void init() {
        REGISTRY.register();
    }
}
