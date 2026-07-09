package dev.ultreon.mods.redstone.blocks.entity;

import dev.ultreon.mods.redstone.init.ModBlockEntityTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;

import static dev.ultreon.mods.redstone.blocks.PulseExtenderBlock.DELAY;
import static dev.ultreon.mods.redstone.blocks.PulseExtenderBlock.FACING;
import static dev.ultreon.mods.redstone.blocks.PulseExtenderBlock.POWERED;

public class PulseExtenderBlockEntity extends BlockEntity {
    private int extendRemaining;

    public PulseExtenderBlockEntity(BlockEntityType<?> type, BlockPos worldPosition, BlockState blockState) {
        super(type, worldPosition, blockState);
    }

    public PulseExtenderBlockEntity(BlockPos worldPosition, BlockState blockState) {
        this(ModBlockEntityTypes.PULSE_EXTENDER.get(), worldPosition, blockState);
    }

    public void tick() {
        if (level == null || level.isClientSide()) return;

        BlockState state = getBlockState();
        Direction facing = state.getValue(FACING);
        boolean input = level.getSignal(worldPosition.relative(facing), facing) > 0;

        if (input) {
            extendRemaining = state.getValue(DELAY) * 2;
            if (!state.getValue(POWERED)) {
                level.setBlock(worldPosition, state.setValue(POWERED, true), Block.UPDATE_ALL);
            }
        } else if (state.getValue(POWERED)) {
            extendRemaining--;
            if (extendRemaining <= 0) {
                level.setBlock(worldPosition, state.setValue(POWERED, false), Block.UPDATE_ALL);
            }
        }
    }

    @Override
    protected void saveAdditional(ValueOutput output) {
        super.saveAdditional(output);
        output.putInt("extend_remaining", extendRemaining);
    }

    @Override
    protected void loadAdditional(ValueInput input) {
        super.loadAdditional(input);
        extendRemaining = input.getIntOr("extend_remaining", 0);
    }
}
