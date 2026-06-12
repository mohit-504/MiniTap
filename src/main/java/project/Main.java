// Main.java 
package project;

// import java.time.Instant;
// import java.util.Map;

// import project.exception.InvalidEventException;
// import project.model.Event;
// import project.model.EventType;
import project.util.TenantResolver;
import project.util.TenantStore;

public class Main {
    TenantStore store = new TenantStore();
    TenantResolver objResolver = new TenantResolver(store);
    
}
