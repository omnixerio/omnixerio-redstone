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

import static dev.ultreon.mods.redstone.blocks.DFlipFlopBlock.FACING;
import static dev.ultreon.mods.redstone.blocks.DFlipFlopBlock.POWERED;

public class DFlipFlopBlockEntity extends BlockEntity {
    private boolean previousClock;

    public DFlipFlopBlockEntity(BlockEntityType<?> type, BlockPos worldPosition, BlockState blockState) {
        super(type, worldPosition, blockState);
    }

    public DFlipFlopBlockEntity(BlockPos worldPosition, BlockState blockState) {
        this(ModBlockEntityTypes.D_FLIP_FLOP.get(), worldPosition, blockState);
    }

    public void tick() {
        if (level == null || level.isClientSide()) return;

        BlockState state = getBlockState();
        Direction facing = state.getValue(FACING);
        Direction left = facing.getCounterClockWise();

        boolean clock = level.getSignal(worldPosition.relative(facing), facing) > 0;
        boolean d = level.getSignal(worldPosition.relative(left), left) > 0;

        if (clock && !previousClock) {
            level.setBlock(worldPosition, state.setValue(POWERED, d), Block.UPDATE_ALL);
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
