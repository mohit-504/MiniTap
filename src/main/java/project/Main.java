// Main.java 
package project;

// import java.time.Instant;
// import java.util.Map;

// import project.exception.InvalidEventException;
// import project.model.Event;
// import project.model.EventType;

import project.model.Tenant;
import project.util.TenantResolver;
import project.util.TenantStore;

public class Main {
    public static void main(String[] args) {
        TenantStore tenantStore = new TenantStore();
        TenantResolver tenantResolver = new TenantResolver(tenantStore);
        Tenant tenant = tenantResolver.resolve(null);
        System.out.println(tenant);
    }
    
}
