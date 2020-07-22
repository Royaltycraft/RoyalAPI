package fr.kintus.royalapi.events;

import java.util.UUID;

import net.minecraftforge.fml.common.eventhandler.Event;

public class RoyaltyEventLogin extends Event {
	private UUID playerUUID = null;
	
	public RoyaltyEventLogin(final UUID playerUUID) {
		this.playerUUID  = playerUUID;
	}
	
	
	public UUID getPlayerUUID() {
		return playerUUID;
	}
	public void setPlayerUUID(UUID playerUUID) {
		this.playerUUID = playerUUID;
	}

}