# Module 2: Advanced Java & APIs

Master professional Java development with collections, modern Java features, and design principles.

## 📚 Topics Covered

### 1. **Collections Framework** (`collections/`)

Powerful data structures for managing groups of objects.

#### `basics/`

Foundation collections for everyday use:

**`list/`** - Ordered collections (duplicates allowed)

- `ArrayList` - Fast random access, dynamic sizing
- `LinkedList` - Efficient insertions/deletions
- `Queue` - FIFO operations
- `Stack` - LIFO operations
- Iteration techniques

**`set/`** - Unique elements only

- `HashSet` - Fast lookup, no order
- `TreeSet` - Sorted order, natural ordering

**`map/`** - Key-value pairs

- `HashMap` - Fast key-based lookup
- `LinkedHashMap` - Insertion-order preservation
- Use cases: Caching, dictionaries, frequency counting

#### `advanced/`

Advanced collection operations:

**`algorithms/`** - Collections utility methods

- Sorting, searching, shuffling
- `Collections.sort()`, `Collections.reverse()`
- Custom algorithms

### 2. **Comparator** (`comparator/`)

Custom sorting strategies for objects.

#### `basics/`

- Custom functional interface example
- Comparator fundamentals
- Return value conventions (negative/zero/positive)

#### `advanced/`

- Multiple sorting strategies
- Comparator chaining (`.thenComparing`)
- Reversed order (`.reversed()`)
- Null-safe comparisons (`nullsFirst`, `nullsLast`)

### 3. **Exceptions** (`exceptions/`)

Error handling mechanisms:

- Try-catch blocks
- Multiple catch blocks
- Finally block
- Custom exceptions
- Exception hierarchy
- Best practices

### 4. **Java 8+ Features** (`java8/`)

Modern Java programming patterns.

#### `lambda/`

- Lambda expressions syntax
- Functional interfaces
- Method references

#### `streams/`

- Stream API basics
- Intermediate operations (`.map`, `.filter`)
- Terminal operations (`.collect`, `.forEach`)
- Parallel streams
- Stream pipeline patterns

#### `optional/`

- Null-safety with `Optional`
- `.isPresent()`, `.orElse()`, `.orElseThrow()`
- Avoiding `NullPointerException`

### 5. **SOLID Principles** (`solid/`)

Software design principles for maintainable code:

- **S**ingle Responsibility Principle (SRP)
- **O**pen/Closed Principle (OCP)
- **L**iskov Substitution Principle (LSP)
- **I**nterface Segregation Principle (ISP)
- **D**ependency Inversion Principle (DIP)

## 🎯 Learning Path

### Beginner Path

1. **Collections Basics** → `collections/basics/list/` → `collections/basics/set/` → `collections/basics/map/`
2. **Sorting** → `comparator/basics/` → `comparator/advanced/`
3. **Error Handling** → `exceptions/`

### Intermediate Path

4. **Modern Java** → `java8/lambda/` → `java8/streams/` → `java8/optional/`
5. **Advanced Collections** → `collections/advanced/algorithms/`

### Advanced Path

6. **Design Principles** → `solid/`

## 💡 Key Concepts

### When to Use Which Collection?

| Need                          | Use             |
| ----------------------------- | --------------- |
| Fast random access            | `ArrayList`     |
| Frequent insertions/deletions | `LinkedList`    |
| Unique elements               | `HashSet`       |
| Sorted unique elements        | `TreeSet`       |
| Key-value mapping             | `HashMap`       |
| Order-preserving map          | `LinkedHashMap` |

### Comparator vs Comparable

- **Comparable**: One natural ordering (inside the class)
- **Comparator**: Multiple custom orderings (external to class)

## 📝 Practice

- Look for `questions/` subfolders (files prefixed with `QS`)
- Try solving problems before viewing solutions
- Practice streams with real-world datasets

---

_Previous: [Module 1 - Core Java](/src/module1/README.md)_ | _Next: [Module 3 - IO & Concurrency](/src/module3/README.md)_
