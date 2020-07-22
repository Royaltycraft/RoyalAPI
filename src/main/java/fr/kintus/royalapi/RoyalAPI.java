package fr.kintus.royalapi;

import org.apache.logging.log4j.Logger;

import fr.kintus.royalapi.events.ARoyalEvent;
import fr.kintus.royalapi.events.EventHandlerWrapper;
import fr.kintus.royalapi.utils.ModUtils;
import fr.kintus.royalapi.utils.socket.ModPacket;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = ModUtils.MODID, name = ModUtils.NAME, version = ModUtils.VERSION)
public class RoyalAPI {

	public static EventHandlerWrapper<ARoyalEvent> ROYALTY_EVENT_HANDLER = new EventHandlerWrapper<ARoyalEvent>();
    public static Logger logger;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        logger = event.getModLog();

		RoyalAPI.logger.info("===== Registering Packets =====");
    	ModPacket.init();
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
    	
    }
}
