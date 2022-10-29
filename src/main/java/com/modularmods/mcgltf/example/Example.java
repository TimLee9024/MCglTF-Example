package com.modularmods.mcgltf.example;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod(modid = "example_mcgltf_usage", dependencies = "required-after-client:mcgltf;", useMetadata = true)
public class Example {

	@SidedProxy(clientSide = "com.modularmods.mcgltf.example.ClientProxy", serverSide = "com.modularmods.mcgltf.example.ServerProxy")
	public static CommonProxy proxy;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		MinecraftForge.EVENT_BUS.register(proxy);
		GameRegistry.registerTileEntity(TileEntityExample.class, new ResourceLocation("mcgltf", "example_tileentity"));
		proxy.preInit(event);
	}

}