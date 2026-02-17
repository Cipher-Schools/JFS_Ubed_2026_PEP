package org.example.restapidemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RestApiDemoApplication {

    public static void main(String[] args) {
        // This is the entry point of the Spring Boot application.
        // It launches the application, starts the embedded Tomcat server, and initializes the Spring Context.
        SpringApplication.run(RestApiDemoApplication.class, args);
    }

}
