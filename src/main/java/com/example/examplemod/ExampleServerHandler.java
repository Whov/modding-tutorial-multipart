package com.example.examplemod;

import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.network.play.INetHandlerPlayServer;
import codechicken.lib.packet.PacketCustom;
import codechicken.lib.packet.PacketCustom.IServerPacketHandler;

public class ExampleServerHandler implements IServerPacketHandler {

	public static Object channel = ExampleMod.instance;

    @Override
    public void handlePacket(PacketCustom packet, EntityPlayerMP sender, INetHandlerPlayServer netHandler) {
        switch (packet.getType()) {
            case 1:
                ExampleEventHandler.place(sender, sender.worldObj);
                break;
        }
    }
	
}
