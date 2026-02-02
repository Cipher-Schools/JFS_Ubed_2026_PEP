package module1.loops;

// for loop - when you know number of iterations
public class ForLoopDemo {
    public static void main(String[] args) {
        // Print numbers 1 to 10
        System.out.println("Numbers 1 to 10:");
        for (int i = 1; i <= 10; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        
        // Print even numbers from 2 to 20
        System.out.println("\nEven numbers 2 to 20:");
        for (int i = 2; i <= 20; i += 2) {
            System.out.print(i + " ");
        }
        System.out.println();
        
        // Print multiplication table
        int num = 5;
        System.out.println("\nMultiplication table of " + num + ":");
        for (int i = 1; i <= 10; i++) {
            System.out.println(num + " x " + i + " = " + (num * i));
        }
    }
}
