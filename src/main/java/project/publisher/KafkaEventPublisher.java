// KafkaEventPublisher.java 
package project.publisher;

import org.springframework.stereotype.Component;

import project.model.Event;

@Component
public class KafkaEventPublisher implements EventPublisher {

    @Override
    public void publish(Event event) {
        //no-op
    }
}