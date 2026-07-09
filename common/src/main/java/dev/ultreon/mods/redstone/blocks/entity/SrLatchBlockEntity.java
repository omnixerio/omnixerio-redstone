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

import static dev.ultreon.mods.redstone.blocks.SrLatchBlock.FACING;
import static dev.ultreon.mods.redstone.blocks.SrLatchBlock.POWERED;

public class SrLatchBlockEntity extends BlockEntity {
    public SrLatchBlockEntity(BlockEntityType<?> type, BlockPos worldPosition, BlockState blockState) {
        super(type, worldPosition, blockState);
    }

    public SrLatchBlockEntity(BlockPos worldPosition, BlockState blockState) {
        this(ModBlockEntityTypes.SR_LATCH.get(), worldPosition, blockState);
    }

    public void tick() {
        if (level == null || level.isClientSide()) return;

        BlockState state = getBlockState();
        Direction facing = state.getValue(FACING);
        Direction left = facing.getCounterClockWise();
        Direction right = facing.getClockWise();

        boolean set = level.getSignal(worldPosition.relative(left), left) > 0;
        boolean reset = level.getSignal(worldPosition.relative(right), right) > 0;

        boolean current = state.getValue(POWERED);
        boolean next;

        if (set && !reset) {
            next = true;
        } else if (!set && reset) {
            next = false;
        } else {
            next = current;
        }

        if (next != current) {
            level.setBlock(worldPosition, state.setValue(POWERED, next), Block.UPDATE_ALL);
        }
    }
}
