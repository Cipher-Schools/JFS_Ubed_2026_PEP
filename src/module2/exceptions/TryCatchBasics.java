package module2.exceptions;

public class TryCatchBasics {
    public static void main(String[] args) {
        // try-catch handles runtime errors without crashing program
        try {
            int[] numbers = {1, 2, 3};
            System.out.println("Accessing index 5: " + numbers[5]); // error!
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: Array index out of bounds");
            System.out.println("Message: " + e.getMessage());
        }
        
        System.out.println("Program continues...");
        
        // Division by zero example
        try {
            int result = 10 / 0;
        } catch (ArithmeticException e) {
            System.out.println("Error: Cannot divide by zero");
        }
        
        System.out.println("Program still running!");
    }
}
