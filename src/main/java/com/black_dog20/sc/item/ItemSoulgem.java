package com.black_dog20.sc.item;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

import com.black_dog20.sc.nbt.Soulgem;
import com.black_dog20.sc.reference.NBTTags;

public class ItemSoulgem extends ItemSC {

	public ItemSoulgem(){
		super("ItemSoulgem");
	}
	
	
	@Override
	public void addInformation(ItemStack stack, EntityPlayer playerIn, List<String> tooltip, boolean advanced) {
		if(stack.hasTagCompound()){
			NBTTagCompound nbt = stack.getTagCompound();
			if(nbt.hasKey(NBTTags.NBT_PROPERTISE)){
				Soulgem s = Soulgem.GetSoulgemFromNBT(nbt);
				if(s.GetType().equals("")){
					tooltip.add("Type: "+s.GetType());
				}
				else{
					tooltip.add("Type:");
				}
				tooltip.add("Stored: " + Integer.toString(s.GetStored())+"%");
			}
		}
		
		super.addInformation(stack, playerIn, tooltip, advanced);
	}
	
	public ItemStack GetItemForCraftingResult(){
		ItemStack stack = new ItemStack(this,3);
		NBTTagCompound nbt = new NBTTagCompound();
		nbt.setTag(NBTTags.NBT_PROPERTISE, new Soulgem().serializeNBT());
		stack.setTagCompound(nbt);
		return stack;
	}
}
