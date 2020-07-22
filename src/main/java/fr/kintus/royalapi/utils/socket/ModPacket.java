package fr.kintus.royalapi.utils.socket;

import fr.kintus.royalapi.utils.ModUtils;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;

public class ModPacket {
	public static final SimpleNetworkWrapper NETWORK_DISPATCHER = NetworkRegistry.INSTANCE.newSimpleChannel(ModUtils.MODID);

	public static void init() {
		registerPackets();
	}
	

	private static void registerPackets() {
        System.out.println("registering simple networking");

        int packetId = 0;
        NETWORK_DISPATCHER.registerMessage(PacketDeflective.Handler.class, PacketDeflective.class, packetId++, Side.SERVER);
	}


}
