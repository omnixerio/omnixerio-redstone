package dev.ultreon.mods.redstone.blocks.entity;

import dev.ultreon.mods.redstone.init.ModBlockEntityTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;
import org.jspecify.annotations.Nullable;

import static dev.ultreon.mods.redstone.blocks.SwitchBlock.FACING;
import static dev.ultreon.mods.redstone.blocks.SwitchBlock.POWERED;
import static net.minecraft.world.level.block.Block.updateFromNeighbourShapes;

public class SwitchBlockEntity extends BlockEntity {
    private boolean previousInput;

    public SwitchBlockEntity(BlockEntityType<?> type, BlockPos worldPosition, BlockState blockState) {
        super(type, worldPosition, blockState);
    }

    public SwitchBlockEntity(BlockPos worldPosition, BlockState blockState) {
        this(ModBlockEntityTypes.SWITCH.get(), worldPosition, blockState);
    }

    public void tick() {
        if (level == null || level.isClientSide()) return;

        BlockState state = getBlockState();
        Direction facing = state.getValue(FACING);
        boolean hasInput = level.getSignal(worldPosition.relative(facing), facing) > 0;

        if (hasInput && !previousInput) {
            level.setBlock(worldPosition, state.cycle(POWERED), Block.UPDATE_ALL);
            playSound(null, level, worldPosition, state);
            level.gameEvent(null, state.getValue(POWERED) ? GameEvent.BLOCK_ACTIVATE : GameEvent.BLOCK_DEACTIVATE, getBlockPos());
        }

        previousInput = hasInput;
    }

    protected static void playSound(final @Nullable Player player, final LevelAccessor level, final BlockPos pos, final BlockState stateAfter) {
        float pitch = stateAfter.getValue(POWERED) ? 0.6F : 0.5F;
        level.playSound(player, pos, SoundEvents.LEVER_CLICK, SoundSource.BLOCKS, 0.3F, pitch);
    }

    @Override
    protected void saveAdditional(ValueOutput output) {
        super.saveAdditional(output);
        output.putBoolean("previous_input", previousInput);
    }

    @Override
    protected void loadAdditional(ValueInput input) {
        super.loadAdditional(input);
        previousInput = input.getBooleanOr("previous_input", false);
    }
}
