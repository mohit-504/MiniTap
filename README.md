# Event Ingestion Service

A production-inspired Event Ingestion Service built using **Java 21**, **Lombok**, **Concurrent Collections**, and **Multithreading**.

The project simulates the API Gateway layer of a multi-tenant analytics platform similar to CleverTap, Mixpanel, or Amplitude. Incoming events are validated, routed to the appropriate handler, published to a downstream system, and tracked through metrics and profiling utilities.

---

# Architecture

```text
                    +----------------------+
                    | EventCollectorService |
                    +----------+-----------+
                               |
          +--------------------+--------------------+
          |                    |                    |
          v                    v                    v
+----------------+   +----------------+   +----------------+
| EventValidator |   | TenantResolver |   | EventMetrics   |
+----------------+   +----------------+   +----------------+
                              |
                              v
                       +--------------+
                       | TenantStore  |
                       +--------------+

                               |
                               v

                       +---------------+
                       | EventRouter   |
                       +-------+-------+
                               |
       +-----------------------+-----------------------+
       |                       |                       |
       v                       v                       v
+--------------+     +----------------+     +---------------+
| LoginHandler |     | PurchaseHandler|     | SessionHandler|
+--------------+     +----------------+     +---------------+
       |
       v
+--------------------+
| EventPublisher     |
+--------------------+
       |
       v
+--------------------+
| KafkaEventPublisher|
+--------------------+
```

---

# Features

### Event Processing Pipeline

- Event validation
- Tenant resolution
- Event routing
- Event handling
- Event publishing

### Multi-Tenant Support

- Tenant registry
- Tenant lookup
- Tenant validation

### Event Routing

- Strategy Pattern based routing
- Separate handlers for:
  - LOGIN
  - PURCHASE
  - SESSION

### Metrics

- Per-event-type counters
- Total event count
- Thread-safe metrics collection using:
  - ConcurrentHashMap
  - AtomicLong

### Logging Utilities

- CappedLogger
- ThrottledLogger

### Profiling

- Request execution time measurement
- Nanosecond precision timing

### Load Testing

- ExecutorService
- Fixed Thread Pool
- Throughput calculation
- Concurrent event processing

---

# Technologies Used

- Java 21
- Lombok
- Records
- Builder Pattern
- ConcurrentHashMap
- AtomicInteger
- AtomicLong
- Streams API
- ExecutorService
- FixedThreadPool
- Exception Handling

---

# Project Structure

```text
src/main/java/project
│
├── controller
│   └── EventCollectorService.java
│
├── exception
│   ├── InvalidEventException.java
│   ├── UnknownTenantException.java
│   └── UnsupportedEventException.java
│
├── handler
│   ├── EventHandler.java
│   ├── LoginHandler.java
│   ├── PurchaseHandler.java
│   └── SessionHandler.java
│
├── logging
│   ├── CappedLogger.java
│   └── ThrottledLogger.java
│
├── model
│   ├── Event.java
│   ├── EventType.java
│   └── Tenant.java
│
├── publisher
│   ├── EventPublisher.java
│   └── KafkaEventPublisher.java
│
├── router
│   └── EventRouter.java
│
├── util
│   ├── EventMetrics.java
│   ├── LoadTester.java
│   ├── Profiler.java
│   ├── TenantResolver.java
│   └── TenantStore.java
│
├── validation
│   └── EventValidator.java
│
└── Main.java
```

---

# VS Code Setup

Install Lombok:

```text
https://projectlombok.org/download
```

Place the downloaded jar inside:

```text
lib/
└── lombok.jar
```

Ensure `.vscode/settings.json` contains:

```json
{
    "java.project.referencedLibraries": [
        "lib/**/*.jar"
    ]
}
```

---

# How to Run

Compile and run:

```bash
javac
java project.Main
```

Or run directly from VS Code.

---

# Sample Load Test Output

```text
Events Processed : 10000
Threads          : 8
Time Taken       : 0.060 sec
Throughput       : 167283.66 events/sec

SESSION -> 0
LOGIN -> 10000
PURCHASE -> 0
TOTAL -> 10000
```

---

# Concepts Practiced

### Core Java

- Records
- Enums
- Interfaces
- Exception Handling

### OOP & Design Patterns

- Strategy Pattern
- Dependency Injection
- Builder Pattern
- Interface-Based Design

### Concurrency

- ExecutorService
- Fixed Thread Pool
- ConcurrentHashMap
- AtomicInteger
- AtomicLong
- Synchronization

### Backend Engineering

- Event Processing Pipelines
- Routing
- Validation
- Metrics Collection
- Throughput Measurement
- Multi-Tenant Architecture
- Service Orchestration

---

# Future Enhancements

- Spring Boot Migration
- REST API Endpoints
- Kafka Producer Integration
- Micrometer Metrics
- Prometheus & Grafana
- Docker Support
- Integration Tests
- Distributed Event Processing