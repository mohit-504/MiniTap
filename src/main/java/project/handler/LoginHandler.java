// LoginHandler.java
package project.handler;

import project.model.Event;
import project.publisher.EventPublisher;

public class LoginHandler implements EventHandler{
    private final EventPublisher eventPublisher;

    public LoginHandler(EventPublisher eventPublisher){
        this.eventPublisher = eventPublisher;
    }

    @Override
    public void handle(Event event) {
        eventPublisher.publish(event);
    }
    
}
