package net.ArcticFox.flash.mod_id.mixin;

import net.ArcticFox.flash.mod_id.Main;
import net.ArcticFox.flash.mod_id.items.ItemRegistry;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.render.model.BakedModel;
import net.minecraft.client.render.model.json.ModelTransformationMode;
import net.minecraft.client.util.ModelIdentifier;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(ItemRenderer.class)
public abstract class ItemRenderMixin {
    @ModifyVariable(method = "renderItem(Lnet/minecraft/item/ItemStack;Lnet/minecraft/client/render/model/json/ModelTransformationMode;ZLnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider;IILnet/minecraft/client/render/model/BakedModel;)V", at = @At("HEAD"), argsOnly = true)
    public BakedModel useFlashlightModel(BakedModel value, ItemStack stack, ModelTransformationMode renderMode, boolean leftHanded, MatrixStack matricies, VertexConsumerProvider vertexConsumers, int light, int overlay) {
        if (stack.isOf(ItemRegistry.FLASHLIGHT) && renderMode != ModelTransformationMode.GUI) {
            return  ((ItemRendererAccessor) this).course$getModels().getModelManager().getModel(new ModelIdentifier(Main.MOD_ID, "Flashlight Model 3D", "inventory"));
        }
        return value;
    }

}
