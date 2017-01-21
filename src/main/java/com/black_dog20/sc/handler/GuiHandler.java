package com.black_dog20.sc.handler;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

import com.black_dog20.sc.sc;
import com.black_dog20.sc.client.gui.GuiAddTeleportLocation;
import com.black_dog20.sc.client.gui.GuiTeleportBook;
import com.black_dog20.sc.container.ContainerDummy;
import com.black_dog20.sc.init.ModBlocks;
import com.black_dog20.sc.utility.NBTHelper;


public class GuiHandler implements IGuiHandler {

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		
		if(ID == sc.guiTeleportBook){
			return new ContainerDummy(player);
		}
		else if(ID == sc.guiTeleportBookAdd){
			return new ContainerDummy(player);
		}
		/*TileEntity entity = world.getTileEntity(x, y, z);
		ItemStack item = player.getHeldItem();

		if (ID == vut.guiVehicleInventory) {
			return new ContainerVehicle(player, world, x, y, z, world.getEntityByID(NBTHelper.getPlayerNBT(player).getInteger("DVMVehicleId")));
		}
		else if(ID == vut.guiVehicleUpgrade){
			return new ContainerVehicleUpgrade(player, world, x, y, z, world.getEntityByID(NBTHelper.getPlayerNBT(player).getInteger("DVMVehicleId")));
			
		}*/
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		
		if(ID == sc.guiTeleportBook){
			return new GuiTeleportBook(player);
		}
		else if(ID == sc.guiTeleportBookAdd){
			return new GuiAddTeleportLocation(player);
		}
		/*TileEntity entity = world.getTileEntity(x, y, z);

		if (ID == vut.guiVehicleInventory) {
			Entity vehicle = world.getEntityByID(NBTHelper.getPlayerNBT(player).getInteger("DVMVehicleId"));
			if(vehicle !=null){
				return new GuiVehicle(player, world, x, y, z,vehicle );
			}
			else return null;
		}
		else if(ID == vut.guiVehicleUpgrade){
			Entity vehicle = world.getEntityByID(NBTHelper.getPlayerNBT(player).getInteger("DVMVehicleId"));
			if(vehicle !=null){
				return new GuiVehicleUpgrade(player, world, x, y, z, vehicle);
			}
			else return null;
		}*/

		return null;
	}

}