// EventHandler.java
package project.handler;

import project.model.Event;
import project.model.EventType;

public interface EventHandler {
    EventType supports();
    void handle(Event event);
}
