// TenantResolver.java 
package project.util;

import project.exception.UnknownTenantException;
import project.model.Tenant;

public class TenantResolver {
    private final TenantStore tenantStore;

    public TenantResolver(TenantStore tenantStore){
        this.tenantStore = tenantStore;
    }

    public Tenant resolve(String tenantId){
        if (tenantId==null || tenantId.isBlank()){
            throw new UnknownTenantException("TenantId cannot be null or blank");
        }

        Tenant tenant = tenantStore.get(tenantId);

        if (tenant==null){
            throw new UnknownTenantException("Unknown tenant: " + tenantId);
        }

        return tenant;
    }
}
