// EventConsumer.java
package project.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import project.model.Event;

@Component
public class EventConsumer {
    private static final Logger log = LoggerFactory.getLogger(EventConsumer.class);

    @KafkaListener(topics="events", groupId = "event-processors")
    public void consume(Event event){
        log.info("event_consumed tenantId={} eventType={} userId={}",
                event.tenantId(),
                event.eventType(),
                event.userId());
    }

}
