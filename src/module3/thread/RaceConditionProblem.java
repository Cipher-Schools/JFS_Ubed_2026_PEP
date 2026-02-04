package module3.thread;

/**
 * count++ is not atomic, it has 3 steps:
 * 1. Read current value
 * 2. Increment value
 * 3. Write value back
 * 
 * When two threads do this simultaneously, they can interfere with each other.
 * Example: Both threads read count=100, increment to 101, write 101 → Lost update!
 */
class UnsafeCounter {
    static int count = 0;
    
    /**
     * This method is NOT thread-safe!
     * Multiple threads can execute this simultaneously, causing lost updates.
     */
    public static void increment() {
        count++; // NOT ATOMIC
    }
}

class UnsafeThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            UnsafeCounter.increment();
        }
    }
}

public class RaceConditionProblem {
    public static void main(String[] args) throws InterruptedException {
        UnsafeThread t1 = new UnsafeThread();
        UnsafeThread t2 = new UnsafeThread();

        t1.start();
        t2.start();
        
        t1.join();
        t2.join();

        System.out.println("Final value: " + UnsafeCounter.count);
        System.out.println("Expected: 2000");
    }
}
