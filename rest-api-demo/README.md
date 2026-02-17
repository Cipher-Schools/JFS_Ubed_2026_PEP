# REST API Demo

This project demonstrates how to build a RESTful API using Spring Boot. It uses an in-memory database to store student records and covers key Spring Boot concepts.

## Concepts Covered

### 1. Spring Boot Annotations

- **@SpringBootApplication**: The main entry point.
- **@RestController**: Handles HTTP requests.
- **@Service**: Contains business logic.
- **@Repository**: Manages data access.
- **@Autowired**: Injects dependencies (Dependency Injection).
- **@Primary**: Specifies the default bean when multiple beans of the same type exist.
- **@Component**: Marks a class as a Spring Bean.

### 2. Dependency Injection (DI)

Spring manages object creation and dependency injection.

- **Field Injection**: `@Autowired` on fields.
- **Constructor Injection**: Recommended approach for better testability.

### 3. REST Controller Mappings

- `@GetMapping`: Retrieve resources.
- `@PostMapping`: Create resources.
- `@PutMapping`: Update resources.
- `@DeleteMapping`: Delete resources.
- `@RequestBody`: Bind JSON to Objects.
- `@PathVariable`: Extract values from URL.

### 4. Data Transfer Object (DTO)

`StudentDTO` is used to transfer data between the Controller and Service, decoupling the API layer from the internal data structure.

### 5. In-Memory Database

A simple `HashMap` in `StudentRepo` simulates a database, teaching the separation of concerns without the complexity of SQL.

## How to Run

1. **Start the Application**:
   ```bash
   ./mvnw spring-boot:run
   ```
2. **Test Endpoints**:
   - `GET /api` - Get all students
   - `POST /api` - Add a student
   - `GET /api/service` - Check which service implementation is used (`@Primary` demo)

## Project Structure

- `src/main/java/org/example/restapidemo/controller` - API Endpoints
- `src/main/java/org/example/restapidemo/service` - Business Logic
- `src/main/java/org/example/restapidemo/repository` - Data Storage
- `src/main/java/org/example/restapidemo/dto` - Data Model
