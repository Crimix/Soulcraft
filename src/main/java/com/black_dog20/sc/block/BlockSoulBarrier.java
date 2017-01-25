package com.black_dog20.sc.block;

import java.util.List;

import com.black_dog20.sc.init.ModBlocks;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.entity.boss.EntityWither;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Explosion;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockSoulBarrier extends BlockSC{

	public BlockSoulBarrier() {
		super("BlockSoulBarrier", Material.ROCK);
		this.blockResistance = Float.MAX_VALUE;
	}

	@Override
	public boolean canEntityDestroy(IBlockState state, IBlockAccess world, BlockPos pos, Entity entity)
	{
		return false;
	}

	@Override
	public boolean isFullCube (IBlockState state) {

		return false;
	}

	@Override
	public boolean isOpaqueCube (IBlockState state) {

		return false;
	}

	@Override
	public void addCollisionBoxToList (IBlockState state, World worldIn, BlockPos pos, AxisAlignedBB entityBox, List<AxisAlignedBB> collidingBoxes, Entity collidingEntity) {

		if (collidingEntity instanceof EntityPlayer) {

			return;
		}

		super.addCollisionBoxToList(state, worldIn, pos, entityBox, collidingBoxes, collidingEntity);
	}
	
	@Override
    public void onBlockExploded(World world, BlockPos pos, Explosion explosion)
    {
		world.setBlockState(pos, ModBlocks.soulBarrier.getDefaultState(), 3);
    }
	
	@Override
    public void onBlockDestroyedByExplosion(World worldIn, BlockPos pos, Explosion explosionIn)
    {
    }
	
	@Override
    public boolean canDropFromExplosion(Explosion explosionIn)
    {
        return false;
    }
	
	
   



}
