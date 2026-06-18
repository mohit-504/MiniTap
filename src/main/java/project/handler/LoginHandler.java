// LoginHandler.java
package project.handler;

import org.springframework.stereotype.Component;

import project.model.Event;
import project.model.EventType;
import project.publisher.EventPublisher;

@Component
public class LoginHandler implements EventHandler{
    private final EventPublisher eventPublisher;

    public LoginHandler(EventPublisher eventPublisher){
        this.eventPublisher = eventPublisher;
    }

    @Override
    public EventType supports() {
        return EventType.LOGIN;
    }

    @Override
    public void handle(Event event) {
        eventPublisher.publish(event);
    }
    
}
