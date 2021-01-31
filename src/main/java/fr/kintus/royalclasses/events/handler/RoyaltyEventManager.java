package fr.kintus.royalclasses.events.handler;

import fr.kintus.royalclasses.RoyalClasses;
import fr.kintus.royalclasses.events.RoyaltyEventPlayer.RoyaltyEventLogin;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;

/**
 * Hooks the forge system to the custom Events.
 * @author K1ntus
 *
 */
public class RoyaltyEventManager {

	/**
	 * Forge Event triggered client-side when a player is logging in a server. It will send a new event to the server-side
	 * containing the client UUID.
	 * @param event
	 */
	@SubscribeEvent(priority = EventPriority.HIGHEST)
	public void onPlayerLogin(final PlayerEvent.PlayerLoggedInEvent event) {
		if(event.player.world.isRemote) { return; }
		RoyalClasses.logger.info("API Fired player login event");
		boolean res = MinecraftForge.EVENT_BUS.post(new RoyaltyEventLogin(event.player.getUniqueID()));
		
		if(res == false) {
			
			RoyalClasses.logger.info("---> CANCELLED");
		}
	}

	/**
	 * Forge Event triggered client-side when a player is logging out in a server. It will send a new event to the server-side
	 * containing the client UUID.
	 * @param event
	 */
	@SubscribeEvent(priority = EventPriority.HIGHEST)
	public void onPlayerLogout(final PlayerEvent.PlayerLoggedOutEvent event) {
		if(event.player.world.isRemote) { return; }

		RoyalClasses.logger.info("API Fired player logout event");
		boolean res = MinecraftForge.EVENT_BUS.post(new RoyaltyEventLogin(event.player.getUniqueID()));
		
		if(res == false) {
			
			RoyalClasses.logger.info("---> CANCELLED");
		}
	}


	/**
	 * Sample simulating the hooking of the custom event. 
	 * Currently here for tests purposes.
	 * @param e
	 */
	@SubscribeEvent(priority = EventPriority.HIGHEST)
	public void onPlayerLogin(final RoyaltyEventLogin.RoyaltyEventLogin e) {
		RoyalClasses.logger.info("API hooked player login event");
	}


	/**
	 * Sample simulating the hooking of the custom event. 
	 * Currently here for tests purposes.
	 * @param e
	 */
	@SubscribeEvent(priority = EventPriority.HIGHEST)
	public void onPlayerLogout(final RoyaltyEventLogin.RoyaltyEventLogout e) {
		RoyalClasses.logger.info("API hooked player login event");
	}
}
