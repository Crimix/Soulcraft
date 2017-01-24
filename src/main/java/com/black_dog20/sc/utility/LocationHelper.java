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

	
	public static List<Location> GetLocationNames(EntityPlayer player){
		ItemStack stack = player.getHeldItemMainhand();
		List<Location> returnList = new ArrayList<Location>();
		if(stack.hasTagCompound()){
			NBTTagCompound nbt = stack.getTagCompound();
			NBTTagList list = null;
			if(nbt.hasKey(NBTTags.LOCATIONS))
				list = nbt.getTagList(NBTTags.LOCATIONS, Constants.NBT.TAG_COMPOUND);
			if(list != null){
				for(int i = 0; i < list.tagCount(); i++){
					NBTTagCompound tag = list.getCompoundTagAt(i);
					returnList.add(Location.GetLocationFromNBT(tag));
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
		float yaw = player.rotationPitch;
		float pitch = player.rotationYaw;
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
			else{
				list = new NBTTagList();
				list.appendTag(l.serializeNBT());
				nbt.setTag(NBTTags.LOCATIONS, list);
			}
		}
	}
	
	public static void SetLocationToClientPlayer(EntityPlayer player, NBTTagCompound tag){
		ItemStack stack = player.getHeldItemMainhand();
		if(!stack.hasTagCompound())
			stack.setTagCompound(new NBTTagCompound());
		if(stack.hasTagCompound()){
			NBTTagCompound nbt = stack.getTagCompound();
			NBTTagList list = new NBTTagList();
			if(tag.hasKey(NBTTags.LOCATIONS))
				list = tag.getTagList(NBTTags.LOCATIONS, Constants.NBT.TAG_COMPOUND);
			nbt.setTag(NBTTags.LOCATIONS, list);
		}
	}
	
	public static NBTTagCompound GetLocationsFromServerPlayer(EntityPlayer player){
		ItemStack stack = player.getHeldItemMainhand();
		if(!stack.hasTagCompound())
			stack.setTagCompound(new NBTTagCompound());
		if(stack.hasTagCompound()){
			NBTTagCompound nbt = stack.getTagCompound();
			return nbt;
		}
		return new NBTTagCompound();
	}
	
}
