package module3.thread;

/**
 * THREAD STATES:
 * 1. NEW: Thread is created but not started yet
 * 2. RUNNABLE: Thread is ready to run and waiting for CPU time
 * 3. RUNNING: Thread is executing (CPU allocated)
 * 4. BLOCKED/WAITING: Thread is waiting for a resource or another thread
 * 5. TERMINATED: Thread has completed execution
 */
class MyThreadLifeCycle implements Runnable {
    @Override
    public void run() {
        try {
            // BLOCKED state: Thread sleeps for 15 seconds
            Thread.sleep(15000);    // During sleep, thread is not consuming CPU resources
            
            // Thread resumes RUNNING state
            System.out.println("thread is running "
                + Thread.currentThread().getName() + " "
                + Thread.currentThread().threadId());
        } catch (InterruptedException e) {
            // InterruptedException is thrown when another thread interrupts this sleeping thread
            // Good practice: restore the interrupted status or handle gracefully
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }
}

public class ThreadLifeCycle {
    public static void main(String[] args) throws InterruptedException {
        MyThreadLifeCycle task1 = new MyThreadLifeCycle();  // NEW
        Thread t1 = new Thread(task1);

        // JVM scheduler will allocate CPU time and move it to RUNNING state
        t1.start(); // RUNNABLE: start() makes the thread eligible for execution
        
        // join() causes the main thread to WAIT until t1 TERMINATES
        // This ensures synchronization between threads
        t1.join();
        
        // This will print only after t1 has completed execution
        System.out.println("main thread");
    }
}

