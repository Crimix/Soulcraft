package com.black_dog20.sc.proxies;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import net.minecraftforge.fml.relauncher.Side;

import com.black_dog20.sc.client.settings.Keybindings;
import com.black_dog20.sc.client.handler.KeyInputEventHandler;
import com.black_dog20.sc.init.ModBlocks;
import com.black_dog20.sc.init.ModItems;


public class ClientProxy extends CommonProxy {

	@Override
	public void registerKeyBindings() {
		ClientRegistry.registerKeyBinding(Keybindings.START);
		ClientRegistry.registerKeyBinding(Keybindings.DOWN);
		ClientRegistry.registerKeyBinding(Keybindings.VTOL);
	}

	@Override
	public void keyinput() {
		FMLCommonHandler.instance().bus().register(new KeyInputEventHandler());
	}

	@Override
	public EntityPlayer getPlayerFromMessageContext(MessageContext ctx) {
		switch (ctx.side) {
		case CLIENT:
			EntityPlayer entityClientPlayerMP = Minecraft.getMinecraft().thePlayer;
			return entityClientPlayerMP;
		case SERVER:
			EntityPlayer entityPlayerMP = ctx.getServerHandler().playerEntity;
			return entityPlayerMP;
		}
		return null;
	}

	@Override
	public EntityPlayer getPlayerByIDFromMessageContext(int id, MessageContext ctx) {
		if (ctx.side == Side.CLIENT) {
			EntityPlayer entityClientPlayerMP = (EntityPlayer) Minecraft.getMinecraft().theWorld.getEntityByID(id);
			return entityClientPlayerMP;
		}
		return null;
	}

	@Override
	public void registerRenders() {
		ModItems.initModels();
		ModBlocks.initModels();
	}

	@Override
	public void ServerRecipes() {
//		TucsRegistry.RemoveRecipe(ModItems.Unbreaking3Upgrade);
//		Recipes.Upgrades();
//
//		LogHelper.info("removed " + TucsRegistry.number + " recipes");
//		TucsRegistry.number = 0;
	}


}
