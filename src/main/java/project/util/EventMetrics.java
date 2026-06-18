// EventMetrics.java 
package project.util;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Component;

import project.model.EventType;

@Component
public class EventMetrics {
    private final Map<EventType, AtomicLong> counters = new ConcurrentHashMap<>();

    public EventMetrics() {
        for (EventType type : EventType.values()) {
            counters.put(type, new AtomicLong());
        }
    }

    public void increment(EventType eventType) {
        counters.get(eventType).incrementAndGet();
    }

    public long getCount(EventType eventType) {
        return counters.get(eventType).get();
    }

    public long getTotalCount() {
        return counters.values()
                .stream()
                .mapToLong(AtomicLong::get)
                .sum();
    }

    public void printMetrics() {
        counters.forEach((type, count) -> System.out.println(type + " -> " + count.get()));

        System.out.println("TOTAL -> " + getTotalCount());
    }
}
