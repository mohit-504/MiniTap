// KafkaEventPublisher.java
package project.publisher;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import project.model.Event;

@Component
public class KafkaEventPublisher implements EventPublisher {

    private final KafkaTemplate<String, Event> kafkaTemplate;

    public KafkaEventPublisher(KafkaTemplate<String, Event> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public void publish(Event event) {
        try {
            kafkaTemplate.send("events",event.userId(),event).get();
        } catch (Exception e) {
            throw new RuntimeException("Failed to publish event", e);
        }
    }
}