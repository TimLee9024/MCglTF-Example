package com.timlee9024.mcgltf.example;

import java.util.List;

import com.timlee9024.mcgltf.IGltfModelReceiver;
import com.timlee9024.mcgltf.RenderedGltfModel;

import de.javagl.jgltf.model.GltfAnimations;
import de.javagl.jgltf.model.animation.Animation;

public abstract class AbstractItemGltfModelReceiver implements IGltfModelReceiver {

	public Runnable vanillaSkinningCommands;
	
	public List<Runnable> vanillaRenderCommands;
	
	public List<Runnable> shaderModCommands;
	
	public List<Animation> animations;
	
	@Override
	public void onReceiveSharedModel(RenderedGltfModel renderedModel) {
		vanillaSkinningCommands = renderedModel.vanillaSceneSkinningCommands.get(0);
		vanillaRenderCommands = renderedModel.vanillaSceneRenderCommands.get(0);
		shaderModCommands = renderedModel.shaderModSceneCommands.get(0);
		animations = GltfAnimations.createModelAnimations(renderedModel.gltfModel.getAnimationModels());
	}

}
