# In-Memory Database

Custom in-memory key-value database implementation featuring TTL (Time-To-Live) expiration, demonstrating caching patterns and data structure management.

## Core Concepts

### Key-Value Storage

- Key-value pair storage using HashMap
- Constant time O(1) access for GET, PUT, DELETE operations
- Efficient data retrieval from memory

### Time-To-Live (TTL)

- Entries can have expiration times
- Automatic stale data invalidation
- Critical concept for caching systems (Redis-like behavior)
- Timestamp-based expiration tracking

### Command Pattern

- Text command parsing and execution
- Operations:
  - `PUT key value [ttl]`: Store data with optional expiration
  - `GET key`: Retrieve data (checks TTL)
  - `DELETE key`: Remove data

## Implementation Details

- **Main.java**: Application entry point and command loop
- **DB.java**: In-memory storage engine with TTL management
- **CommandParser.java**: User input parsing and command execution
- **Entry.java**: Data structure for storing values with metadata
