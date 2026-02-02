package module1.primitives;

import java.util.Scanner;

// Demonstrating different System.out print methods
public class PrintMethodsDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter first number: ");
        int num1 = scanner.nextInt();
        
        System.out.print("Enter second number: ");
        int num2 = scanner.nextInt();
        
        // print() - prints without newline
        System.out.print("Sum: ");
        System.out.print(num1 + num2);
        System.out.println();
        
        // println() - prints with newline
        System.out.println("Product: " + (num1 * num2));
        
        // printf() - formatted output
        System.out.printf("Division: %.2f%n", (double)num1 / num2);
        System.out.printf("Numbers are: %d and %d%n", num1, num2);
        
        scanner.close();
    }
}
