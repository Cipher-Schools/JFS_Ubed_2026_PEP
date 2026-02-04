package module3.thread;

/**
 * DeadlockDemo
 * A deadlock occurs when two or more threads are blocked forever, each waiting
 * for a resource that another thread holds.
 * 
 * DEADLOCK CONDITIONS (all four must be present):
 * 1. Mutual Exclusion: Only one thread can hold a resource at a time
 * 2. Hold and Wait: Threads hold resources while waiting for others
 * 3. No Preemption: Resources cannot be forcibly taken from threads
 * 4. Circular Wait: Thread 1 waits for Thread 2, which waits for Thread 1
 * 
 * THIS EXAMPLE CREATES DEADLOCK:
 * - Thread 1: Locks ResourceA → tries to lock ResourceB (waits for Thread 2)
 * - Thread 2: Locks ResourceB → tries to lock ResourceA (waits for Thread 1)
 * - Result: Both threads wait forever (circular wait)
 * 
 * Solution: Use consistent lock ordering (both threads acquire locks in same order)
 */

// Simple resource classes
class ResourceA {
}

class ResourceB {
}

public class DeadlockDemo {

    // Shared resources that threads will compete for
    static final ResourceA resourceA = new ResourceA();
    static final ResourceB resourceB = new ResourceB();

    public static void main(String[] args) {

        // Thread 1: Acquires locks in order A → B
        Thread t1 = new Thread(() -> {
            synchronized (resourceA) {
                System.out.println("Thread 1 locked ResourceA");

                try { Thread.sleep(100); } catch (InterruptedException e) {}

                // Try to acquire ResourceB (but Thread 2 might hold it)
                synchronized (resourceB) {
                    System.out.println("Thread 1 locked ResourceB");
                }
            }
        });

        // Thread 2: Acquires locks in order B → A (OPPOSITE ORDER - causes deadlock!)
        Thread t2 = new Thread(() -> {
            synchronized (resourceB) {
                System.out.println("Thread 2 locked ResourceB");

                try { Thread.sleep(100); } catch (InterruptedException e) {}

                // Try to acquire ResourceA (but Thread 1 might hold it)
                synchronized (resourceA) {
                    System.out.println("Thread 2 locked ResourceA");
                }
            }
        });

        // Start both threads - will likely deadlock
        t1.start();
        t2.start();
        
        // DEADLOCK PREVENTION: Change Thread 2 to acquire locks in same order as Thread 1:
        // synchronized (resourceA) { ... synchronized (resourceB) { ... } }
    }
}
