package com.black_dog20.sc.item;

import com.black_dog20.sc.sc;
import com.black_dog20.sc.network.PacketHandler;
import com.black_dog20.sc.network.message.MessagePlayerTelePort;
import com.black_dog20.sc.utility.TeleportManager;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

public class ItemTeleport extends ItemSC{

	public ItemTeleport(){
		super("ItemTeleport");
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(ItemStack stack, World worldIn, EntityPlayer playerIn, EnumHand hand) {
		if(worldIn.isRemote){
			if(!stack.hasTagCompound()){
				stack.setTagCompound(new NBTTagCompound());
			}

			if(!playerIn.isSneaking()){
				if(stack.hasTagCompound()){
					System.out.println("teleport");
					NBTTagCompound nbt= stack.getTagCompound();
					if(nbt.hasKey("dim")){
						int dim = nbt.getInteger("dim");
						double x = nbt.getDouble("xPos");
						double y = nbt.getDouble("yPos");
						double z = nbt.getDouble("zPos");
						System.out.println("tp x="+ x +" y="+ y +" z=" + z);
						PacketHandler.network.sendToServer(new MessagePlayerTelePort(dim, x, y, z));
					}
				}
			}
			else{
				NBTTagCompound nbt= stack.getTagCompound();
				nbt.setInteger("dim", playerIn.worldObj.provider.getDimension());
				nbt.setDouble("xPos", playerIn.posX);
				nbt.setDouble("yPos", playerIn.posY);
				nbt.setDouble("zPos", playerIn.posZ);
				System.out.println("Set coords x="+ playerIn.posX +" y="+ playerIn.posY +" z=" + playerIn.posZ);
				stack.setTagCompound(nbt);
								
			}
		}
		playerIn.openGui(sc.instance, sc.guiTeleportBook, playerIn.worldObj, (int)playerIn.posX, (int)playerIn.posY, (int)playerIn.posZ);	
		return super.onItemRightClick(stack, worldIn, playerIn, hand);
	}

}
