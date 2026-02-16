package module1.loops;

// Nested loops - loop inside another loop
public class NestedLoopDemo {
    public static void main(String[] args) {
        // Print a pattern using nested loops
        System.out.println("Pattern:");
        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
        
        // Multiplication table (1 to 3)
        System.out.println("\nMultiplication tables:");
        for (int i = 1; i <= 3; i++) {
            for (int j = 1; j <= 5; j++) {
                System.out.print(i + "x" + j + "=" + (i*j) + "  ");
            }
            System.out.println();
        }
    }
}
