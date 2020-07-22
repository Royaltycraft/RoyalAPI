package fr.kintus.royalapi.utils.socket;

import java.sql.Connection;
import java.util.UUID;

import fr.kintus.royalapi.RoyalSaver;
import fr.kintus.royalapi.utils.database.DatabaseQueryExecuter;
import io.netty.buffer.ByteBuf;
import net.minecraft.util.IThreadListener;
import net.minecraft.world.WorldServer;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class PacketDeflective implements IMessage {
	public PacketDeflective() {
		
	}

	

	public void fromBytes(final ByteBuf buffer) {

	}

	public void toBytes(final ByteBuf buffer) {

	}

	public static class Handler implements IMessageHandler<PacketDeflective, IMessage> {
		  // Do note that the default constructor is required, but implicitly defined in this case

		UUID uuid = null;
		
		@Override public IMessage onMessage(PacketDeflective message, MessageContext ctx) {
			  
				
			IThreadListener mainThread = (WorldServer) ctx.getServerHandler().player.world; 

			mainThread.addScheduledTask(new Runnable() 
			{
				@Override
				public void run()  {
					uuid = ctx.getServerHandler().player.getUniqueID();
					
					Connection conn = RoyalSaver.database.getConnection();
					
					boolean isFirstLogin = DatabaseQueryExecuter.isPlayerFirstLogin(conn, uuid);
					
					if(isFirstLogin) { 	
						// Init database
						DatabaseQueryExecuter.onNewPlayerLogin(conn, uuid);
						
					} else {	
						// Read informations
						DatabaseQueryExecuter.onOldPlayerLogin(conn, uuid);
					}
				}
			});
		    // No response packet
			return null;
		}
		
	}
}