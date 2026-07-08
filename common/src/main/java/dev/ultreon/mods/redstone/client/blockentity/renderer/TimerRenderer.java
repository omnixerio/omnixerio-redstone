package dev.ultreon.mods.redstone.client.blockentity.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import dev.ultreon.mods.redstone.blocks.TimerBlock;
import dev.ultreon.mods.redstone.blocks.entity.TimerBlockEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.feature.ModelFeatureRenderer;
import net.minecraft.client.renderer.state.level.CameraRenderState;
import net.minecraft.network.chat.Component;
import net.minecraft.util.FormattedCharSequence;
import net.minecraft.world.phys.Vec3;
import org.joml.Quaternionf;
import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;

public class TimerRenderer implements BlockEntityRenderer<TimerBlockEntity, TimerBlockEntityRenderState> {

    private final BlockEntityRendererProvider.Context context;

    public TimerRenderer(BlockEntityRendererProvider.Context context) {
        this.context = context;
    }

    @Override
    public @NonNull TimerBlockEntityRenderState createRenderState() {
        return new TimerBlockEntityRenderState();
    }

    @Override
    public void extractRenderState(@NonNull TimerBlockEntity blockEntity, @NonNull TimerBlockEntityRenderState state, float partialTicks, @NonNull Vec3 cameraPosition, ModelFeatureRenderer.@Nullable CrumblingOverlay breakProgress) {
        BlockEntityRenderer.super.extractRenderState(blockEntity, state, partialTicks, cameraPosition, breakProgress);

        state.delay = blockEntity.getBlockState().getValue(TimerBlock.DELAY);
    }

    @Override
    public void submit(TimerBlockEntityRenderState state, PoseStack poseStack, SubmitNodeCollector submitNodeCollector, @NonNull CameraRenderState camera) {
        poseStack.pushPose();
        poseStack.translate(.5f, 4 / 16f + 0.001f, .5f);
        poseStack.scale(1 / 24f, 1 / 16f, 1 / 24f);
        poseStack.mulPose(new Quaternionf().rotateY((float) Math.toRadians(180)));
        poseStack.mulPose(new Quaternionf().rotateX((float) Math.toRadians(90)));
        FormattedCharSequence visualOrderText = Component.literal(String.valueOf(state.delay)).getVisualOrderText();
        float x = Minecraft.getInstance().font.width(visualOrderText);
        submitNodeCollector.submitText(poseStack, -x/2, 0, visualOrderText, false, Font.DisplayMode.NORMAL, state.lightCoords, 0xffffffff, 0x00000000, 0x00000000);
        poseStack.popPose();
    }
}
