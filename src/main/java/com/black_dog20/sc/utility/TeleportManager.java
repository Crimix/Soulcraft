package com.black_dog20.sc.utility;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.WorldServer;

public class TeleportManager {
	
	public static void teleportToDimension(EntityPlayer player, int dimension, double x, double y, double z, float yaw, float pitch) {
        int oldDimension = player.worldObj.provider.getDimension();
        EntityPlayerMP entityPlayerMP = (EntityPlayerMP) player;
        MinecraftServer server = ((EntityPlayerMP) player).worldObj.getMinecraftServer();
        WorldServer worldServer = server.worldServerForDimension(dimension);
        player.addExperienceLevel(0);

        if(oldDimension != dimension){
        	worldServer.getMinecraftServer().getPlayerList().transferPlayerToDimension(entityPlayerMP, dimension, new SCTeleporter(worldServer, x, y, z));
        }
        player.setPositionAndRotation(x, y, z, yaw, pitch);
        if (oldDimension == 1) {
            // For some reason teleporting out of the end does weird things.
        	player.setPositionAndRotation(x, y, z, yaw, pitch);
            worldServer.spawnEntityInWorld(player);
            worldServer.updateEntityWithOptionalForce(player, false);
        }
    }

}
