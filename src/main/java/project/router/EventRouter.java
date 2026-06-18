// EventRouter.java
package project.router;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import project.exception.UnsupportedEventException;
import project.handler.EventHandler;
import project.model.Event;
import project.model.EventType;

@Component
public class EventRouter {
    private final Map<EventType, EventHandler> handlers;

    public EventRouter(List<EventHandler> handlerList) {
        this.handlers = handlerList.stream().collect(Collectors.toMap(EventHandler::supports, Function.identity()));
    }

    public void route(Event event){
        EventHandler handler = handlers.get(event.eventType());

        if(handler == null){
            throw new UnsupportedEventException("No handler found for event type "+event.eventType());
        }

        handler.handle(event);
    }
}
