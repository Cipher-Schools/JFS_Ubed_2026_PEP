package module3.thread;

/**
 * This is one of two ways to create threads in Java:
 * 1. Extend Thread class (shown here)
 * 2. Implement Runnable interface (more flexible)
 * 
 * Note: Extending Thread is less flexible because Java doesn't support
 * multiple inheritance. If your class already extends another class,
 * you must use the Runnable interface instead.
 */
public class MyThread extends Thread {
    
    /**
     * The run() method contains the code that will be executed in the new thread.
     * This method is called automatically when start() is invoked.
     */
    @Override
    public void run() {
        System.out.println("thread is running");
    }

    public static void main(String[] args) {
        MyThread t1 = new MyThread();

        // start() - Tells the JVM to create a new thread and execute the run() method
        // This creates a separate execution path (new call stack)
        t1.start();

        // Main thread continues execution (may print before or after thread messages)
        System.out.println("Main thread");

        // IMPORTANT: Calling run() directly does NOT create a new thread
        // It just executes the run() method like any normal method in the current thread
        // t1.run();
    }
}
