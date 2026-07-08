package dev.ultreon.mods.redstone.blocks;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DiodeBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;

public class AndGateBlock extends DiodeBlock {
    public static final MapCodec<AndGateBlock> CODEC = simpleCodec(AndGateBlock::new);

    public AndGateBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any()
                .setValue(FACING, Direction.NORTH)
                .setValue(POWERED, false));
    }

    @Override
    public MapCodec<? extends DiodeBlock> codec() {
        return CODEC;
    }

    @Override
    protected int getOutputSignal(BlockGetter level, BlockPos pos, BlockState state) {
        return state.getValue(POWERED) ? 15 : 0;
    }

    @Override
    protected int getDelay(BlockState state) {
        return 2;
    }

    @Override
    protected boolean shouldTurnOn(Level level, BlockPos pos, BlockState state) {
        Direction facing = state.getValue(FACING);
        Direction left = facing.getCounterClockWise();
        Direction right = facing.getClockWise();
        boolean leftPowered = level.getSignal(pos.relative(left), left) > 0;
        boolean rightPowered = level.getSignal(pos.relative(right), right) > 0;
        return leftPowered && rightPowered;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING, BlockStateProperties.POWERED);
    }
}
