package fr.kintus.royalclasses.network;

import io.netty.buffer.ByteBuf;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

/**
 * An empty Packet sample. It would allows the server to get a player UUID in specific situation
 * since a packet contains this informations.
 * @author K1ntus
 *
 */
public class EmptyPacket implements IMessage {
	
	    
	    private String text;

	    /**
	     * Instantiates a new message to server.
	     */
	    public EmptyPacket() 
	    { 
	    	// need this constructor
	    }

	    /**
	     * Instantiates a new message to server.
	     *
	     * @param parText the par text
	     */
	    public EmptyPacket(String parText) 
	    {
	        text = parText;
	        // DEBUG
	        System.out.println("MyMessage constructor");
	    }

	    /* (non-Javadoc)
	     * @see net.minecraftforge.fml.common.network.simpleimpl.IMessage#fromBytes(io.netty.buffer.ByteBuf)
	     */
	    @Override
	    public void fromBytes(ByteBuf buf) 
	    {
	        text = ByteBufUtils.readUTF8String(buf); // this class is very useful in general for writing more complex objects
	    	// DEBUG
	    	System.out.println("fromBytes = "+text);
	    }

	    /* (non-Javadoc)
	     * @see net.minecraftforge.fml.common.network.simpleimpl.IMessage#toBytes(io.netty.buffer.ByteBuf)
	     */
	    @Override
	    public void toBytes(ByteBuf buf) 
	    {
	        ByteBufUtils.writeUTF8String(buf, text);
	        // DEBUG
	        System.out.println("toBytes = "+text);
	    }

	    public static class Handler implements IMessageHandler<EmptyPacket, IMessage> 
	    {
	        
			/* (non-Javadoc)
			 * @see net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler#onMessage(net.minecraftforge.fml.common.network.simpleimpl.IMessage, net.minecraftforge.fml.common.network.simpleimpl.MessageContext)
			 */
			@Override
			public IMessage onMessage(EmptyPacket message, MessageContext ctx) 
			{
	            System.out.println(String.format("Received %s from %s", message.text, ctx.getServerHandler().player));
				return null;
			}
	    }
	

}
