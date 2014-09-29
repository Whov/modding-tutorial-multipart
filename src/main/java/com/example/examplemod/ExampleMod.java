package com.example.examplemod;

import codechicken.lib.packet.PacketCustom;
import codechicken.multipart.minecraft.McMultipartCPH;
import codechicken.multipart.minecraft.McMultipartSPH;
import codechicken.multipart.minecraft.MinecraftMultipartMod;
import net.minecraft.block.Block;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid = ExampleMod.MODID, version = ExampleMod.VERSION, dependencies = "after:ForgeMultipart")
public class ExampleMod
{
	@Instance("examplemod")
    public static ExampleMod instance;
	
    public static final String MODID = "examplemod";
    public static final String VERSION = "1.0";
    
    public static Block blockExample;
    public static Block blockSidedExample;
    
    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
    	blockExample = new MultipartExample();
    	blockSidedExample = new MultipartSidedExample();
    	GameRegistry.registerBlock(blockExample, "multipartexample");
    	GameRegistry.registerBlock(blockSidedExample, "multipartsidedexample");
    	new PartRegister().init();
    	MinecraftForge.EVENT_BUS.register(new ExampleEventHandler());
        PacketCustom.assignHandler(this, new ExampleServerHandler());
//        if(FMLCommonHandler.instance().getSide().isClient())
//            PacketCustom.assignHandler(this, new ExampleClientHandler());
    }
}