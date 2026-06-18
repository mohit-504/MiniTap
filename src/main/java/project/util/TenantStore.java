// TenantStore.java 
package project.util;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Component;

import project.config.TenantProperties;
import project.model.Tenant;

@Component
public class TenantStore {
    private final Map<String, Tenant> tenants = new ConcurrentHashMap<>();

    public TenantStore(TenantProperties properties) {

        properties.getTenants().forEach(id -> tenants.put(id, Tenant.builder()
                                                    .tenantId(id)
                                                    .tenantName(id)
                                                    .build()));
    }

    public Tenant get(String tenantId){
        return tenants.get(tenantId);
    }
}
