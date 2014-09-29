package com.example.examplemod;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;
import codechicken.lib.vec.BlockCoord;
import codechicken.lib.vec.Cuboid6;
import codechicken.multipart.minecraft.McBlockPart;
import codechicken.multipart.minecraft.McSidedMetaPart;
import codechicken.multipart.minecraft.TorchPart;

public class ExampleSidedPart extends McSidedMetaPart {

	public ExampleSidedPart() {
		super();
	}
	
	public ExampleSidedPart(int meta) {
		super(meta);
	}
	
	@Override
	public String getType() {
		return "ExampleMod|mySidedBlock";
	}

	public static McBlockPart placement(World world, BlockCoord pos, int side) {
        pos = pos.copy().offset(ForgeDirection.OPPOSITES[side]);
        Block block = world.getBlock(pos.x, pos.y, pos.z);
        if(!block.isSideSolid(world, pos.x, pos.y, pos.z, ForgeDirection.getOrientation(side)))
            return null;
        return new ExampleSidedPart(side);
    }
	
	@Override
	public Cuboid6 getBounds() {
		if      (meta == 0) return new Cuboid6(0.3F, 0.9F, 0.3F, 0.7F, 1F, 0.7F);
		else if (meta == 1) return new Cuboid6(0.3F, 0F, 0.3F, 0.7F, 0.1F, 0.7F);
		else if (meta == 2) return new Cuboid6(0.3F, 0.3F, 0.9F, 0.7F, 0.7F, 1F);
		else if (meta == 3) return new Cuboid6(0.3F, 0.3F, 0.0F, 0.7F, 0.7F, 0.1F);
		else if (meta == 4) return new Cuboid6(0.9F, 0.3F, 0.3F, 1.0F, 0.7F, 0.7F);
		else if (meta == 5) return new Cuboid6(0.0F, 0.3F, 0.3F, 0.1F, 0.7F, 0.7F);
		return null;
	}

	@Override
	public int sideForMeta(int meta) {
		return ForgeDirection.OPPOSITES[meta];
	}

	@Override
	public Block getBlock() {
		return ExampleMod.blockSidedExample;
	}

}
