// Main.java
package project;

import java.time.Instant;
import java.util.Map;

import project.controller.EventCollectorService;
import project.handler.EventHandler;
import project.handler.LoginHandler;
import project.handler.PurchaseHandler;
import project.handler.SessionHandler;
import project.model.Event;
import project.model.EventType;
import project.publisher.EventPublisher;
import project.publisher.KafkaEventPublisher;
import project.router.EventRouter;
import project.util.EventMetrics;
import project.util.LoadTester;
import project.util.TenantResolver;
import project.util.TenantStore;
import project.validation.EventValidator;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        
        EventValidator validator = new EventValidator();

        TenantStore tenantStore = new TenantStore();
        TenantResolver tenantResolver = new TenantResolver(tenantStore);

        EventPublisher publisher = new KafkaEventPublisher();

        Map<EventType, EventHandler> handlers = Map.of(
                EventType.LOGIN, new LoginHandler(publisher),
                EventType.PURCHASE, new PurchaseHandler(publisher),
                EventType.SESSION, new SessionHandler(publisher)
        );

        EventRouter router = new EventRouter(handlers);

        EventMetrics metrics = new EventMetrics();

        EventCollectorService service = new EventCollectorService(validator, tenantResolver, router, metrics);

        LoadTester tester = new LoadTester();

        tester.run(service, 10_000, 8);

        metrics.printMetrics();
    }
}