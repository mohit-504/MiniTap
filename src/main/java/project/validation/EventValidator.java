// EventValidator.java 

package project.validation;

import project.exception.InvalidEventException;
import project.model.Event;

public class EventValidator {

    public void validate(Event event) {

        if (event == null) {
            throw new InvalidEventException(
                    "Event cannot be null");
        }

        if (event.tenantId() == null ||
            event.tenantId().isBlank()) {

            throw new InvalidEventException(
                    "TenantId is required");
        }

        if (event.userId() == null ||
            event.userId().isBlank()) {

            throw new InvalidEventException(
                    "UserId is required");
        }

        if (event.eventType() == null) {
            throw new InvalidEventException(
                    "EventType is required");
        }

        if (event.timestamp() == null) {
            throw new InvalidEventException(
                    "Timestamp is required");
        }

        if (event.payload() == null) {
            throw new InvalidEventException(
                    "Payload is required");
        }
    }
}
