package com.black_dog20.sc.network.message;

import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.WorldServer;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

import com.black_dog20.sc.sc;
import com.black_dog20.sc.handler.ConfigurationHandler;
import com.black_dog20.sc.utility.LocationHelper;
import com.black_dog20.sc.utility.TeleportManager;


public class MessagePlayerWantsLocations implements IMessage, IMessageHandler<MessagePlayerWantsLocations, IMessage> {
	private EntityPlayer player;

	@Override
	public IMessage onMessage(MessagePlayerWantsLocations message, MessageContext context) {

		player = sc.Proxy.getPlayerFromMessageContext(context);
		
		return new MessageServerSendsLocations(LocationHelper.GetLocationsFromServerPlayer(player));
	}

	public MessagePlayerWantsLocations() {}

	@Override
	public void toBytes(ByteBuf buf) {
	}

	@Override
	public void fromBytes(ByteBuf buf) {
	}
}
