// Tenant.java 
package project.model;

import lombok.Builder;

@Builder
public record Tenant(
    String tenantId,
    String tenantName
) {}
