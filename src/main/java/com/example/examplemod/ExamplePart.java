package com.example.examplemod;

import net.minecraft.block.Block;
import codechicken.lib.vec.Cuboid6;
import codechicken.multipart.minecraft.McMetaPart;

public class ExamplePart extends McMetaPart {

	@Override
	public String getType() {
		return "ExampleMod|myBlock";
	}

	@Override
	public Cuboid6 getBounds() {
		return new Cuboid6(0.2, 0, 0.2, 0.8, 1, 0.8);
	}

	@Override
	public Block getBlock() {
		return ExampleMod.blockExample;
	}

}
