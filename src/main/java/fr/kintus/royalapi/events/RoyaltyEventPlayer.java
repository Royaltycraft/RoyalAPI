package fr.kintus.royalapi.events;

import java.util.UUID;

import net.minecraftforge.fml.common.eventhandler.Event;

public abstract class RoyaltyEventPlayer extends Event {
	protected UUID playerUUID = null;
	
	private RoyaltyEventPlayer() {
		super.setup();
//		MinecraftForge.EVENT_BUS.register(this);
	}

	public static class RoyaltyEventLogin extends RoyaltyEventPlayer {
		
		public RoyaltyEventLogin(final UUID playerUUID) {
			super();
			
			this.playerUUID  = playerUUID;
		}
		
		
		public UUID getPlayerUUID() {
			return playerUUID;
		}
		public void setPlayerUUID(UUID playerUUID) {
			this.playerUUID = playerUUID;
		}

	}
	
	public static class RoyaltyEventLogout extends RoyaltyEventPlayer {
		
		public RoyaltyEventLogout(final UUID playerUUID) {
			super();
			
			this.playerUUID  = playerUUID;
		}
		
		
		public UUID getPlayerUUID() {
			return playerUUID;
		}
		public void setPlayerUUID(UUID playerUUID) {
			this.playerUUID = playerUUID;
		}

	}

}
