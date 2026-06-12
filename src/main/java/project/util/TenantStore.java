// TenantStore.java 
package project.util;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import project.model.Tenant;

public class TenantStore {
    private final Map<String, Tenant> tenants = new ConcurrentHashMap<>();

    public TenantStore(){
        tenants.put("tenant-1", Tenant.builder()
                                        .tenantId("tenant-1")
                                        .tenantName("Zomato")
                                        .build());
        
        tenants.put("tenant-2", Tenant.builder()
                                        .tenantId("tenant-2")
                                        .tenantName("BlinkIt")
                                        .build());
    }

    public Tenant get(String tenantId){
        return tenants.get(tenantId);
    }
}
