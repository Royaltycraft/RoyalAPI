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
import net.minecraftforge.fml.common.eventhandler.EventBus;

@Mod(modid = ModUtils.MODID, name = ModUtils.NAME, version = ModUtils.VERSION)
public class RoyalAPI {

    public static Logger logger;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        logger = event.getModLog();

		EventBus forgeBus = MinecraftForge.EVENT_BUS;
		forgeBus.register(new RoyaltyEventManager());
		
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {

		logger.info("===== Registering API Packets =====");
    	ModAPIPacket.init();
    	

		logger.info("===== Registering API Events =====");
		EventBus forgeBus = MinecraftForge.EVENT_BUS;
		forgeBus.register(new RoyaltyEventManager());
		
    }

}
