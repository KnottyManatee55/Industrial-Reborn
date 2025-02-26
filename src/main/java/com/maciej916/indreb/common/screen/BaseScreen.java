package com.maciej916.indreb.common.screen;

import com.maciej916.indreb.common.container.IndRebMenu;
import com.maciej916.indreb.common.entity.block.IndRebBlockEntity;
import com.maciej916.indreb.common.interfaces.screen.IGuiWrapper;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

public class BaseScreen <T extends IndRebMenu> extends AbstractContainerScreen<T> implements IGuiWrapper {

    private final T container;

    public BaseScreen(T container, Inventory inventory, Component component) {
        super(container, inventory, component);
        this.container = container;
        this.imageHeight = 234;
    }

    public T getContainer() {
        return container;
    }

    @Override
    public IndRebBlockEntity getBlockEntity() {
        return container.getBlockEntity();
    }

    @Override
    public ResourceLocation getGuiLocation() {
        return null;
    }

    @Override
    protected void init() {
        super.init();
        this.leftPos = (this.width - this.imageWidth) / 2;
        this.topPos = ((this.height - this.imageHeight) / 2) + 34;
    }

    protected void renderBg(PoseStack poseStack, float partialTicks, int mouseX, int mouseY) {
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, getGuiLocation());
        this.blit(poseStack, getGuiLeft(), getGuiTop(), 0, 0, this.imageWidth, this.imageHeight);
    }

    protected void renderLabels(PoseStack poseStack, int mouseX, int mouseY) {
        super.renderLabels(poseStack, mouseX, mouseY);
//        this.font.draw(poseStack, this.getTitle(), 8.0F, 6.0F, 4210752);
//        this.font.draw(poseStack, Component.translatable("container.inventory"), 8.0F, 128.0F, 4210752);
    }

    public void render(PoseStack poseStack, int mouseX, int mouseY, float partialTicks) {
        this.renderBackground(poseStack);
        super.render(poseStack, mouseX, mouseY, partialTicks);
        this.renderTooltip(poseStack, mouseX, mouseY);
    }


}
