package com.timlee9024.mcgltf.example;

import java.util.List;

import org.lwjgl.opengl.GL11;

import com.timlee9024.mcgltf.IGltfModelReceiver;
import com.timlee9024.mcgltf.ItemCameraTransformsHelper;
import com.timlee9024.mcgltf.RenderedGltfModel;

import de.javagl.jgltf.model.GltfAnimations;
import de.javagl.jgltf.model.animation.Animation;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.tileentity.TileEntityItemStackRenderer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public class TileEntityItemStackRendererItemExample extends TileEntityItemStackRenderer implements IGltfModelReceiver {

	protected List<Runnable> commands;
	
	protected List<Animation> animations;
	
	@Override
	public ResourceLocation getModelLocation() {
		return new ResourceLocation("mcgltf", "models/item/water_bottle.gltf");
	}

	@Override
	public void onModelLoaded(RenderedGltfModel renderedModel) {
		commands = renderedModel.sceneCommands.get(0);
		animations = GltfAnimations.createModelAnimations(renderedModel.gltfModel.getAnimationModels());
	}

	@Override
	public void renderByItem(ItemStack itemStackIn) {
		if(commands != null) {
			GL11.glPushMatrix();
			GL11.glPushAttrib(GL11.GL_ALL_ATTRIB_BITS);
			GL11.glShadeModel(GL11.GL_SMOOTH);
			
			//Require ItemCameraTransformsHelper$registerDummyModelToAccessCurrentTransformTypeForTEISR(yourItem) during ModelRegistryEvent to make ItemCameraTransformsHelper$getCurrentTransformType() work
			switch(ItemCameraTransformsHelper.getCurrentTransformType()) {
			case GUI:
				GL11.glEnable(GL11.GL_LIGHTING);
				break;
			default:
				break;
			}
			
			for(Animation animation : animations) {
				animation.update(net.minecraftforge.client.model.animation.Animation.getWorldTime(Minecraft.getMinecraft().world, net.minecraftforge.client.model.animation.Animation.getPartialTickTime()) % animation.getEndTimeS());
			}
			commands.forEach((command) -> command.run());
			
			GL11.glPopAttrib();
			GL11.glPopMatrix();
		}
	}

}
