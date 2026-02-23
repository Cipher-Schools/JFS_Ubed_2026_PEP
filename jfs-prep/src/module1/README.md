# Module 1: Core Java Foundations

Fundamental building blocks of Java programming covering data types, operations, control flow, and object-oriented principles.

## Topics Covered

### Primitives

Core data types in Java:

- **Integer types**: `int`, `long`, `short`, `byte` - for whole numbers
- **Floating-point types**: `float`, `double` - for decimal numbers
- **Boolean**: `boolean` - true/false values
- **Character**: `char` - single character representation

### Operators

Perform operations on data:

- **Arithmetic**: `+`, `-`, `*`, `/`, `%` for mathematical operations
- **Relational**: `==`, `!=`, `<`, `>`, `<=`, `>=` for comparisons
- **Logical**: `&&`, `||`, `!` for boolean logic
- **Assignment**: `=`, `+=`, `-=`, `*=`, `/=` for variable assignment
- **Ternary**: `condition ? trueValue : falseValue` for conditional assignment

### Conditionals

Control program flow based on conditions:

- **if-else**: Execute code blocks based on boolean conditions
- **switch-case**: Select one of many code blocks to execute
- **Ternary operator**: Inline conditional expression for single-value returns

### Loops

Execute code repeatedly:

- **for loop**: Known number of iterations
- **while loop**: Condition-based iteration
- **do-while loop**: Execute at least once, then check condition
- **Enhanced for-each**: Iterate through collections and arrays
- **break & continue**: Loop control statements
- **Nested loops**: Loops within loops for multi-dimensional iteration

### Arrays

Store multiple values of the same type:

- **Single-dimensional arrays**: Linear collection of elements
- **Multi-dimensional arrays**: 2D, 3D, and higher dimensional arrays
- **Array declaration and initialization**: Different ways to create arrays
- **Array manipulation**: Accessing, modifying, and iterating through elements
- **Array searching**: Linear search, binary search
- **Array sorting**: Arranging elements in order

### Strings

Working with text data:

- **String creation**: Literal and constructor approaches
- **String manipulation**: Concatenation, case conversion, substring extraction
- **String methods**: length(), charAt(), indexOf(), substring(), etc.
- **StringBuilder**: Efficient string building (mutable alternative to String)
- **String immutability**: Understanding final nature of String objects
- **String comparison**: equals(), compareTo(), equalsIgnoreCase()

### Methods

Reusable blocks of code:

- **Method declaration**: Syntax and structure
- **Parameters and return types**: Passing data in and getting results
- **Method overloading**: Multiple methods with same name, different parameters
- **Recursion**: Methods calling themselves
- **Variable scope**: Local and instance variable visibility
- **Best practices**: Naming conventions, parameter validation, documentation

### Generics

Type-safe programming:

- **Generic classes**: Classes parameterized with types
- **Generic methods**: Methods with type parameters
- **Type parameters**: `<T>`, `<K, V>` notation
- **Bounded types**: Restricting type parameters to specific classes/interfaces
- **Wildcards**: `?`, `? extends`, `? super` for flexible type constraints
- **Type safety**: Compile-time checking to prevent ClassCastException

### OOP (Object-Oriented Programming)

#### Basics

- **Classes and Objects**: Creating blueprints and instances
- **Constructors**: Special methods for object initialization
- **Constructors overloading**: Multiple constructors with different parameters
- **this keyword**: Reference to current object
- **Instance vs Static members**: Object-level vs class-level attributes/methods

#### Encapsulation

- **Access modifiers**: `private`, `public`, `protected`, default (package-private)
- **Getters and Setters**: Controlled access to object data
- **Data hiding**: Protecting internal state from external modification
- **Immutable objects**: Objects that don't change after creation

#### Inheritance

- **Extending classes**: Inheriting properties and methods from parent class
- **super keyword**: Accessing parent class methods and constructors
- **Constructor chaining**: Calling parent constructors
- **Method overriding**: Replacing parent method with child implementation
- **Single inheritance**: Java supports single class inheritance only
- **is-a relationship**: Understanding inheritance hierarchy

#### Polymorphism

- **Method overriding**: Child class provides specific implementation
- **Runtime polymorphism**: Deciding which method to call at runtime
- **Dynamic dispatch**: Calling overridden method through parent reference
- **Method overloading**: Multiple methods with same name (compile-time polymorphism)
- **Type casting**: Converting objects in inheritance hierarchy

#### Abstraction

- **Abstract classes**: Classes that can't be instantiated
- **Abstract methods**: Method declarations without implementation
- **Interfaces**: Contracts defining what classes must do
- **Implementation**: Classes implementing interface methods
- **Default methods**: Java 8+ interface methods with implementations
- **Functional interfaces**: Interfaces with single abstract method

#### Static Members

- **Static variables**: Shared across all instances of class
- **Static methods**: Can be called without object instance
- **Static initializer blocks**: One-time code execution when class loads
- **Class vs instance context**: Understanding static vs instance scope

## Key Concepts

**Variable Scope**: Local variables exist within methods, instance variables within objects

**Type Casting**: Converting between compatible types - implicit (widening) and explicit (narrowing)

**Method Signature**: Method name + parameter types determine uniqueness

**Inheritance Hierarchy**: Parent → Child relationship allowing code reuse and polymorphism

**Object Lifecycle**: Creation → Initialization → Usage → Finalization → Garbage Collection
