package com.black_dog20.sc.init;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

import com.black_dog20.sc.crafting.NBTSensetiveShapedOreRecipe;
import com.black_dog20.sc.reference.NBTTags;
import com.black_dog20.sc.reference.Reference;

import net.minecraftforge.fml.common.registry.GameRegistry;

@GameRegistry.ObjectHolder(Reference.MOD_ID)
public class Recipes {

	public static void init() {
		ItemStack soul = (new ItemStack(ModItems.soulcystal));
		soul.setTagCompound(new NBTTagCompound());
		soul.getTagCompound().setTag(NBTTags.NBT_PROPERTISE, new NBTTagCompound());
		GameRegistry.addRecipe(new NBTSensetiveShapedOreRecipe(ModItems.teleporter, new Object[] { "sss", "sss", "sss", 's',soul  }));
	}

}
