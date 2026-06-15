// KafkaEventPublisher.java 
package project.publisher;

import project.model.Event;

public class KafkaEventPublisher implements EventPublisher {

    @Override
    public void publish(Event event) {
        //no-op
        // System.out.println("[KAFKA] Published Event -> "+ event);
    }
}