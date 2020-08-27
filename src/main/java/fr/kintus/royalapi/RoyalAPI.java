package fr.kintus.royalapi;

import org.apache.logging.log4j.Logger;

import fr.kintus.royalapi.events.handler.RoyaltyEventManager;
import fr.kintus.royalapi.network.ModAPIPacket;
import fr.kintus.royalapi.utils.ModUtils;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;


/**
 * Main Class managing the common side (Both Client & Server)
 * @author K1ntus
 *
 */
@Mod(modid = ModUtils.MODID, name = ModUtils.NAME, version = ModUtils.VERSION)
public class RoyalAPI {

	
	/**
	 * Used by modders
	 * @return The event bus where you register RoyaltyEvents
	 */
//	public static EventBus royaltyEventBus = new EventBus();
	
	/**
	 * Log4j Logger
	 */
    public static Logger logger;

    /**
     * Pre-initialization Forge Event. Used to register custom events used across different dependencies.
     * @param event
     */
    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        logger = event.getModLog();
        
        
		logger.info("===== Registering API Packets =====");
    	ModAPIPacket.init();
    	
		logger.info("===== Registering API Events =====");
		MinecraftForge.EVENT_BUS.register(new RoyaltyEventManager());
        
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {

    }

}
