# REST API Demo - Spring Boot

RESTful API implementation using Spring Boot demonstrating core Spring concepts, dependency injection, and layered architecture.

## Topics Covered

### Spring Boot Annotations

- **@SpringBootApplication**: Application entry point
- **@RestController**: HTTP request handling
- **@Service**: Business logic layer
- **@Repository**: Data access layer
- **@Autowired**: Dependency injection
- **@Primary**: Default bean selection when multiple implementations exist
- **@Component**: Spring Bean marking

### Dependency Injection Pattern

- Spring manages object creation and lifecycle
- Field injection with `@Autowired`
- Constructor injection (recommended for testability)
- **@Primary** annotation for resolving bean conflicts:
  - `ServiceInter` interface
  - `StudentService`: Primary implementation
  - `UserService`: Alternative implementation
  - Controller demonstrates primary bean injection

### REST Endpoint Mappings

- `@GetMapping`: Resource retrieval
- `@PostMapping`: Resource creation
- `@PutMapping`: Resource updates
- `@DeleteMapping`: Resource deletion
- `@RequestBody`: JSON to Object binding
- `@PathVariable`: URL parameter extraction

### Architecture Pattern

- **Layered Architecture**: Controller → Service → Repository
- **Data Transfer Object (DTO)**: `StudentDTO` for API and business logic decoupling
- **In-Memory Storage**: HashMap-based repository simulating database
- **Separation of Concerns**: Clean layer responsibility division
