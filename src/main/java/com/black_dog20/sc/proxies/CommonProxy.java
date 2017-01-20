package com.black_dog20.sc.proxies;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

import com.black_dog20.sc.sc;
import com.black_dog20.sc.handler.GuiHandler;


public abstract class CommonProxy implements IProxy {

	public void registerNetworkStuff() {
		NetworkRegistry.INSTANCE.registerGuiHandler(sc.instance, new GuiHandler());
	}

	public EntityPlayer getPlayerFromMessageContext(MessageContext ctx) {
		switch (ctx.side) {
		case CLIENT: {
			assert false : "Message for CLIENT received on dedicated server";
		}
		case SERVER: {
			EntityPlayer entityPlayerMP = ctx.getServerHandler().playerEntity;
			return entityPlayerMP;
		}
		default:
			assert false : "Invalid side in TestMsgHandler: " + ctx.side;
		}
		return null;

	}

	public void render() {

	}
}
