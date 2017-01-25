package com.black_dog20.sc.network;

import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;

import com.black_dog20.sc.network.message.*;
import com.black_dog20.sc.reference.Reference;


public class PacketHandler {

	public static final SimpleNetworkWrapper network = NetworkRegistry.INSTANCE.newSimpleChannel(Reference.MOD_ID.toLowerCase());

	public static void init() {
		network.registerMessage(MessagePlayerAddLocation.class, MessagePlayerAddLocation.class, 1, Side.SERVER);
		network.registerMessage(MessagePlayerTeleport.class, MessagePlayerTeleport.class, 2, Side.SERVER);
		network.registerMessage(MessageServerSendsLocations.class, MessageServerSendsLocations.class, 3, Side.CLIENT);
		network.registerMessage(MessagePlayerWantsLocations.class, MessagePlayerWantsLocations.class, 4, Side.SERVER);
		//network.registerMessage(MessageConfigSync.class, MessageConfigSync.class, 5, Side.CLIENT);
	}

}
