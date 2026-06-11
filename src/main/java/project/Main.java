package project;

import java.time.Instant;
import java.util.Map;

import project.model.Event;
import project.model.EventType;

public class Main {
    public static void main(String[] args) {

        Event event = Event.builder()
                .tenantId("tenant-1")
                .eventType(EventType.LOGIN)
                .userId("user-101")
                .timestamp(Instant.now())
                .payload(Map.of(
                        "device", "android",
                        "appVersion", "1.0"))
                .build();

        System.out.println(event);
    }
}
