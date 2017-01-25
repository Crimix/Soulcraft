package com.black_dog20.sc.block;

import com.black_dog20.sc.tileEntity.CobbleGenTileEntity;

import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class CobbleGen extends BlockSC implements ITileEntityProvider{

	public CobbleGen(Material materialIn) {
		super("cobbleGen",materialIn);
		
	}
		
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn,
				   EnumHand hand, ItemStack heldItem, EnumFacing side, float hitX, float hitY, float hitZ) {
			CobbleGenTileEntity entity = (CobbleGenTileEntity)worldIn.getTileEntity(pos);
			entity.BlockActivated(playerIn);
		return true;
	}
	
	@Override
	public boolean hasTileEntity() {
		return true;
	}

	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		return new CobbleGenTileEntity();
	}
}
