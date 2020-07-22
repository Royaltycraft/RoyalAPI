package fr.kintus.royalapi.events.register;

import fr.kintus.royalapi.events.ARoyalEvent;
import fr.kintus.royalapi.events.IEventHandler;
import fr.kintus.royalapi.events.RoyalEventType;

public class RegisterEvents implements IEventHandler {

	public static final RoyalEventType<ARoyalEvent> login_event 	= new RoyalEventType<>(RoyalEventType.ROOT, "royalapi_user_login");
	public static final RoyalEventType<ARoyalEvent> logout_event	= new RoyalEventType<>(RoyalEventType.ROOT, "royalapi_user_login");
	
	public static void init() {
//		RoyalAPI.ROYALTY_EVENT_HANDLER.addHandler(handler);
		
	}

	@Override
	public void handle(ARoyalEvent event) {
		// TODO Auto-generated method stub
		
	}
}
