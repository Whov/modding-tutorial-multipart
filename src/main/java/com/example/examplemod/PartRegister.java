package com.example.examplemod;

import java.util.Arrays;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import codechicken.lib.vec.BlockCoord;
import codechicken.multipart.MultiPartRegistry.IPartConverter;
import codechicken.multipart.MultiPartRegistry.IPartFactory;
import codechicken.multipart.MultiPartRegistry;
import codechicken.multipart.TMultiPart;

public class PartRegister implements IPartFactory, IPartConverter {

	@Override
	public Iterable<Block> blockTypes() {
		return Arrays.asList(ExampleMod.blockExample, ExampleMod.blockSidedExample);
	}
	
	public void init() {
		MultiPartRegistry.registerConverter(this);
        MultiPartRegistry.registerParts(this, new String[]{"ExampleMod|myBlock", "ExampleMod|mySidedBlock"});
	}

	@Override
	public TMultiPart convert(World world, BlockCoord pos) {
		Block b = world.getBlock(pos.x, pos.y, pos.z);
		int meta = world.getBlockMetadata(pos.x, pos.y,  pos.z);
		if (b==ExampleMod.blockExample) return new ExamplePart();
		if (b==ExampleMod.blockSidedExample) return new ExampleSidedPart(meta);
		return null;
	}

	@Override
	public TMultiPart createPart(String name, boolean client) {
		if (name.equals("ExampleMod|myBlock")) return new ExamplePart();
		if (name.equals("ExampleMod|mySidedBlock")) return new ExampleSidedPart();
		return null;
	}

}
