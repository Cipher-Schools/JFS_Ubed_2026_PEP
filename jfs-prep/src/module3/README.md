# Module 3: IO & Concurrency

File operations and multi-threaded programming for building robust, data-persistent applications.

## Topics Covered

### File I/O (Input/Output)

Reading and writing data to files:

#### Reading Files

- **FileReader**: Sequential character-by-character reading from text files
- **BufferedReader**: Wraps FileReader, provides buffering for efficient line-by-line reading
- **Try-with-resources**: Java 7+ syntax for automatic resource closing
- **readLine() vs read()**: Line-based vs character-based reading
- **Performance**: Buffering improves performance significantly
- **Encoding**: Handling different character encodings

#### Writing Files

- **FileWriter**: Character stream writing to text files
- **BufferedWriter**: Wraps FileWriter for efficient buffered writing
- **Creating files**: FileWriter creates file if not exists, overwrites if exists
- **Appending data**: Using FileWriter(filename, true) for append mode
- **Flushing**: Ensuring data written to disk with flush()
- **Resource management**: Closing streams to prevent resource leaks

#### Serialization (Object Persistence)

- **ObjectOutputStream**: Converts objects to byte stream, writes to file
- **ObjectInputStream**: Reads byte stream, reconstructs objects
- **Serializable interface**: Marker interface indicating object can be serialized
- **SerialVersionUID**: Version control for serialized objects
- **Transient keyword**: Exclude fields from serialization
- **Use cases**: Saving application state, caching, RPC communication

#### Best Practices

- Always use try-with-resources for automatic closing
- Handle IOExceptions appropriately
- Use BufferedReader/BufferedWriter for performance
- Test for null after reading data
- Validate data read from files

### Concurrency (Multi-Threading)

Multi-threaded programming for concurrent execution:

#### Thread Creation

- **Extending Thread class**: Create class extending Thread, override run()
  - Advantage: Direct access to Thread methods
  - Disadvantage: Can't extend other classes, less flexible
- **Implementing Runnable interface**: Create class implementing Runnable, pass to Thread
  - Advantage: Can extend other class, more flexible, lambda support
  - Disadvantage: More setup code
  - **Preferred approach**: Use Runnable for better design

#### Thread Lifecycle

Thread states during execution:

- **NEW**: Thread created but not started
- **RUNNABLE**: Thread ready to run, waiting for CPU
- **RUNNING**: Thread currently executing
- **BLOCKED/WAITING**: Thread waiting for resource or condition
- **TERMINATED**: Thread finished execution

#### Thread Management

- **start() vs run()**: start() creates new thread, run() executes synchronously
- **sleep(milliseconds)**: Pause thread execution for specified duration
- **join()**: Main thread waits for worker thread to complete
- **interrupt()**: Send interrupt signal to thread
- **isAlive()**: Check if thread is still running
- **Thread naming**: setName() and getName() for identification

#### Synchronization

Protecting shared resources from concurrent access:

#### Synchronized Blocks

```txt
synchronized(lockObject) {
    // Critical section - only one thread at a time
}
```

- Fine-grained control over which code is synchronized
- Reduces lock contention
- Better performance than synchronizing entire method

#### Synchronized Methods

- Entire method body protected
- Lock is on object (instance methods) or class (static methods)
- Simpler but less granular control

#### When to Synchronize

- Multiple threads access shared mutable data
- At least one thread modifies the data
- Without synchronization: unpredictable results

#### Race Conditions

**Problem**: Multiple threads compete to modify same data

- Example: `count++` not atomic (read, modify, write)
- Different results each run without synchronization
- Inconsistent state due to interleaved execution

**Solution**: Synchronization ensures atomic operations

- Only one thread enters critical section at a time
- Other threads wait for lock
- Results always consistent

#### Deadlock

**Problem**: Threads wait for each other forever, program freezes

- Thread 1 holds Lock A, waits for Lock B
- Thread 2 holds Lock B, waits for Lock A
- Circular dependency causes stall
- Four Coffman conditions enable deadlock:
  1. Mutual exclusion (can't share resources)
  2. Hold and wait (hold resource while waiting)
  3. No preemption (can't force resource release)
  4. Circular wait (needs hold/wait condition)

**Prevention**:

- Consistent lock ordering: Always acquire locks in same order
- Timeout on lock acquisition: Release if timeout
- Try-lock pattern: Lock.tryLock() instead of lock()
- Fine-grained locking: Minimize critical sections

#### Thread Communication

- **wait(), notify(), notifyAll()**: Coordinate between threads
- **Condition variables**: More fine-grained control
- **Volatile keyword**: Ensures visibility of variable changes across threads

#### Common Issues

- **Calling run() instead of start()**: Executes synchronously, no new thread
- **Data races**: Accessing shared data without synchronization
- **Lost updates**: One thread's changes overwritten by another
- **Over-synchronization**: Too much locking causes bottlenecks
- **Not handling InterruptedException**: Thread interruption ignored

#### Thread Pools & Executors (Java Concurrency)

- **ExecutorService**: Manage thread pool instead of creating threads manually
- **Advantages**: Reuse threads, limit concurrent threads, queue tasks
- **Common pool sizes**: Fixed (fixed number), Cached (grows as needed), Scheduled (timed execution)

## Key Concepts

**IO Best Practice**: Use try-with-resources to ensure streams close even if exception occurs

**Thread vs Runnable**: Always prefer Runnable for better design flexibility

**Atomicity**: `count++` is NOT atomic - three operations (read, increment, write)

**Visibility**: Changes by one thread must be visible to others through synchronization or volatile

**Performance**: Synchronization has overhead - synchronize only critical sections

**Testing concurrency**: Race conditions show differently on different runs, use stress tests

**Order matters**: Lock ordering prevents deadlocks - always acquire in same sequence
