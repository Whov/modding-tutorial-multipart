package com.example.examplemod;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

public class MultipartSidedExample extends Block {

	public MultipartSidedExample() {
		super(Material.rock);
		this.setBlockName("multipartSidedExample");
		this.setBlockTextureName("redstone_block");
	}
	
	@Override
	public boolean isOpaqueCube() {
		return false;
	}
	
	@Override
	public int onBlockPlaced(World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ, int metadata_of_the_item) {
		return side;//this sets the metadata of the block to side
	}

	@Override
	public boolean canPlaceBlockAt(World world, int x, int y, int z) {
		return world.isSideSolid(x - 1, y, z, ForgeDirection.EAST ) ||
		world.isSideSolid(x + 1, y, z, ForgeDirection.WEST ) ||
		world.isSideSolid(x, y, z - 1, ForgeDirection.SOUTH) ||
		world.isSideSolid(x, y, z + 1, ForgeDirection.NORTH) ||
		world.isSideSolid(x, y - 1, z, ForgeDirection.UP   ) ||
		world.isSideSolid(x, y + 1, z, ForgeDirection.DOWN );
	}
	 
	@Override
	public boolean canPlaceBlockOnSide(World world, int x, int y, int z, int side) {
		ForgeDirection dir = ForgeDirection.getOrientation(side).getOpposite();
		System.out.println(dir.name());
		return (world.isSideSolid(x+dir.offsetX, y+dir.offsetY, z+dir.offsetZ, dir.getOpposite()));
	}
	 
	@Override
	public void onNeighborBlockChange(World world, int x, int y, int z, Block block) {
		//make it drop if support block is removed
		int l = world.getBlockMetadata(x, y, z);
		if (!canPlaceBlockOnSide(world, x, y, z, l)) {
			this.dropBlockAsItem(world, x, y, z, world.getBlockMetadata(x, y, z), 0);
			world.setBlockToAir(x, y, z);
		}
	 }

	 @Override
	 public void setBlockBoundsBasedOnState(IBlockAccess world, int x, int y, int z) {
	  int l = world.getBlockMetadata(x, y, z);
	  if      (l == 0) this.setBlockBounds(0.3F, 0.9F, 0.3F, 0.7F, 1F, 0.7F);
	  else if (l == 1) this.setBlockBounds(0.3F, 0F, 0.3F, 0.7F, 0.1F, 0.7F);
	  else if (l == 2) this.setBlockBounds(0.3F, 0.3F, 0.9F, 0.7F, 0.7F, 1F);
	  else if (l == 3) this.setBlockBounds(0.3F, 0.3F, 0.0F, 0.7F, 0.7F, 0.1F);
	  else if (l == 4) this.setBlockBounds(0.9F, 0.3F, 0.3F, 1.0F, 0.7F, 0.7F);
	  else if (l == 5) this.setBlockBounds(0.0F, 0.3F, 0.3F, 0.1F, 0.7F, 0.7F);
	 }
	
}
