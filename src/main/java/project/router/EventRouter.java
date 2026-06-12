// EventRouter.java
package project.router;

import java.util.Map;

import project.exception.UnsupportedEventException;
import project.handler.EventHandler;
import project.model.Event;
import project.model.EventType;

public class EventRouter {
    private final Map<EventType, EventHandler> handlers;

    public EventRouter(Map<EventType, EventHandler> handlers){
        this.handlers = handlers;
    }

    public void route(Event event){
        EventHandler handler = handlers.get(event.eventType());

        if(handler == null){
            throw new UnsupportedEventException("No handler found for event type "+event.eventType());
        }

        handler.handle(event);
    }
}
