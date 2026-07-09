package dev.ultreon.mods.redstone.init;

import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import dev.ultreon.mods.redstone.OmnixerioRedstone;
import dev.ultreon.mods.redstone.blocks.AndGateBlock;
import dev.ultreon.mods.redstone.blocks.ColoredRedstoneLampBlock;
import dev.ultreon.mods.redstone.blocks.DFlipFlopBlock;
import dev.ultreon.mods.redstone.blocks.JkFlipFlopBlock;
import dev.ultreon.mods.redstone.blocks.NandGateBlock;
import dev.ultreon.mods.redstone.blocks.NorGateBlock;
import dev.ultreon.mods.redstone.blocks.NotGateBlock;
import dev.ultreon.mods.redstone.blocks.OrGateBlock;
import dev.ultreon.mods.redstone.blocks.PulseExtenderBlock;
import dev.ultreon.mods.redstone.blocks.PulseGeneratorBlock;
import dev.ultreon.mods.redstone.blocks.SrLatchBlock;
import dev.ultreon.mods.redstone.blocks.SwitchBlock;
import dev.ultreon.mods.redstone.blocks.TimerBlock;
import dev.ultreon.mods.redstone.blocks.XnorGateBlock;
import dev.ultreon.mods.redstone.blocks.XorGateBlock;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;

import java.util.function.Function;

public class ModBlocks {
    private static final DeferredRegister<Block> REGISTRY = DeferredRegister.create(OmnixerioRedstone.MOD_ID, Registries.BLOCK);

