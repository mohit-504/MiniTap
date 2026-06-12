// Main.java 
package project;

import java.time.Instant;
import java.util.Map;

import project.model.Event;
import project.model.EventType;
import project.publisher.EventPublisher;
import project.publisher.KafkaEventPublisher;

public class Main {
    public static void main(String[] args) {
        Event event =
                Event.builder()
                     .tenantId("tenant-1")
                     .eventType(EventType.LOGIN)
                     .userId("u1")
                     .timestamp(Instant.now())
                     .payload(Map.of(
                             "device",
                             "android"))
                     .build();

        EventPublisher publisher =
                new KafkaEventPublisher();

        publisher.publish(event);

    }
    
}
