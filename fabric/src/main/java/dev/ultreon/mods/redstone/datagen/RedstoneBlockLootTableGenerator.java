package dev.ultreon.mods.redstone.datagen;

import dev.ultreon.mods.redstone.init.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootSubProvider;
import net.minecraft.core.HolderLookup;

import java.util.concurrent.CompletableFuture;

public class RedstoneBlockLootTableGenerator extends FabricBlockLootSubProvider {
    public RedstoneBlockLootTableGenerator(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registryLookup) {
        super(output, registryLookup);
    }

    @Override
    public void generate() {
        dropSelf(ModBlocks.SWITCH.get());
        dropSelf(ModBlocks.TIMER.get());
        dropSelf(ModBlocks.AND_GATE.get());
        dropSelf(ModBlocks.NAND_GATE.get());
        dropSelf(ModBlocks.OR_GATE.get());
        dropSelf(ModBlocks.NOR_GATE.get());
        dropSelf(ModBlocks.XOR_GATE.get());
        dropSelf(ModBlocks.XNOR_GATE.get());
        dropSelf(ModBlocks.D_FLIP_FLOP.get());
        dropSelf(ModBlocks.JK_FLIP_FLOP.get());
        dropSelf(ModBlocks.SR_LATCH.get());
        dropSelf(ModBlocks.PULSE_GENERATOR.get());
        dropSelf(ModBlocks.PULSE_EXTENDER.get());

        dropSelf(ModBlocks.WHITE_REDSTONE_LAMP.get());
        dropSelf(ModBlocks.ORANGE_REDSTONE_LAMP.get());
        dropSelf(ModBlocks.MAGENTA_REDSTONE_LAMP.get());
        dropSelf(ModBlocks.LIGHT_BLUE_REDSTONE_LAMP.get());
        dropSelf(ModBlocks.YELLOW_REDSTONE_LAMP.get());
        dropSelf(ModBlocks.LIME_REDSTONE_LAMP.get());
        dropSelf(ModBlocks.PINK_REDSTONE_LAMP.get());
        dropSelf(ModBlocks.GRAY_REDSTONE_LAMP.get());
        dropSelf(ModBlocks.LIGHT_GRAY_REDSTONE_LAMP.get());
        dropSelf(ModBlocks.CYAN_REDSTONE_LAMP.get());
        dropSelf(ModBlocks.PURPLE_REDSTONE_LAMP.get());
        dropSelf(ModBlocks.BLUE_REDSTONE_LAMP.get());
        dropSelf(ModBlocks.BROWN_REDSTONE_LAMP.get());
        dropSelf(ModBlocks.GREEN_REDSTONE_LAMP.get());
        dropSelf(ModBlocks.RED_REDSTONE_LAMP.get());
        dropSelf(ModBlocks.BLACK_REDSTONE_LAMP.get());
    }
}