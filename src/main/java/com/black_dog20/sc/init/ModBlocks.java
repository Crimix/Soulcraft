package com.black_dog20.sc.init;

import com.black_dog20.sc.block.CobbleGen;
import com.black_dog20.sc.creativetab.CreativeTabSC;
import com.black_dog20.sc.reference.Reference;

import net.minecraft.block.material.Material;
import net.minecraftforge.fml.common.registry.GameRegistry;

@GameRegistry.ObjectHolder(Reference.MOD_ID)
public class ModBlocks {

	//public static final BlockAncientTable ancientTable = new BlockAncientTable();
	
	public static final CobbleGen cobbleGen = new CobbleGen(Material.ROCK);
	
	@SuppressWarnings("deprecation")
	public static void init() {
		//GameRegistry.registerBlock(ancientTable, "ancientTable");
	}
}
