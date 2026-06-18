// PurchaseHandler.java
package project.handler;

import org.springframework.stereotype.Component;

import project.model.Event;
import project.model.EventType;
import project.publisher.EventPublisher;

@Component
public class PurchaseHandler implements EventHandler{
    private final EventPublisher eventPublisher;

    public PurchaseHandler(EventPublisher eventPublisher){
        this.eventPublisher = eventPublisher;
    }

    @Override
    public EventType supports() {
        return EventType.PURCHASE;
    }
    
    @Override
    public void handle(Event event) {
        eventPublisher.publish(event);
    }
    
}
