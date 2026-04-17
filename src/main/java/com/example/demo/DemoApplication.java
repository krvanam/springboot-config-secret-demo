package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Entry point for the Spring Boot application.
 *
 * <p>This class contains a main method that delegates to Spring Boot's
 * {@link SpringApplication#run} to bootstrap the application. Using the
 * {@code @SpringBootApplication} annotation enables component scanning,
 * auto-configuration, and allows defining extra configuration on your
 * application class. Because the configuration values for this app are
 * provided by Kubernetes through environment variables (via ConfigMap and
 * Secret), there is no additional configuration code required here.</p>
 */
@SpringBootApplication
public class DemoApplication {

    /**
     * Starts the Spring Boot application.
     *
     * @param args command line arguments passed to the application
     */
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
}