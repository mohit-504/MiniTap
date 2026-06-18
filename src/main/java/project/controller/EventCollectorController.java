// EventCollectorController.java
package project.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.validation.Valid;

import project.dto.EventRequest;
import project.model.Event;


@RestController
@RequestMapping("/events")
public class EventCollectorController {
    private final EventCollectorService service;

    public EventCollectorController(EventCollectorService service){
        this.service = service;
    }
    
    @PostMapping
    public ResponseEntity<String> collect(@Valid @RequestBody EventRequest request) {

        Event event = Event.builder()
                .tenantId(request.tenantId())
                .eventType(request.eventType())
                .userId(request.userId())
                .timestamp(request.timestamp())
                .payload(request.payload())
                .build();

        service.collect(event);

        return ResponseEntity.ok("Event Accepted");
    }
}
