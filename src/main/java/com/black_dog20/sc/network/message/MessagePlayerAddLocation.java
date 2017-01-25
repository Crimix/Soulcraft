package com.black_dog20.sc.network.message;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

import com.black_dog20.sc.sc;
import com.black_dog20.sc.utility.LocationHelper;


public class MessagePlayerAddLocation implements IMessage, IMessageHandler<MessagePlayerAddLocation, IMessage> {
	private String name;

	private EntityPlayer player;

	@Override
	public IMessage onMessage(MessagePlayerAddLocation message, MessageContext context) {

		player = sc.Proxy.getPlayerFromMessageContext(context);
		name = message.name;
		FMLCommonHandler.instance().getMinecraftServerInstance().addScheduledTask(new Runnable()
		{
			  public void run() {
				  LocationHelper.AddLocation(player, name);
				  
			  }
			});
		return null;
	}

	public MessagePlayerAddLocation(String name) {
		this.name=name;
	}
	
	public MessagePlayerAddLocation() {}

	@Override
	public void toBytes(ByteBuf buf) {
		ByteBufUtils.writeUTF8String(buf, name);
	}

	@Override
	public void fromBytes(ByteBuf buf) {
		this.name = ByteBufUtils.readUTF8String(buf);
	}
}
