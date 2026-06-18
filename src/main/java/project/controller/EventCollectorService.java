// EventCollectorService.java
package project.controller;

import org.springframework.stereotype.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import project.model.Event;
import project.router.EventRouter;
import project.util.EventMetrics;
import project.util.Profiler;
// import project.util.Profiler;
import project.util.TenantResolver;
import project.validation.EventValidator;

@Service
public class EventCollectorService {
    private final EventValidator validator;
    private final TenantResolver tenantResolver;
    private final EventRouter router;
    private final EventMetrics metrics;
    private static final Logger log = LoggerFactory.getLogger(EventCollectorService.class);

    public EventCollectorService(EventValidator validator, TenantResolver tenantResolver, EventRouter router, EventMetrics metrics) {
        this.validator = validator;
        this.tenantResolver = tenantResolver;
        this.router = router;
        this.metrics = metrics;
    }

    public void collect(Event event) {

        // Profiler profiler = new Profiler();
        // profiler.start();

        log.info("event_received tenantId={} eventType={} userId={}",
                event.tenantId(),
                event.eventType(),
                event.userId());

        validator.validate(event);
        tenantResolver.resolve(event.tenantId());
        router.route(event);
        metrics.increment(event.eventType());

        log.info("event_processed tenantId={} eventType={}",
                event.tenantId(),
                event.eventType());

        // profiler.stop("Event Processing");
    }
}
