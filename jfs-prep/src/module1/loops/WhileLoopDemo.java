package module1.loops;

// while loop - executes when condition is true
public class WhileLoopDemo {
    public static void main(String[] args) {
        // Count from 1 to 5
        System.out.println("Counting 1 to 5:");
        int count = 1;
        while (count <= 5) {
            System.out.println("Count: " + count);
            count++;
        }
        
        // Sum of first 10 natural numbers
        int sum = 0;
        int i = 1;
        while (i <= 10) {
            sum += i;
            i++;
        }
        System.out.println("\nSum of first 10 numbers: " + sum);
    }
}
