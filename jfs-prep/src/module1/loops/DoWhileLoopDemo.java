package module1.loops;

// do-while loop - executes at least once
public class DoWhileLoopDemo {
    public static void main(String[] args) {
        // Executes at least once even if condition is false
        int num = 1;
        do {
            System.out.println("Number: " + num);
            num++;
        } while (num <= 5);
        
        // Shows difference: condition false from start
        System.out.println("\nCondition false from start:");
        int x = 10;
        do {
            System.out.println("This prints once: " + x);
        } while (x < 5); // false, but still executed once
    }
}
