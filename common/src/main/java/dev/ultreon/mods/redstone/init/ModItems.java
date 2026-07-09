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
    public static final RegistrySupplier<BlockItem> SWITCH = registerBlockItem("switch", ModBlocks.SWITCH, new Item.Properties());
    public static final RegistrySupplier<BlockItem> NAND_GATE = registerBlockItem("nand_gate", ModBlocks.NAND_GATE, new Item.Properties());
    public static final RegistrySupplier<BlockItem> WHITE_REDSTONE_LAMP = registerBlockItem("white_redstone_lamp", ModBlocks.WHITE_REDSTONE_LAMP, new Item.Properties());
    public static final RegistrySupplier<BlockItem> ORANGE_REDSTONE_LAMP = registerBlockItem("orange_redstone_lamp", ModBlocks.ORANGE_REDSTONE_LAMP, new Item.Properties());
    public static final RegistrySupplier<BlockItem> MAGENTA_REDSTONE_LAMP = registerBlockItem("magenta_redstone_lamp", ModBlocks.MAGENTA_REDSTONE_LAMP, new Item.Properties());
    public static final RegistrySupplier<BlockItem> LIGHT_BLUE_REDSTONE_LAMP = registerBlockItem("light_blue_redstone_lamp", ModBlocks.LIGHT_BLUE_REDSTONE_LAMP, new Item.Properties());
    public static final RegistrySupplier<BlockItem> YELLOW_REDSTONE_LAMP = registerBlockItem("yellow_redstone_lamp", ModBlocks.YELLOW_REDSTONE_LAMP, new Item.Properties());
    public static final RegistrySupplier<BlockItem> LIME_REDSTONE_LAMP = registerBlockItem("lime_redstone_lamp", ModBlocks.LIME_REDSTONE_LAMP, new Item.Properties());
    public static final RegistrySupplier<BlockItem> PINK_REDSTONE_LAMP = registerBlockItem("pink_redstone_lamp", ModBlocks.PINK_REDSTONE_LAMP, new Item.Properties());
    public static final RegistrySupplier<BlockItem> GRAY_REDSTONE_LAMP = registerBlockItem("gray_redstone_lamp", ModBlocks.GRAY_REDSTONE_LAMP, new Item.Properties());
    public static final RegistrySupplier<BlockItem> LIGHT_GRAY_REDSTONE_LAMP = registerBlockItem("light_gray_redstone_lamp", ModBlocks.LIGHT_GRAY_REDSTONE_LAMP, new Item.Properties());
    public static final RegistrySupplier<BlockItem> CYAN_REDSTONE_LAMP = registerBlockItem("cyan_redstone_lamp", ModBlocks.CYAN_REDSTONE_LAMP, new Item.Properties());
    public static final RegistrySupplier<BlockItem> PURPLE_REDSTONE_LAMP = registerBlockItem("purple_redstone_lamp", ModBlocks.PURPLE_REDSTONE_LAMP, new Item.Properties());
    public static final RegistrySupplier<BlockItem> BLUE_REDSTONE_LAMP = registerBlockItem("blue_redstone_lamp", ModBlocks.BLUE_REDSTONE_LAMP, new Item.Properties());
    public static final RegistrySupplier<BlockItem> BROWN_REDSTONE_LAMP = registerBlockItem("brown_redstone_lamp", ModBlocks.BROWN_REDSTONE_LAMP, new Item.Properties());
    public static final RegistrySupplier<BlockItem> GREEN_REDSTONE_LAMP = registerBlockItem("green_redstone_lamp", ModBlocks.GREEN_REDSTONE_LAMP, new Item.Properties());
    public static final RegistrySupplier<BlockItem> RED_REDSTONE_LAMP = registerBlockItem("red_redstone_lamp", ModBlocks.RED_REDSTONE_LAMP, new Item.Properties());
    public static final RegistrySupplier<BlockItem> BLACK_REDSTONE_LAMP = registerBlockItem("black_redstone_lamp", ModBlocks.BLACK_REDSTONE_LAMP, new Item.Properties());

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
