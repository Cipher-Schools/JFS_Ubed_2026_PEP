package module3.concurrency.problems;

/**
 * DEMONSTRATION: wait(), notify(), and notifyAll() for Thread Communication
 * 
 * This example demonstrates Producer-Consumer pattern using wait/notify mechanism.
 * Key Learning Points:
 * These methods MUST be called from synchronized context (or IllegalMonitorStateException occurs)
 */
class Store {
    // Shared resource - stock count (critical section)
    int stock = 1; // Start with 1 item in stock
    
    /**
     * SELL METHOD - Consumer
     * Demonstrates: wait(), notify()
     * - Uses 'synchronized' to ensure thread-safe access
     * - Uses 'while' (not if) to check condition to avoid spurious wakeups
     */
    synchronized void sell() throws InterruptedException {
        while (stock == 0) {
            System.out.println(Thread.currentThread().getName() + ": No stock available, waiting...");
            // wait() - Releases the lock and waits until another thread calls notify/notifyAll
            // MUST be in synchronized block or throws IllegalMonitorStateException
            wait();
        }
        
        // Critical section - modify shared resource
        System.out.println(Thread.currentThread().getName() + ": Sold 1 item. Stock: " + stock + " -> " + (stock - 1));
        stock--;
        
        // notify() - Wakes up ONE random thread waiting on this object's monitor
        // Used here because only one refiller thread needs to be awakened
        notify();
    }
    
    /**
     * STOCK REFILLING METHOD - Producer
     */
    synchronized void stockRefilling() throws InterruptedException {
        while (stock == 1) {
            System.out.println(Thread.currentThread().getName() + ": Stock already full, waiting...");
            // wait() - Releases the lock and waits for notification
            wait();
        }
        
        // Critical section - modify shared resource
        System.out.println(Thread.currentThread().getName() + ": Refilled stock. Stock: " + stock + " -> " + (stock + 1));
        stock++;
        
        // notifyAll() - Wakes up ALL threads waiting on this object's monitor
        // Used here to demonstrate difference from notify()
        // If multiple seller threads are waiting, all get a chance to compete for the lock
        notifyAll();
    }
}

public class BuySellDemo {
    public static void main(String[] args) {
        Store store = new Store();
        
        /**
         * Demonstrates consumer behavior in producer-consumer pattern
         */
        Thread seller = new Thread(() -> {
            try {
                    store.sell();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }, "Seller-Thread"); // Named thread for clear output
        
        /**
         * Demonstrates producer behavior in producer-consumer pattern
         */
        Thread refiller = new Thread(() -> {
            try {
                    store.stockRefilling();
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }, "Refiller-Thread"); // Named thread for clear output
        
        // Start both threads - they will coordinate using wait/notify
        seller.start();
        refiller.start();
        
        // Optional: Wait for threads to complete
        try {
            seller.join();
            refiller.join();
            System.out.println("\n=== All operations completed ===");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

/**
 * EXPECTED OUTPUT (example):
 * Seller-Thread: Sold 1 item. Stock: 1 -> 0
 * Refiller-Thread: Refilled stock. Stock: 0 -> 1
 * Seller-Thread: Sold 1 item. Stock: 1 -> 0
 * Refiller-Thread: Refilled stock. Stock: 0 -> 1
 * ... (continues)
 * 
 * KEY OBSERVATIONS:
 * 1. Threads coordinate without race conditions (synchronized ensures this)
 * 2. When stock is 0, seller waits (no busy waiting - efficient!)
 * 3. When stock is 1, refiller waits
 * 4. notify()/notifyAll() wake up waiting threads
 * 
 * COMMON MISTAKES TO AVOID:
 * 1. Using 'if' instead of 'while' - can cause incorrect behavior on spurious wakeups
 * 2. Calling wait/notify outside synchronized block - throws IllegalMonitorStateException
 * 3. Forgetting to call notify/notifyAll - threads will wait forever (deadlock)
 * 4. Using notify() when multiple threads need to wake up - may cause starvation
 */
