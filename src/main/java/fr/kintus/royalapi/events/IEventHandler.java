package fr.kintus.royalapi.events;


@FunctionalInterface
public interface IEventHandler<T extends ARoyalEvent>
{
    void handle(T event);
}