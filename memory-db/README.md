# In-Memory Database Logic

This project demonstrates the core concepts behind an In-Memory Database, often used for caching (like Redis) or fast temporary storage.

## Concepts Covered

### 1. Key-Value Storage

- Data is stored as Key-Value pairs, similar to a `HashMap`.
- Efficient constant time `O(1)` access for GET, PUT, and DELETE operations.

### 2. Time-To-Live (TTL)

- Entries can have an expiration time (TTL).
- A concept crucial for caching systems to invalidate stale data automatically.

### 3. Command Pattern (implied)

- The application parses text commands to perform operations:
  - `PUT key value [ttl]`
  - `GET key`
  - `DELETE key`

## Usage

Run the `Main` class and enter commands:

```
> PUT user1 John 60
> GET user1
John
> DELETE user1
```

## Structure

- `Main.java`: Entry point and command loop.
- `DB.java`: The database implementation managing storage and TTL.
- `CommandParser.java`: Parses user input into executable commands.
