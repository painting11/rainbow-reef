package net.thevaliantsquidward.rainbowreef.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.thevaliantsquidward.rainbowreef.RainbowReef;
import net.thevaliantsquidward.rainbowreef.entity.custom.AngelfishEntity;
import net.thevaliantsquidward.rainbowreef.entity.custom.ArrowCrabEntity;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class ArrowCrabRenderer extends GeoEntityRenderer<ArrowCrabEntity> {
    private static final ResourceLocation RED = new ResourceLocation(RainbowReef.MOD_ID, "textures/entity/redarrowcrab.png");
    private static final ResourceLocation YELLOWLINED = new ResourceLocation(RainbowReef.MOD_ID, "textures/entity/yellowlinearrowcrab.png");


    public ArrowCrabRenderer(EntityRendererProvider.Context renderManagerIn) {
        super(renderManagerIn, new ArrowCrabModel());
    }

    protected void scale(ArrowCrabEntity entitylivingbaseIn, PoseStack matrixStackIn, float partialTickTime) {
    }


    public ResourceLocation getTextureLocation(ArrowCrabEntity entity) {
        return switch (entity.getVariant()) {
            case 1 -> RED;
            default -> YELLOWLINED;
        };
    }
}