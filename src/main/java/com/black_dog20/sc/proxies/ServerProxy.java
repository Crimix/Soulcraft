package com.black_dog20.sc.proxies;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class ServerProxy extends CommonProxy {

	@Override
	public void registerKeyBindings() {
		// NOOP

	}

	@Override
	public void keyinput() {
		// TODO Auto-generated method stub

	}

	@Override
	public EntityPlayer getPlayerFromMessageContext(MessageContext ctx) {
		return ctx.getServerHandler().playerEntity;
	}

	@Override
	public EntityPlayer getPlayerByIDFromMessageContext(int id, MessageContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void registerRenders() {
		// TODO Auto-generated method stub

	}

	@Override
	public void ServerRecipes() {
		// TODO Auto-generated method stub

	}
}
