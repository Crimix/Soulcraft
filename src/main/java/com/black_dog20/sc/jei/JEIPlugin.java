package com.black_dog20.sc.jei;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.client.resources.I18n;
import net.minecraft.item.ItemStack;
import mezz.jei.api.BlankModPlugin;
import mezz.jei.api.IJeiRuntime;
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
		list.add(new ItemStack(ModItems.soulcystal));
		list.add(new ItemStack(ModBlocks.soulcystalOre));
		list.add(new ItemStack(ModBlocks.soulBarrier));
		list.add(new ItemStack(ModBlocks.soulBarrierFloor));
		list.add(new ItemStack(ModItems.soulManipulator));
		list.add(new ItemStack(ModItems.teleporter));
		
		for(ItemStack stack : list)
				registry.addDescription(stack, I18n.format(stack.getItem().getUnlocalizedName()+".info"));
		
	}

	@Override
	public void onRuntimeAvailable(IJeiRuntime jeiRuntime) {
		// TODO Auto-generated method stub
		
	}

}
