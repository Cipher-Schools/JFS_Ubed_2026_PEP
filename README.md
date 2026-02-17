# JFS Prep Repository

This repository contains exercises and examples for the Java Full Stack (JFS) preparation course.

## Folder Structure

- **`rest-api-demo`**: A Spring Boot application demonstrating REST API concepts, Dependency Injection (`@Component`, `@Primary`), and standard layered architecture (Controller, Service, Repository). It uses an in-memory `HashMap` to simulate a database.
- **`memory-db`**: A pure Java application implementing a custom In-Memory Database with support for TTL (Time-To-Live).
- **`jdbcDemo`**: Examples of JDBC connectivity (if applicable).
- **`jfs-prep`**: General preparation materials.

## Getting Started

### Prerequisites

- Java 17 or higher installed.
- Maven (optional, wrapper provided in projects).

### Implementation Details

The `rest-api-demo` project features a specific example of Spring's Dependency Injection:

- `ServiceInter`: A common interface.
- `StudentService`: The primary implementation (`@Primary`).
- `UserService`: An alternative implementation.
- `StudentController`: Demonstrates the injection of the primary bean.

### How to Run `rest-api-demo`

1. Navigate to the folder:
   ```bash
   cd rest-api-demo
   ```
2. Run the application:
   ```bash
   ./mvnw spring-boot:run
   ```
3. Test the `@Primary` annotation example:
   ```bash
   curl http://localhost:8080/api/service
   ```
   Output: `Student Service Implementation (Primary)`

## Resources

Check the `README.md` inside each project folder for specific details and usage instructions.
