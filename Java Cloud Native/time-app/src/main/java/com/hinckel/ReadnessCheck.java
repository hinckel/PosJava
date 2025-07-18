package com.hinckel;

import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.Readiness;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@Readiness
public class ReadnessCheck implements HealthCheck {

    @RestClient
    TimeApiService timeApiService;

    @Override
    public HealthCheckResponse call() {
        if (timeApiService.getTime().contains("Fallback")) {
            return HealthCheckResponse.down("I'm down");
        } else {
            return HealthCheckResponse.up("I'm alive");
        }
    }
}
