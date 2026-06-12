// PurchaseHandler.java
package project.handler;

import project.model.Event;
import project.publisher.EventPublisher;

public class PurchaseHandler implements EventHandler{
    private final EventPublisher eventPublisher;

    public PurchaseHandler(EventPublisher eventPublisher){
        this.eventPublisher = eventPublisher;
    }

    @Override
    public void handle(Event event) {
        eventPublisher.publish(event);
    }
    
}
