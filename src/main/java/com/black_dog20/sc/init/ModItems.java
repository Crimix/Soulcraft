package com.black_dog20.sc.init;

import com.black_dog20.sc.item.ItemSoulcystal;
import com.black_dog20.sc.item.ItemTeleport;
import com.black_dog20.sc.reference.Reference;

import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@GameRegistry.ObjectHolder(Reference.MOD_ID)
public class ModItems {
	
	public static ItemTeleport teleporter;
	public static ItemSoulcystal soulcystal;
	
	public static void init() {
		teleporter = new ItemTeleport();
		soulcystal = new ItemSoulcystal();
	}
	
    @SideOnly(Side.CLIENT)
    public static void initModels() {
    	teleporter.initModel();
    	soulcystal.initModel();
    }

}
