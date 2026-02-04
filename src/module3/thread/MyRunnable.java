package module3.thread;

/**
 * 1. Your class can extend another class (Java supports single inheritance only)
 * 2. You can pass the same Runnable instance to multiple threads
 * 3. Separates the task (what to run) from the thread mechanism (how to run)
 * 4. Preferred approach in modern Java (supports lambda expressions)
 */
class MyThreadRunnable implements Runnable {
    
    @Override
    public void run() {
        System.out.println("thread is running "
                + Thread.currentThread().getName() + " "  // Thread name
                + Thread.currentThread().threadId());     // Unique thread ID
    }
}

public class MyRunnable {
    public static void main(String[] args) {
        // Create two task instances (what to run)
        MyThreadRunnable task1 = new MyThreadRunnable();
        MyThreadRunnable task2 = new MyThreadRunnable();

        // Create threads and assign tasks to them
        Thread t1 = new Thread(task1, "task t1");   // Thread(Runnable target, String name)
        Thread t2 = new Thread(task2, "task t2");

        t1.start();
        t2.start();

        System.out.println("Main thread");
    }
}
