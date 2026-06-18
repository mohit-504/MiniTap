// EventValidator.java 

package project.validation;

import org.springframework.stereotype.Component;

import project.exception.InvalidEventException;
import project.model.Event;

@Component
public class EventValidator {

    public void validate(Event event) {

        if (event.payload().isEmpty()) {
            throw new InvalidEventException(
                    "Payload cannot be empty");
        }
    }
}