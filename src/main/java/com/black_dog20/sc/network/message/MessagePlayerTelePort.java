package com.black_dog20.sc.network.message;

import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.WorldServer;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

import com.black_dog20.sc.sc;
import com.black_dog20.sc.handler.ConfigurationHandler;
import com.black_dog20.sc.utility.TeleportManager;


public class MessagePlayerTelePort implements IMessage, IMessageHandler<MessagePlayerTelePort, IMessage> {
	int dim;
	double x,y,z;
	EntityPlayer player;

	@Override
	public IMessage onMessage(MessagePlayerTelePort message, MessageContext context) {
		dim = message.dim;
		x = message.x;
		y = message.y;
		z = message.z;
		player = sc.Proxy.getPlayerFromMessageContext(context);
		FMLCommonHandler.instance().getMinecraftServerInstance().addScheduledTask(new Runnable()
		{
			  public void run() {
				  TeleportManager.teleportToDimension(player, dim, x, y, z);
			  }
			});
		return null;
	}

	public MessagePlayerTelePort(int dim, double x, double y, double z) {
		this.dim=dim;
		this.x=x;
		this.y=y;
		this.z=z;
	}
	
	public MessagePlayerTelePort() {}

	@Override
	public void toBytes(ByteBuf buf) {
		buf.writeInt(dim);
		buf.writeDouble(x);
		buf.writeDouble(y);
		buf.writeDouble(z);
	}

	@Override
	public void fromBytes(ByteBuf buf) {
		this.dim = buf.readInt();
		this.x = buf.readDouble();
		this.y = buf.readDouble();
		this.z = buf.readDouble();
	}
}
