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


public class MessagePlayerTeleport implements IMessage, IMessageHandler<MessagePlayerTeleport, IMessage> {
	private int dim;
	private double x,y,z;
	private float yaw, pitch;
	private EntityPlayer player;

	@Override
	public IMessage onMessage(MessagePlayerTeleport message, MessageContext context) {
		dim = message.dim;
		x = message.x;
		y = message.y;
		z = message.z;
		yaw = message.yaw;
		pitch = message.pitch;
		player = sc.Proxy.getPlayerFromMessageContext(context);
		FMLCommonHandler.instance().getMinecraftServerInstance().addScheduledTask(new Runnable()
		{
			  public void run() {
				  TeleportManager.teleportToDimension(player, dim, x, y, z, yaw, pitch);
			  }
			});
		return null;
	}

	public MessagePlayerTeleport(int dim, double x, double y, double z, float yaw, float pitch) {
		this.dim=dim;
		this.x=x;
		this.y=y;
		this.z=z;
		this.yaw = yaw;
		this.pitch = pitch;
	}
	
	public MessagePlayerTeleport() {}

	@Override
	public void toBytes(ByteBuf buf) {
		buf.writeInt(dim);
		buf.writeDouble(x);
		buf.writeDouble(y);
		buf.writeDouble(z);
		buf.writeFloat(yaw);
		buf.writeFloat(pitch);
	}

	@Override
	public void fromBytes(ByteBuf buf) {
		this.dim = buf.readInt();
		this.x = buf.readDouble();
		this.y = buf.readDouble();
		this.z = buf.readDouble();
		this.yaw = buf.readFloat();
		this.pitch = buf.readFloat();
	}
}
