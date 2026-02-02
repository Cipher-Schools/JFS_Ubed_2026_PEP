package module1.primitives;

import java.util.Scanner;

// Scanner class usage - reading different types of input from user
public class ScannerInputDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        
        System.out.print("Enter your age: ");
        int age = scanner.nextInt();
        
        System.out.print("Enter your height in meters: ");
        double height = scanner.nextDouble();
        
        System.out.print("Are you a student (true/false): ");
        boolean isStudent = scanner.nextBoolean();
        
        // Different output methods
        System.out.println("\n=== Your Information ===");
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Height: " + height + "m");
        System.out.println("Student status: " + isStudent);
        
        scanner.close();
    }
}
