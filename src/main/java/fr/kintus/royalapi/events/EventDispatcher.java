package fr.kintus.royalapi.events;

import java.util.concurrent.ConcurrentHashMap;

public class EventDispatcher {
    private final ConcurrentHashMap<RoyalEventType<? extends ARoyalEvent>, EventHandlerWrapper<? extends ARoyalEvent>> handlers;

    public EventDispatcher()
    {
        this.handlers = new ConcurrentHashMap<>();
    }

    public void dispatchEvent(final RoyalEventType<? extends ARoyalEvent> type, final ARoyalEvent event)
    {
        this.handlers.forEach((eventType, handler) ->
        {
            if (type == eventType || type.isSubType(eventType))
                handler.handle(event);
        });
    }

    public <T extends ARoyalEvent> void addHandler(final RoyalEventType<T> type, final IEventHandler<? super T> handler)
    {
        final EventHandlerWrapper<T> wrapperHandler = this.internalGetHandler(type);
        wrapperHandler.addHandler(handler);
    }

    @SuppressWarnings("unchecked")
    public <T extends ARoyalEvent> void removeHandler(final RoyalEventType<T> type, final IEventHandler<T> handler)
    {
        final EventHandlerWrapper<T> wrapperHandler = (EventHandlerWrapper<T>) this.handlers.get(type);

        if (wrapperHandler != null)
            wrapperHandler.removeHandler(handler);
    }

    @SuppressWarnings("unchecked")
    private <T extends ARoyalEvent> EventHandlerWrapper<T> internalGetHandler(final RoyalEventType<T> type)
    {
        EventHandlerWrapper<T> wrapperHandler = (EventHandlerWrapper<T>) this.handlers.get(type);
        if (wrapperHandler == null)
        {
            wrapperHandler = new EventHandlerWrapper<>();
            this.handlers.put(type, wrapperHandler);
        }
        return wrapperHandler;
    }
}
