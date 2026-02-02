package module2.exceptions;

public class FinallyBlockDemo {
    public static void main(String[] args) {
        // finally block - always executes, even if exception occurs
        try {
            System.out.println("In try block");
            int result = 10 / 0;
        } catch (ArithmeticException e) {
            System.out.println("In catch block");
        } finally {
            System.out.println("In finally block - always executes");
        }
        
        System.out.println();
        
        // finally executes even without exception
        try {
            System.out.println("Try without error");
        } finally {
            System.out.println("Finally still executes");
        }
    }
}
