package com.luke.WinnasLoginSession.config;

// Import necessary Spring and Java utilities
import org.springframework.beans.factory.annotation.Value; // Allows injection of property values from application.properties
import org.springframework.context.annotation.Configuration; // Marks this class as a Spring configuration class
import org.springframework.web.servlet.config.annotation.CorsRegistry; // Provides methods for configuring CORS settings
import org.springframework.web.servlet.config.annotation.EnableWebMvc; // Enables Spring MVC functionalities
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer; // Interface for customizing web configurations

import java.util.Arrays; // Utility class for working with arrays
import java.util.List; // Used to handle lists

// Marks this class as a configuration class and enables Spring MVC
@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer { // Implements WebMvcConfigurer to customize MVC settings

    // Injects the CORS allowed origins from the application.properties file
    @Value("${app.cors.allowed-origins}")
    private String allowedOrigins;

    // Overrides the default CORS configuration method
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // Splits the allowed origins string (comma-separated) into a list
        List<String> originsList = Arrays.asList(allowedOrigins.split(","));

        // Configures CORS settings for all API endpoints
        registry.addMapping("/**") // Applies CORS settings to all endpoints
                .allowedOrigins(originsList.toArray(new String[0])) // Converts list to an array and sets allowed origins dynamically
                .allowedMethods("GET") // Allows only POST requests
                .allowCredentials(true); // Allows credentials (cookies, authorization headers, etc.)
    }
}

