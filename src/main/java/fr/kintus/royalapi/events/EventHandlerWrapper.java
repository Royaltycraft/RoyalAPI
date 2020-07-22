package fr.kintus.royalapi.events;

import java.util.ArrayList;
import java.util.List;

public class EventHandlerWrapper<T extends ARoyalEvent>
{
    private final List<IEventHandler<? super T>> eventHandlers;

    public EventHandlerWrapper()
    {
        this.eventHandlers = new ArrayList<>();
    }

    @SuppressWarnings("unchecked")
    public void handle(final ARoyalEvent event)
    {
        final T internalEvent = (T) event;
        this.eventHandlers.forEach(handler -> handler.handle(internalEvent));
    }

    public void addHandler(final IEventHandler<? super T> handler)
    {
        this.eventHandlers.add(handler);
    }

    public void removeHandler(final IEventHandler<? super T> handler)
    {
        this.eventHandlers.remove(handler);
    }

    public boolean containsHandler(final IEventHandler<? super T> handler)
    {
        return this.eventHandlers.contains(handler);
    }
}