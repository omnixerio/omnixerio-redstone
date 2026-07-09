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

import static dev.ultreon.mods.redstone.blocks.JkFlipFlopBlock.FACING;
import static dev.ultreon.mods.redstone.blocks.JkFlipFlopBlock.POWERED;

public class JkFlipFlopBlockEntity extends BlockEntity {
    private boolean previousClock;

    public JkFlipFlopBlockEntity(BlockEntityType<?> type, BlockPos worldPosition, BlockState blockState) {
        super(type, worldPosition, blockState);
    }

    public JkFlipFlopBlockEntity(BlockPos worldPosition, BlockState blockState) {
        this(ModBlockEntityTypes.JK_FLIP_FLOP.get(), worldPosition, blockState);
    }

    public void tick() {
        if (level == null || level.isClientSide()) return;

        BlockState state = getBlockState();
        Direction facing = state.getValue(FACING);
        Direction left = facing.getCounterClockWise();
        Direction right = facing.getClockWise();

        boolean clock = level.getSignal(worldPosition.relative(facing), facing) > 0;
        boolean j = level.getSignal(worldPosition.relative(left), left) > 0;
        boolean k = level.getSignal(worldPosition.relative(right), right) > 0;

        if (clock && !previousClock) {
            boolean current = state.getValue(POWERED);
            boolean next;

            if (j && !k) {
                next = true;
            } else if (!j && k) {
                next = false;
            } else if (j && k) {
                next = !current;
            } else {
                next = current;
            }

            if (next != current) {
                level.setBlock(worldPosition, state.setValue(POWERED, next), Block.UPDATE_ALL);
            }
        }

        previousClock = clock;
    }

    @Override
    protected void saveAdditional(ValueOutput output) {
        super.saveAdditional(output);
        output.putBoolean("previous_clock", previousClock);
    }

    @Override
    protected void loadAdditional(ValueInput input) {
        super.loadAdditional(input);
        previousClock = input.getBooleanOr("previous_clock", false);
    }
}
