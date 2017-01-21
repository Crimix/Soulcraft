package com.black_dog20.sc.utility;

import java.util.ArrayList;
import java.util.List;

import com.black_dog20.sc.reference.NBTTags;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraftforge.common.util.Constants;

public class LocationHelper {

	
	public static List<String> GetLocationNames(EntityPlayer player){
		ItemStack stack = player.getHeldItemMainhand();
		List<String> returnList = new ArrayList<String>();
		if(stack.hasTagCompound()){
			NBTTagCompound nbt = stack.getTagCompound();
			NBTTagList list = null;
			if(nbt.hasKey(NBTTags.LOCATIONS))
				list = nbt.getTagList(NBTTags.LOCATIONS, Constants.NBT.TAG_COMPOUND);
			if(list != null){
				for(int i = 0; i < list.tagCount(); i++){
					NBTTagCompound tag = list.getCompoundTagAt(i);
					Location l = new Location();
					l.deserializeNBT(tag);
					if(l != null)
						returnList.add(l.name);
				}
			}
		}
		return returnList;
		
	}
	
	public static void AddLocation(EntityPlayer player, String name){
		int dim = player.worldObj.provider.getDimension();
		double x = player.posX;
		double y = player.posY;
		double z = player.posZ;
		float yaw = player.cameraYaw;
		float pitch = player.cameraPitch;
		Location l = new Location(name, dim, x, y, z, yaw, pitch);
		
		ItemStack stack = player.getHeldItemMainhand();
		if(!stack.hasTagCompound())
			stack.setTagCompound(new NBTTagCompound());
		if(stack.hasTagCompound()){
			NBTTagCompound nbt = stack.getTagCompound();
			NBTTagList list = new NBTTagList();
			if(nbt.hasKey(NBTTags.LOCATIONS))
				list = nbt.getTagList(NBTTags.LOCATIONS, Constants.NBT.TAG_COMPOUND);
			if(list != null){
				list.appendTag(l.serializeNBT());
				nbt.setTag(NBTTags.LOCATIONS, list);
			}
		}
	}
	
}
