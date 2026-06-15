// LoadTester.java
package project.util;

import java.time.Instant;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import project.controller.EventCollectorService;
import project.model.Event;
import project.model.EventType;

public class LoadTester {
    public void run(EventCollectorService service, int eventCount, int threadCount) throws InterruptedException{
        ExecutorService executor = Executors.newFixedThreadPool(threadCount);

        long start = System.nanoTime();

        for (int i = 0; i < eventCount; i++) {

            executor.submit(() -> {

                Event event = Event.builder()
                        .tenantId("tenant-1")
                        .eventType(EventType.LOGIN)
                        .userId("user")
                        .timestamp(Instant.now())
                        .payload(Map.of("device", "android"))
                        .build();

                service.collect(event);
            });
        }

        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.MINUTES);

        long durationNs = System.nanoTime() - start;

        double durationSeconds =
                durationNs / 1_000_000_000.0;

        double throughput =
                eventCount / durationSeconds;

        System.out.println();
        System.out.println("Events Processed : " + eventCount);
        System.out.println("Threads          : " + threadCount);
        System.out.println("Time Taken       : " + String.format("%.3f", durationSeconds) + " sec");
        System.out.println("Throughput       : " + String.format("%.2f", throughput) + " events/sec");
    }
}
