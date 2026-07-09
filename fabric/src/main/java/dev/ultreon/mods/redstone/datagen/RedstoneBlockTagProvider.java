package dev.ultreon.mods.redstone.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.registries.VanillaRegistries;
import net.minecraft.world.level.block.Block;

import java.util.concurrent.CompletableFuture;

public class RedstoneBlockTagProvider extends FabricTagsProvider<Block> {
    public RedstoneBlockTagProvider(FabricPackOutput dataGenerator) {
        super(dataGenerator, Registries.BLOCK, CompletableFuture.supplyAsync(VanillaRegistries::createLookup, net.minecraft.util.Util.backgroundExecutor()));
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {

    }
}