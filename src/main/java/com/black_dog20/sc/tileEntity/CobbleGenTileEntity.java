package com.black_dog20.sc.tileEntity;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ITickable;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class CobbleGenTileEntity extends TileEntity implements ITickable {

	int maxStack = 32;
	int stackSize = 0;
	int counter = 0;
	public CobbleGenTileEntity(){
		
	}
	
	public void BlockActivated(EntityPlayer playerIn) {
		playerIn.inventory.addItemStackToInventory(new ItemStack(Blocks.COBBLESTONE, stackSize));
	}

	@Override
	public void update() {
		if (stackSize < maxStack && counter == 20) {
			stackSize++;
			counter = 0;
		}
		counter++;
		
	}
}
