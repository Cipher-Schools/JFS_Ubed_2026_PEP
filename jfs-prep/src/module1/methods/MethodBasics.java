package module1.methods;

/*
 * Java Methods:
 * A block of code that performs a specific task and runs only when called.
 * Methods can accept parameters and return values, promoting code reusability.
 */

// Basic method definition with parameters and return types
public class MethodBasics {
    public static void main(String[] args) {
        greet(); // calling void method
        
        int sum = add(10, 20); // calling method with return value
        System.out.println("Sum: " + sum);
        
        double area = calculateArea(5.5);
        System.out.println("Circle area: " + area);
    }
    
    // Method without parameters and return type
    public static void greet() {
        System.out.println("Hello! Welcome to Java methods.");
    }
    
    // Method with parameters and return type
    public static int add(int a, int b) {
        return a + b;
    }
    
    // Method with one parameter and return value
    public static double calculateArea(double radius) {
        return 3.14159 * radius * radius;
    }
}
