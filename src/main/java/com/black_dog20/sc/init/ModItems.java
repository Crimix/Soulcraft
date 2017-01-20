package com.black_dog20.sc.init;

import com.black_dog20.sc.item.ItemTeleport;
import com.black_dog20.sc.reference.Reference;

import net.minecraftforge.fml.common.registry.GameRegistry;

@GameRegistry.ObjectHolder(Reference.MOD_ID)
public class ModItems {
	
	public static ItemTeleport teleporter;
	
	public static void init() {

		teleporter = new ItemTeleport();
		
	}

}
