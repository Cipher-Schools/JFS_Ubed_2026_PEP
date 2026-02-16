# Module 3: IO & Concurrency

Master file operations and multi-threaded programming for robust applications.

## 📚 Topics Covered

### 1. **IO (Input/Output)** (`io/`)

File and data stream operations.

#### `filereader/`

Reading data from files:

- `FileReader` - Character stream reading
- `BufferedReader` - Efficient buffered reading
- Try-with-resources pattern (automatic resource management)
- Reading line-by-line vs character-by-character

#### `filewriter/`

Writing data to files:

- `FileWriter` - Character stream writing
- `BufferedWriter` - Efficient buffered writing
- Creating and overwriting files
- Appending to existing files

#### `objectstream/`

Serialization and deserialization:

- `ObjectOutputStream` - Writing objects to files
- `ObjectInputStream` - Reading objects from files
- `Serializable` interface
- Use cases: Saving application state, data persistence

### 2. **Concurrency** (`concurrency/`)

Multi-threaded programming for concurrent execution.

#### `basics/`

Thread fundamentals:

**`MyThread.java`**

- Creating threads by extending `Thread` class
- `start()` vs `run()` methods
- When to use Thread extension

**`MyRunnable.java`**

- Creating threads using `Runnable` interface
- Why Runnable is preferred (flexibility, lambda support)
- Thread naming and identification

**`ThreadLifeCycle.java`**

- Thread states: NEW → RUNNABLE → RUNNING → BLOCKED → TERMINATED
- `sleep()` method for pausing execution
- `join()` method for synchronization
- `InterruptedException` handling

#### `problems/`

Common concurrency issues and solutions:

**`RaceConditionProblem.java`** ⚠️

- Demonstrates race condition without synchronization
- Shows inconsistent results (value < 2000)
- Explains why `count++` is not atomic

**`RaceConditionSolution.java`** ✅

- Fixes race condition with `synchronized` block
- Consistent results (always 2000)
- Critical section protection

**`DeadlockDemo.java`** 🔒

- Classic deadlock scenario
- Circular wait condition
- 4 deadlock conditions (Coffman conditions)
- Prevention: Consistent lock ordering

## 🎯 Learning Path

### IO Operations

1. Start with reading → `io/filereader/FileReaderDemo.java`
2. Practice writing → `io/filewriter/FileWriterDemo.java`
3. Learn buffering → `BufferedReader`, `BufferedWriter`
4. Advanced: Object persistence → `io/objectstream/`

### Concurrency

1. **Thread Creation** → `concurrency/basics/MyThread.java` → `MyRunnable.java`
2. **Thread Lifecycle** → `concurrency/basics/ThreadLifeCycle.java`
3. **See the Problem** → `concurrency/problems/RaceConditionProblem.java` (run multiple times!)
4. **Learn the Solution** → `concurrency/problems/RaceConditionSolution.java`
5. **Understand Deadlock** → `concurrency/problems/DeadlockDemo.java`

## 💡 Key Concepts

### IO Best Practices

```java
// ✅ Use try-with-resources (automatic closing)
try (BufferedReader br = new BufferedReader(new FileReader("file.txt"))) {
    String line = br.readLine();
}

// ❌ Manual closing (error-prone)
BufferedReader br = new BufferedReader(new FileReader("file.txt"));
String line = br.readLine();
br.close(); // Might not execute if exception occurs
```

### Thread Creation:extends Thread vs implements Runnable

| Aspect             | extends Thread                | implements Runnable         |
| ------------------ | ----------------------------- | --------------------------- |
| Flexibility        | ❌ Can't extend other classes | ✅ Can extend other classes |
| Reusability        | ❌ Thread and task coupled    | ✅ Task reusable            |
| Lambda support     | ❌ No                         | ✅ Yes                      |
| **Recommendation** | Rarely used                   | **Preferred**               |

### Synchronization

**When to use:**

- Multiple threads access shared mutable data
- At least one thread modifies the data

**How to use:**

```java
// Synchronized block (preferred - fine-grained control)
synchronized(lockObject) {
    // Critical section - only one thread at a time
    sharedData++;
}
```

### Race Condition vs Deadlock

| Race Condition                       | Deadlock                               |
| ------------------------------------ | -------------------------------------- |
| Multiple threads race to modify data | Threads wait for each other forever    |
| Results in incorrect data            | Results in frozen program              |
| **Solution**: Synchronization        | **Solution**: Consistent lock ordering |

## 🧪 Experiments

### Try This: Race Condition

Run `RaceConditionProblem.java` multiple times:

```bash
java module3.concurrency.problems.RaceConditionProblem
# Run 1: 1403
# Run 2: 1239
# Run 3: 1465  ← Different every time!
```

Now run `RaceConditionSolution.java`:

```bash
java module3.concurrency.problems.RaceConditionSolution
# Always: 2000 ← Consistent!
```

### Try This: Deadlock

Run `DeadlockDemo.java` and watch it freeze (deadlock):

- Thread 1 waits for Thread 2
- Thread 2 waits for Thread 1
- Both stuck forever!

## ⚠️ Common Pitfalls

1. **Calling `run()` instead of `start()`** - Doesn't create new thread
2. **Forgetting to close streams** - Resource leaks (use try-with-resources)
3. **Not handling `InterruptedException`** - Thread interruption ignored
4. **Excessive synchronization** - Can cause performance bottlenecks

---

_Previous: [Module 2 - Advanced Java](/src/module2/README.md)_ | _Main: [Project README](/README.md)_
