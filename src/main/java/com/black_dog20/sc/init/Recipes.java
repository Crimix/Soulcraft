package com.black_dog20.sc.init;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

import com.black_dog20.sc.crafting.NBTSensetiveShapedOreRecipe;
import com.black_dog20.sc.item.ItemSoulgem;
import com.black_dog20.sc.reference.NBTTags;
import com.black_dog20.sc.reference.Reference;

import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;

@GameRegistry.ObjectHolder(Reference.MOD_ID)
public class Recipes {

	public static void init() {
		GameRegistry.addRecipe(new ShapedOreRecipe(ModItems.soulManipulator, new Object[] { "c ", " s", 'c', ModItems.soulcystal, 's', "stickWood" }));
		GameRegistry.addRecipe(new ShapelessOreRecipe(ModItems.soulgem.GetItemForCraftingResult(), ModItems.soulcystal,ModItems.soulManipulator));
		
	}

}
