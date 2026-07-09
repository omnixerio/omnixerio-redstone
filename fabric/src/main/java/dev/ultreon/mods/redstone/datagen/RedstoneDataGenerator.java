package dev.ultreon.mods.redstone.datagen;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.minecraft.core.HolderLookup;

import java.util.concurrent.CompletableFuture;

public class RedstoneDataGenerator implements DataGeneratorEntrypoint {
    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();
        CompletableFuture<HolderLookup.Provider> registries = fabricDataGenerator.getRegistries();
        pack.addProvider((FabricPackOutput output) -> new RedstoneRecipeProvider(output, registries));
        pack.addProvider((FabricPackOutput output) -> new RedstoneAdvancementsProvider(output, registries));
        pack.addProvider((FabricPackOutput output) -> new RedstoneBlockLootTableGenerator(output, registries));
        pack.addProvider(RedstoneBlockTagProvider::new);
        pack.addProvider(RedstoneItemTagProvider::new);
    }
}