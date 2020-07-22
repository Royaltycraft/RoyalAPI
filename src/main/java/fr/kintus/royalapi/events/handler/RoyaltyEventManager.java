package fr.kintus.royalapi.events.handler;

import fr.kintus.royalapi.RoyalAPI;
import fr.kintus.royalapi.events.RoyaltyEventPlayer.RoyaltyEventLogin;
import fr.kintus.royalapi.events.RoyaltyEventPlayer.RoyaltyEventLogout;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;


public class RoyaltyEventManager {


	@SubscribeEvent(priority = EventPriority.HIGHEST)
	public void onPlayerLogin(final PlayerEvent.PlayerLoggedInEvent e) {  		
		RoyalAPI.logger.info("Fired player login event");
		boolean res = MinecraftForge.EVENT_BUS.post(new RoyaltyEventLogin(e.player.getUniqueID()));
		
		if(res == false) {
			
			RoyalAPI.logger.info("---> CANCELLED");
		}
	}

	@SubscribeEvent(priority = EventPriority.HIGHEST)
	public void onPlayerLogin(final RoyaltyEventLogin.RoyaltyEventLogin e) {
//  		if(!e.player.world.isRemote) {
//  			return;
//  		}
  		
  		
		RoyalAPI.logger.info("hooked player login event");
	}

	@SubscribeEvent(priority = EventPriority.HIGHEST)
	public void onPlayerLogout(final RoyaltyEventLogin.RoyaltyEventLogout e) {
//  		if(!e.player.world.isRemote) {
//  			return;
//  		}
  		
  		
		RoyalAPI.logger.info("Fired player logout event");
	}

    
}
