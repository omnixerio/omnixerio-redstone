package dev.ultreon.mods.redstone.blocks.entity;

import dev.ultreon.mods.redstone.init.ModBlockEntityTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

import static dev.ultreon.mods.redstone.blocks.PulseGeneratorBlock.FACING;
import static dev.ultreon.mods.redstone.blocks.PulseGeneratorBlock.POWERED;

public class PulseGeneratorBlockEntity extends BlockEntity {
    private boolean previousInput;
    private int pulseTicks;

    public PulseGeneratorBlockEntity(BlockEntityType<?> type, BlockPos worldPosition, BlockState blockState) {
        super(type, worldPosition, blockState);
    }

    public PulseGeneratorBlockEntity(BlockPos worldPosition, BlockState blockState) {
        this(ModBlockEntityTypes.PULSE_GENERATOR.get(), worldPosition, blockState);
    }

    public void tick() {
        if (level == null || level.isClientSide()) return;

        BlockState state = getBlockState();
        Direction facing = state.getValue(FACING);
        boolean input = level.getSignal(worldPosition.relative(facing), facing) > 0;

        if (state.getValue(POWERED)) {
            pulseTicks++;
            if (pulseTicks >= 2) {
                level.setBlock(worldPosition, state.setValue(POWERED, false), Block.UPDATE_ALL);
                pulseTicks = 0;
            }
        } else if (input && !previousInput) {
            level.setBlock(worldPosition, state.setValue(POWERED, true), Block.UPDATE_ALL);
            pulseTicks = 0;
        }

        previousInput = input;
    }
}
