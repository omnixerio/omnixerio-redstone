package dev.ultreon.mods.redstone.blocks.entity;

import dev.ultreon.mods.redstone.init.ModBlockEntityTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

import static dev.ultreon.mods.redstone.blocks.TimerBlock.DELAY;
import static dev.ultreon.mods.redstone.blocks.TimerBlock.POWERED;

public class TimerBlockEntity extends BlockEntity {
    private int timerTicks;

    public TimerBlockEntity(BlockEntityType<?> type, BlockPos worldPosition, BlockState blockState) {
        super(type, worldPosition, blockState);
    }

    public TimerBlockEntity(BlockPos worldPosition, BlockState blockState) {
        this(ModBlockEntityTypes.TIMER.get(), worldPosition, blockState);
    }

    public void tick() {
        if (level == null || level.isClientSide()) return;

        timerTicks++;
        BlockState state = getBlockState();
        int delay = state.getValue(DELAY) * 2;

        if (timerTicks >= delay) {
            timerTicks = 0;
            level.setBlock(worldPosition, state.cycle(POWERED), Block.UPDATE_ALL);
        }
    }
}
