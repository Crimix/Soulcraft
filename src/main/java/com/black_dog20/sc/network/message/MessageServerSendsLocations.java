package com.black_dog20.sc.network.message;

import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

import com.black_dog20.sc.sc;
import com.black_dog20.sc.utility.LocationHelper;


public class MessageServerSendsLocations implements IMessage, IMessageHandler<MessageServerSendsLocations, IMessage> {
	private NBTTagCompound nbt;

	private EntityPlayer player;

	@Override
	public IMessage onMessage(MessageServerSendsLocations message, MessageContext context) {

		player = sc.Proxy.getPlayerFromMessageContext(context);
		nbt = message.nbt;
		Minecraft.getMinecraft().addScheduledTask(new Runnable()
		{
			  public void run() {
				  LocationHelper.SetLocationToClientPlayer(player, nbt);
			  }
			});
		return null;
	}

	public MessageServerSendsLocations(NBTTagCompound nbt) {
		this.nbt=nbt;
	}
	
	public MessageServerSendsLocations() {}

	@Override
	public void toBytes(ByteBuf buf) {
		ByteBufUtils.writeTag(buf, nbt);
	}

	@Override
	public void fromBytes(ByteBuf buf) {
		this.nbt = ByteBufUtils.readTag(buf);
	}
}
