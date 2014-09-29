package com.example.examplemod;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class MultipartExample extends Block {

	public MultipartExample() {
		super(Material.ground);
		this.setBlockName("multipartExample");
		this.setBlockTextureName("redstone_block");
		this.setBlockBounds(0.2f, 0f, 0.2f, 0.8f, 1f, 0.8f);
	}

	@Override
	public boolean isOpaqueCube() {
		return false;
	}
	
}
