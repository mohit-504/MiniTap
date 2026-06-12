// SessionHandler.java 
package project.handler;

import project.model.Event;
import project.publisher.EventPublisher;

public class SessionHandler implements EventHandler{
    private final EventPublisher eventPublisher;

    public SessionHandler(EventPublisher eventPublisher){
        this.eventPublisher = eventPublisher;
    }

    @Override
    public void handle(Event event) {
        eventPublisher.publish(event);
    }
    
}
