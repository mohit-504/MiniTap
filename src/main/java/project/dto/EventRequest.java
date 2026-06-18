// EventRequest.java
package project.dto;

import java.time.Instant;
import java.util.Map;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import project.model.EventType;

public record EventRequest(

    @NotBlank(message = "TenantId is required")
    String tenantId,

    @NotNull(message = "EventType is required")
    EventType eventType,

    @NotBlank(message = "UserId is required")
    String userId,

    @NotNull(message = "Timestamp is required")
    Instant timestamp,

    @NotNull(message = "Payload is required")
    Map<String, Object> payload

) {}