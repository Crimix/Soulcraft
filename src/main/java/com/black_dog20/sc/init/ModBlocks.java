package com.black_dog20.sc.init;

import com.black_dog20.sc.block.BlockSoulcystalOre;
import com.black_dog20.sc.block.CobbleGen;
import com.black_dog20.sc.creativetab.CreativeTabSC;
import com.black_dog20.sc.reference.Reference;

import net.minecraft.block.material.Material;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@GameRegistry.ObjectHolder(Reference.MOD_ID)
public class ModBlocks {

	public static CobbleGen cobbleGen;
	public static BlockSoulcystalOre soulcystalOre;
	
	public static void init() {
		cobbleGen = new CobbleGen(Material.ROCK);
		soulcystalOre = new BlockSoulcystalOre();
	}
	
	@SideOnly(Side.CLIENT)
    public static void initModels() {
    	cobbleGen.initModel();
    	soulcystalOre.initModel();
    }
}
