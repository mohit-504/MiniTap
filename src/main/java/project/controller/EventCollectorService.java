// EventCollectorService.java
package project.controller;

import org.springframework.stereotype.Service;

import project.model.Event;
import project.router.EventRouter;
import project.util.EventMetrics;
// import project.util.Profiler;
import project.util.TenantResolver;
import project.validation.EventValidator;

@Service
public class EventCollectorService {
    private final EventValidator validator;
    private final TenantResolver tenantResolver;
    private final EventRouter router;
    private final EventMetrics metrics;

    public EventCollectorService(EventValidator validator, TenantResolver tenantResolver, EventRouter router, EventMetrics metrics) {
        this.validator = validator;
        this.tenantResolver = tenantResolver;
        this.router = router;
        this.metrics = metrics;
    }

    public void collect(Event event) {

        // Profiler profiler = new Profiler();
        // profiler.start();

        validator.validate(event);
        tenantResolver.resolve(event.tenantId());
        router.route(event);
        metrics.increment(event.eventType());

        // profiler.stop("Event Processing");
    }
}
