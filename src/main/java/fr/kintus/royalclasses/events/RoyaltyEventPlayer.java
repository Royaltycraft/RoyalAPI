package fr.kintus.royalclasses.events;

import java.util.UUID;

import net.minecraftforge.fml.common.eventhandler.Event;

/**
 * Class managing a custom RoyaltyEvent in order to send player information (from client side to server side).
 * @author K1ntus
 *
 */
public class RoyaltyEventPlayer extends Event {
	/**
	 * The UUID of the player who has casted the event.
	 */
	protected final UUID playerUUID;
	
	private RoyaltyEventPlayer(UUID playerUUID) {
		this.playerUUID = playerUUID;
	}

	/**
	 * Event triggered when a Player Login within a server
	 * @author K1ntus
	 *
	 */
	public static class RoyaltyEventLogin extends RoyaltyEventPlayer {
		
		public RoyaltyEventLogin(final UUID playerUUID) {
			super(playerUUID);
		}
		
		

	}
	
	/**
	 * Event triggered when a Player Log out from a server.
	 * @author K1ntus
	 *
	 */
	public static class RoyaltyEventLogout extends RoyaltyEventPlayer {
		
		public RoyaltyEventLogout(final UUID playerUUID) {
			super(playerUUID);
		}
		
		

	}

	
	/**
	 * Return the UUID of the player who has launched the event.
	 * @return the player UUID
	 */
	public UUID getPlayerUUID() {
		return playerUUID;
	}
}
