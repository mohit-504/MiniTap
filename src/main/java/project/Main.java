// Main.java 
package project;

import java.time.Instant;
import java.util.Map;

import project.model.Event;
import project.model.EventType;
import project.validation.EventValidator;

public class Main {
    public static void main(String[] args) {
        Event event1 = Event.builder()
                        .tenantId("t1")
                        .eventType(EventType.LOGIN)
                        .userId("u1")
                        .timestamp(Instant.now())
                        .payload(Map.of("device", "ios"))
                        .build();

        EventValidator validator = new EventValidator();
        validator.validate(event1);

        Event event2 = Event.builder()
                        .tenantId(null)
                        .eventType(EventType.LOGIN)
                        .userId("u1")
                        .timestamp(Instant.now())
                        .payload(Map.of("device", "ios"))
                        .build();
        validator.validate(event2);

    }
    
}
