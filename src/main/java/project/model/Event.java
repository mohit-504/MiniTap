// Event.java
package project.model;

import java.time.Instant;
import java.util.Map;

import lombok.Builder;

@Builder(toBuilder = true)
public record Event(
    String tenantId,
    EventType eventType,
    String userId,
    Instant timestamp,
    Map<String, Object> payload
) 
{}