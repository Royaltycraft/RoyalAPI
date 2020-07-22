package fr.kintus.royalapi.events.handler;

import fr.kintus.royalapi.RoyalAPI;
import fr.kintus.royalapi.events.RoyaltyEventLogin;
import fr.kintus.royalapi.events.RoyaltyEventLogout;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;


public class RoyaltyEventManager {


	@SubscribeEvent(priority = EventPriority.HIGHEST)
	public void onPlayerLogin(final PlayerEvent.PlayerLoggedInEvent e) {
		RoyalAPI.logger.info("Fired player login event");
		MinecraftForge.EVENT_BUS.post(new RoyaltyEventLogin(e.player.getUniqueID()));

	}


	@SubscribeEvent(priority = EventPriority.HIGHEST)
	public void onPlayerLogout(final PlayerEvent.PlayerLoggedOutEvent e) {
		RoyalAPI.logger.info("Fired player logout event");
		MinecraftForge.EVENT_BUS.post(new RoyaltyEventLogout(e.player.getUniqueID()));
	}

    
}
