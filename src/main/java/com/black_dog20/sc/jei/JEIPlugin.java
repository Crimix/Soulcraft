package com.black_dog20.sc.jei;

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
		registry.addDescription(new ItemStack(ModBlocks.cobbleGen), "Right-click to get ONE cobblestone");
		
	}

	@Override
	public void onRuntimeAvailable(IJeiRuntime jeiRuntime) {
		// TODO Auto-generated method stub
		
	}

}
