package com.black_dog20.sc.jei;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.client.resources.I18n;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import mezz.jei.api.BlankModPlugin;
import mezz.jei.api.IJeiRuntime;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.IModRegistry;
import mezz.jei.api.ISubtypeRegistry;
import mezz.jei.api.ingredients.IModIngredientRegistration;

import com.black_dog20.sc.init.*;

@mezz.jei.api.JEIPlugin
public class JEIPlugin extends BlankModPlugin{

	@Override
	public void registerItemSubtypes(ISubtypeRegistry subtypeRegistry) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void registerIngredients(IModIngredientRegistration registry) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void register(IModRegistry registry) {
		List<ItemStack> list = new ArrayList<ItemStack>();
		list.add(new ItemStack(ModBlocks.cobbleGen));
		
		for(ItemStack stack : list)
				registry.addDescription(stack, I18n.format(stack.getItem().getUnlocalizedName()+".info"));
		
	}

	@Override
	public void onRuntimeAvailable(IJeiRuntime jeiRuntime) {
		// TODO Auto-generated method stub
		
	}

}
