package module1.loops;

// break and continue keywords in loops
public class BreakContinueDemo {
    public static void main(String[] args) {
        // break - exits the loop
        System.out.println("Using break:");
        for (int i = 1; i <= 10; i++) {
            if (i == 6) {
                break; // loop stops when i is 6
            }
            System.out.print(i + " ");
        }
        
        // continue - skips current iteration
        System.out.println("\n\nUsing continue:");
        for (int i = 1; i <= 10; i++) {
            if (i % 2 == 0) {
                continue; // skip even numbers
            }
            System.out.print(i + " "); // only odd numbers print
        }
        System.out.println();
    }
}
