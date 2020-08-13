package fr.kintus.royalapi.events;

import java.util.UUID;

import net.minecraftforge.fml.common.eventhandler.Event;

public class RoyaltyEventPlayer extends Event {
	protected final UUID playerUUID;
	
	private RoyaltyEventPlayer(UUID playerUUID) {
		this.playerUUID = playerUUID;
	}

	public static class RoyaltyEventLogin extends RoyaltyEventPlayer {
		
		public RoyaltyEventLogin(final UUID playerUUID) {
			super(playerUUID);
		}
		
		

	}
	
	public static class RoyaltyEventLogout extends RoyaltyEventPlayer {
		
		public RoyaltyEventLogout(final UUID playerUUID) {
			super(playerUUID);
		}
		
		

	}

	public UUID getPlayerUUID() {
		return playerUUID;
	}
}
