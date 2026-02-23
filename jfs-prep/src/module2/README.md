# Module 2: Advanced Java & APIs

Professional Java development covering collections framework, functional programming, exception handling, and design principles.

## Topics Covered

### Collections Framework

Data structures for managing groups of objects:

#### Lists (Ordered, allow duplicates)

- **ArrayList**: Dynamic array, fast random access O(1), slower insertions/deletions O(n)
- **LinkedList**: Doubly linked list, slow random access O(n), fast insertions/deletions O(1) at known position
- **Vector**: Legacy synchronized Array (rarely used)
- **Collections interface**: Iterating, searching, sorting

#### Sets (Unique elements only)

- **HashSet**: Hash table implementation, no order guaranteed, fast O(1) operations, null allowed
- **TreeSet**: Red-Black tree implementation, sorted order, O(log n) operations, no null allowed
- **LinkedHashSet**: Combines HashSet and LinkedList, insertion-order preservation
- **Set operations**: Union, intersection, difference

#### Maps (Key-Value pairs)

- **HashMap**: Hash table implementation, fast O(1) operations, unordered, null keys/values allowed
- **TreeMap**: Red-Black tree implementation, sorted by key, O(log n) operations
- **LinkedHashMap**: HashMap with insertion-order preservation, predictable iteration order
- **Hashtable**: Legacy synchronized map (rarely used)
- **Map operations**: Get, put, remove, containsKey(), values(), keySet(), entrySet()

#### Queue & Stack

- **Queue (FIFO)**: First-In-First-Out structure, offer/poll/peek operations
- **Deque**: Double-ended queue, operations from both ends
- **Stack (LIFO)**: Last-In-First-Out structure, push/pop/peek operations
- **Priority Queue**: Elements ordered by priority, not insertion order

#### Collections Utility Methods

- **Sorting**: Collections.sort(), custom comparators
- **Searching**: Collections.binarySearch(), indexOf()
- **Shuffling**: Collections.shuffle() for randomization
- **Reversing**: Collections.reverse()
- **Rotating**: Collections.rotate()
- **Frequency**: Collections.frequency() for counting

### Comparator & Comparable

#### Comparable Interface

- Single natural ordering defined in class
- Implements compareTo() method
- Used by Arrays.sort() and Collections.sort() by default
- Example: Natural ordering for numbers (ascending), strings (alphabetical)

#### Comparator Interface

- Custom sorting strategies external to class
- Implements compare() method
- Multiple comparators possible for same class
- Comparator chaining: `.thenComparing()` for multi-level sorting
- Special factory methods: `.reversed()`, `.nullsFirst()`, `.nullsLast()`

#### Comparison

- Return negative: first < second
- Return zero: first == second
- Return positive: first > second

### Exception Handling

Managing errors gracefully:

#### Try-Catch-Finally

- **try block**: Code that might throw exception
- **catch block**: Handle specific exception types, multiple catches allowed
- **finally block**: Always executes, for cleanup operations
- **Try-with-resources**: Automatic resource closing (Java 7+)

#### Exception Hierarchy

- **Throwable**: Root class
- **Exception**: For exceptional conditions (recoverable)
- **RuntimeException**: Unchecked exceptions (programming errors)
- **Checked Exceptions**: Must be caught or declared (IOException, SQLException)
- **Error**: Serious problems (OutOfMemoryError, StackOverflowError)

#### Custom Exceptions

- Extend Exception or RuntimeException
- Provide meaningful messages
- Use for domain-specific error handling

#### Best Practices

- Catch specific exceptions, not generic Exception
- Log exceptions with context
- Clean up resources in finally or try-with-resources
- Don't swallow exceptions silently

### Java 8+ Features

Modern programming paradigms:

#### Lambda Expressions

- Anonymous functions with concise syntax
- Syntax: `(parameters) -> body`
- Works with functional interfaces (single abstract method)
- Type inference for parameters
- Used with Comparators, Listeners, Callbacks

#### Functional Interfaces

- Single abstract method interfaces
- `@FunctionalInterface` annotation for clarity
- Examples: Runnable, Callable, Consumer, Supplier, Function, Predicate
- Built-in interfaces in java.util.function package

#### Method References

- Shorthand for lambda expressions
- Types: Static method, Instance method, Constructor
- Syntax: `ClassName::methodName` or `instance::methodName`
- More readable alternative to lambdas

#### Stream API

- Functional approach to processing collections
- Lazy evaluation for performance
- Pipeline: Source → Intermediate Operations → Terminal Operation
- **Intermediate operations**: filter(), map(), flatMap(), distinct(), sorted(), limit(), skip()
- **Terminal operations**: forEach(), collect(), reduce(), count(), findFirst(), anyMatch(), allMatch()
- Immutability: Original collection unchanged
- Parallel streams: parallelStream() for multi-threaded processing

#### Optional Class

- Wrapper for nullable values
- Prevents NullPointerException
- Methods: isPresent(), isEmpty(), get(), orElse(), orElseThrow(), orElseGet()
- map(), flatMap(), filter() for chaining operations
- IfPresent(), ifPresentOrElse() for conditional execution

### SOLID Principles

Software design principles for maintainable code:

#### Single Responsibility Principle (SRP)

- Class should have single reason to change
- One responsibility = one reason to change
- Improves testability and code organization

#### Open/Closed Principle (OCP)

- Open for extension, closed for modification
- Use inheritance and polymorphism instead of modifying existing code
- Reduces bugs from changes

#### Liskov Substitution Principle (LSP)

- Subtypes must be substitutable for base types
- Child class shouldn't break parent contract
- If you use parent type, can safely use child type

#### Interface Segregation Principle (ISP)

- Many client-specific interfaces better than one general interface
- Clients shouldn't depend on methods they don't use
- Smaller, focused interfaces are better

#### Dependency Inversion Principle (DIP)

- Depend on abstractions, not concrete implementations
- High-level modules shouldn't depend on low-level modules
- Both should depend on abstractions (interfaces/abstract classes)
- Enables flexibility and testability through dependency injection

## Key Concepts

**Collection Complexity**: Understanding O(1), O(n), O(log n) for choosing appropriate structure

**Stream vs Loop**: Streams for functional style, understand when each is appropriate

**Exception handling strategy**: Layer-specific handling, meaningful error messages, proper logging

**Functional programming**: Immutability, pure functions, composition over inheritance

**Design patterns**: SOLID principles lead to common patterns (Factory, Strategy, Dependency Injection)
