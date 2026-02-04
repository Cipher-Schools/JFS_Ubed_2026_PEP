package module3.concurrency.problems;

/**
 * Use synchronized block to make count++ atomic.
 * Only one thread can execute the synchronized block at a time.
 * Other threads must WAIT until the lock is released.
 */
class SafeCounter {
    // Lock object for synchronization
    private static final Object lock = new Object();
    
    // Shared resource
    static int count = 0;

    // public synchronized static void increment() {}       // method level synchronized
    public static void increment() {
        // Critical section: only one thread at a time
        synchronized(lock) {                // block level synchronized
            count++; // Now atomic: read-increment-write happens without interruption
        }
    }
}

class SafeThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            SafeCounter.increment();
        }
    }
}

public class RaceConditionSolution {
    public static void main(String[] args) throws InterruptedException {
        SafeThread t1 = new SafeThread();
        SafeThread t2 = new SafeThread();

        t1.start();
        t2.start();
        
        t1.join();
        t2.join();

        System.out.println("Final value: " + SafeCounter.count);
        System.out.println("Expected: 2000");
    }
}
