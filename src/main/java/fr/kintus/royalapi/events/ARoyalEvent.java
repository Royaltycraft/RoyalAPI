package fr.kintus.royalapi.events;

public abstract class ARoyalEvent
{
    private final IEventEmitter source;

    public  ARoyalEvent(final IEventEmitter source)
    {
        this.source = source;
    }

    public IEventEmitter getSource()
    {
        return this.source;
    }

    public  ARoyalEvent copy()
    {
        return this.copy(source);
    }

    public abstract  ARoyalEvent copy(IEventEmitter source);
}