    public static final RegistrySupplier<TimerBlock> TIMER = register("timer", BlockBehaviour.Properties.ofFullCopy(Blocks.REPEATER), (properties) -> new TimerBlock(properties));
    public static final RegistrySupplier<AndGateBlock> AND_GATE = register("and_gate", BlockBehaviour.Properties.ofFullCopy(Blocks.REPEATER), AndGateBlock::new);
    public static final RegistrySupplier<OrGateBlock> OR_GATE = register("or_gate", BlockBehaviour.Properties.ofFullCopy(Blocks.REPEATER), OrGateBlock::new);
    public static final RegistrySupplier<XorGateBlock> XOR_GATE = register("xor_gate", BlockBehaviour.Properties.ofFullCopy(Blocks.REPEATER), XorGateBlock::new);
    public static final RegistrySupplier<SwitchBlock> SWITCH = register("switch", BlockBehaviour.Properties.ofFullCopy(Blocks.REPEATER), SwitchBlock::new);
    public static final RegistrySupplier<NandGateBlock> NAND_GATE = register("nand_gate", BlockBehaviour.Properties.ofFullCopy(Blocks.REPEATER), NandGateBlock::new);
    public static final RegistrySupplier<SrLatchBlock> SR_LATCH = register("sr_latch", BlockBehaviour.Properties.ofFullCopy(Blocks.REPEATER), SrLatchBlock::new);
    public static final RegistrySupplier<DFlipFlopBlock> D_FLIP_FLOP = register("d_flip_flop", BlockBehaviour.Properties.ofFullCopy(Blocks.REPEATER), DFlipFlopBlock::new);
    public static final RegistrySupplier<JkFlipFlopBlock> JK_FLIP_FLOP = register("jk_flip_flop", BlockBehaviour.Properties.ofFullCopy(Blocks.REPEATER), JkFlipFlopBlock::new);
    public static final RegistrySupplier<NotGateBlock> NOT_GATE = register("not_gate", BlockBehaviour.Properties.ofFullCopy(Blocks.REPEATER), NotGateBlock::new);
    public static final RegistrySupplier<NorGateBlock> NOR_GATE = register("nor_gate", BlockBehaviour.Properties.ofFullCopy(Blocks.REPEATER), NorGateBlock::new);
    public static final RegistrySupplier<XnorGateBlock> XNOR_GATE = register("xnor_gate", BlockBehaviour.Properties.ofFullCopy(Blocks.REPEATER), XnorGateBlock::new);
    public static final RegistrySupplier<PulseGeneratorBlock> PULSE_GENERATOR = register("pulse_generator", BlockBehaviour.Properties.ofFullCopy(Blocks.REPEATER), PulseGeneratorBlock::new);
    public static final RegistrySupplier<PulseExtenderBlock> PULSE_EXTENDER = register("pulse_extender", BlockBehaviour.Properties.ofFullCopy(Blocks.REPEATER), PulseExtenderBlock::new);
    public static final RegistrySupplier<ColoredRedstoneLampBlock> WHITE_REDSTONE_LAMP = register("white_redstone_lamp", BlockBehaviour.Properties.ofFullCopy(Blocks.REDSTONE_LAMP), ColoredRedstoneLampBlock::new);
    public static final RegistrySupplier<ColoredRedstoneLampBlock> ORANGE_REDSTONE_LAMP = register("orange_redstone_lamp", BlockBehaviour.Properties.ofFullCopy(Blocks.REDSTONE_LAMP), ColoredRedstoneLampBlock::new);
    public static final RegistrySupplier<ColoredRedstoneLampBlock> MAGENTA_REDSTONE_LAMP = register("magenta_redstone_lamp", BlockBehaviour.Properties.ofFullCopy(Blocks.REDSTONE_LAMP), ColoredRedstoneLampBlock::new);
    public static final RegistrySupplier<ColoredRedstoneLampBlock> LIGHT_BLUE_REDSTONE_LAMP = register("light_blue_redstone_lamp", BlockBehaviour.Properties.ofFullCopy(Blocks.REDSTONE_LAMP), ColoredRedstoneLampBlock::new);
    public static final RegistrySupplier<ColoredRedstoneLampBlock> YELLOW_REDSTONE_LAMP = register("yellow_redstone_lamp", BlockBehaviour.Properties.ofFullCopy(Blocks.REDSTONE_LAMP), ColoredRedstoneLampBlock::new);
    public static final RegistrySupplier<ColoredRedstoneLampBlock> LIME_REDSTONE_LAMP = register("lime_redstone_lamp", BlockBehaviour.Properties.ofFullCopy(Blocks.REDSTONE_LAMP), ColoredRedstoneLampBlock::new);
    public static final RegistrySupplier<ColoredRedstoneLampBlock> PINK_REDSTONE_LAMP = register("pink_redstone_lamp", BlockBehaviour.Properties.ofFullCopy(Blocks.REDSTONE_LAMP), ColoredRedstoneLampBlock::new);
    public static final RegistrySupplier<ColoredRedstoneLampBlock> GRAY_REDSTONE_LAMP = register("gray_redstone_lamp", BlockBehaviour.Properties.ofFullCopy(Blocks.REDSTONE_LAMP), ColoredRedstoneLampBlock::new);
    public static final RegistrySupplier<ColoredRedstoneLampBlock> LIGHT_GRAY_REDSTONE_LAMP = register("light_gray_redstone_lamp", BlockBehaviour.Properties.ofFullCopy(Blocks.REDSTONE_LAMP), ColoredRedstoneLampBlock::new);
    public static final RegistrySupplier<ColoredRedstoneLampBlock> CYAN_REDSTONE_LAMP = register("cyan_redstone_lamp", BlockBehaviour.Properties.ofFullCopy(Blocks.REDSTONE_LAMP), ColoredRedstoneLampBlock::new);
    public static final RegistrySupplier<ColoredRedstoneLampBlock> PURPLE_REDSTONE_LAMP = register("purple_redstone_lamp", BlockBehaviour.Properties.ofFullCopy(Blocks.REDSTONE_LAMP), ColoredRedstoneLampBlock::new);
    public static final RegistrySupplier<ColoredRedstoneLampBlock> BLUE_REDSTONE_LAMP = register("blue_redstone_lamp", BlockBehaviour.Properties.ofFullCopy(Blocks.REDSTONE_LAMP), ColoredRedstoneLampBlock::new);
    public static final RegistrySupplier<ColoredRedstoneLampBlock> BROWN_REDSTONE_LAMP = register("brown_redstone_lamp", BlockBehaviour.Properties.ofFullCopy(Blocks.REDSTONE_LAMP), ColoredRedstoneLampBlock::new);
    public static final RegistrySupplier<ColoredRedstoneLampBlock> GREEN_REDSTONE_LAMP = register("green_redstone_lamp", BlockBehaviour.Properties.ofFullCopy(Blocks.REDSTONE_LAMP), ColoredRedstoneLampBlock::new);
    public static final RegistrySupplier<ColoredRedstoneLampBlock> RED_REDSTONE_LAMP = register("red_redstone_lamp", BlockBehaviour.Properties.ofFullCopy(Blocks.REDSTONE_LAMP), ColoredRedstoneLampBlock::new);
    public static final RegistrySupplier<ColoredRedstoneLampBlock> BLACK_REDSTONE_LAMP = register("black_redstone_lamp", BlockBehaviour.Properties.ofFullCopy(Blocks.REDSTONE_LAMP), ColoredRedstoneLampBlock::new);

    private static <T extends Block> RegistrySupplier<T> register(String name, BlockBehaviour.Properties properties, Function<BlockBehaviour.Properties, T> factory) {
        return REGISTRY.register(name, () -> factory.apply(properties.setId(ResourceKey.create(Registries.BLOCK, OmnixerioRedstone.id(name)))));
    }

    public static void init() {
        REGISTRY.register();
    }
}
