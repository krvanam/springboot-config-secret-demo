package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * A simple REST controller that demonstrates how configuration values
 * provided via ConfigMap and Secret are injected into a Spring Boot
 * application. The controller exposes two endpoints: the root ("/") for
 * returning formatted configuration values and "/health" for a basic
 * health check.
 */
@RestController
public class HelloController {

    /**
     * Application name injected from environment variables. Defaults to
     * "SpringApp" if not provided.
     */
    @Value("${APP_NAME:SpringApp}")
    private String appName;

    /**
     * Application environment (e.g., dev, prod) injected from environment
     * variables. Defaults to "dev" if not provided.
     */
    @Value("${APP_ENV:dev}")
    private String appEnv;

    /**
     * Database username injected from environment variables. Defaults
     * to "defaultuser" if not provided.
     */
    @Value("${DB_USER:defaultuser}")
    private String dbUser;

    /**
     * Database password injected from environment variables. Defaults
     * to "defaultpass" if not provided.
     */
    @Value("${DB_PASSWORD:defaultpass}")
    private String dbPassword;

    /**
     * Returns a formatted string containing the current configuration
     * values. In a real application you would not expose sensitive
     * information like passwords; this is for demonstration only.
     *
     * @return a string concatenating the injected configuration values
     */
    @GetMapping("/")
    public String home() {
        return "App=" + appName
                + ", Env=" + appEnv
                + ", DB User=" + dbUser
                + ", DB Password=" + dbPassword;
    }

    /**
     * Basic health check endpoint that returns "OK". Useful for
     * Kubernetes liveness/readiness probes.
     *
     * @return a simple "OK" string
     */
    @GetMapping("/health")
    public String health() {
        return "OK";
    }
}