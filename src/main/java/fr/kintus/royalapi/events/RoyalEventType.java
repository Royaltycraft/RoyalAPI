package fr.kintus.royalapi.events;

public class RoyalEventType<T extends ARoyalEvent>
{
    public static final RoyalEventType<ARoyalEvent> ROOT = new RoyalEventType<>("ROOT", null);
    
    private final String name;
    private final RoyalEventType<? super T> parent;
    
    /**
     * Constructor for the EventType.
     * 
     * @param parent
     *            The parent event
     * @param name
     *            The name of the event
     */
    public RoyalEventType(final RoyalEventType<? super T> parent, final String name)
    {
        if(parent == null)
            throw new IllegalArgumentException("EventType parent cannot be null!");
        if(parent == this) // if true what the hell
            throw new IllegalArgumentException("EventType parent cannot be itself!");
        if(name == null)
            throw new IllegalArgumentException("EventType name cannot be null!");
        if(name.isEmpty())
            throw new IllegalArgumentException("EventType name cannot be empty!");
        this.name = name;
        this.parent = parent;
    }
    
    /**
     * Constructor for the EventType. Parent is {@link #ROOT}.
     * 
     * @param name
     *            The name of the event
     */
    public RoyalEventType(final String name)
    {
        this(RoyalEventType.ROOT, name);
    }
    
    /**
     * Private constructor for root event type.
     * 
     * @param name
     *            The name of the event
     * @param parent
     *            The parent event
     */
    RoyalEventType(final String name, final RoyalEventType<? super T> parent)
    {
        this.name = name;
        this.parent = parent;
    }
    
    /**
     * @return the name of the event type.
     */
    public String getName()
    {
        return this.name;
    }
    
    /**
     * Get the parent of the event type. The parent of {@link #ROOT} is null.
     * 
     * @return return the parent of the event type.
     */
    public RoyalEventType<? super T> getParent()
    {
        return this.parent;
    }
    
    /**
     * Test if this event type is a sub type of a given event type.
     * 
     * @param eventType
     *            The event type to test
     * @return true if the event type is a sub type false else.
     */
    public boolean isSubType(final RoyalEventType<?> eventType)
    {
        if(eventType == this || eventType == RoyalEventType.ROOT || this.getParent() == eventType)
            return true;
        if(this == RoyalEventType.ROOT)
            return false;
        return this.getParent().isSubType(eventType);
    }
    
    @Override
    public String toString()
    {
        return "EventType [name=" + this.name + ", parent=" + (this.parent != null ? this.parent.toString() : "none") + "]";
    }
    
    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + this.name.hashCode();
        result = prime * result + (this.parent == null ? 0 : this.parent.hashCode());
        return result;
    }
    
    @Override
    public boolean equals(final Object obj)
    {
        if(this == obj)
            return true;
        if(obj == null)
            return false;
        if(obj instanceof RoyalEventType)
        {
            final RoyalEventType<?> other = (RoyalEventType<?>)obj;
            
            if(!this.name.equals(other.name))
                return false;
            
            return this.parent.equals(other.parent);
        }
        return false;
    }
}