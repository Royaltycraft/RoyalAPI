package fr.kintus.royalapi.network;

import fr.kintus.royalapi.utils.ModUtils;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;

/**
 * Simple class managing the registration of custom packets.
 * @author K1ntus
 *
 */
public class ModAPIPacket {
	public static final SimpleNetworkWrapper NETWORK_DISPATCHER = NetworkRegistry.INSTANCE.newSimpleChannel(ModUtils.MODID);

	public static void init() {
		registerPackets();
	}
	

	private static void registerPackets() {
        System.out.println("registering simple networking");

        int packetId = 0;

		NETWORK_DISPATCHER.registerMessage(EmptyPacket.Handler.class, EmptyPacket.class, packetId++, Side.SERVER);
	}	
}
