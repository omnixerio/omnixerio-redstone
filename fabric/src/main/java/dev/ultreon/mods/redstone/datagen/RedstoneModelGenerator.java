package dev.ultreon.mods.redstone.datagen;

import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import org.jspecify.annotations.NonNull;

public class RedstoneModelGenerator extends FabricModelProvider {

    private final FabricPackOutput dataOutput;

    public RedstoneModelGenerator(FabricPackOutput dataOutput) {
        super(dataOutput);
        this.dataOutput = dataOutput;
    }

    @Override
    public void generateBlockStateModels(@NonNull BlockModelGenerators generators) {

    }

    @Override
    public void generateItemModels(@NonNull ItemModelGenerators generators) {

    }
}