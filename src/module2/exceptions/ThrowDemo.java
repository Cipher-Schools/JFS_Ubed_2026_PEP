package module2.exceptions;

// throw - manually throws exception
public class ThrowDemo {
    
    public static void checkAge(int age) {
        if (age < 18) {
            throw new ArithmeticException("Age must be 18 or above");
        }
        System.out.println("Age is valid: " + age);
    }
    
    public static void validateScore(int score) {
        if (score < 0 || score > 100) {
            throw new IllegalArgumentException("Score must be between 0-100");
        }
        System.out.println("Score is valid: " + score);
    }
    
    public static void main(String[] args) {
        try {
            checkAge(20);
            checkAge(15); // will throw exception
        } catch (ArithmeticException e) {
            System.out.println("Error: " + e.getMessage());
        }
        
        try {
            validateScore(85);
            validateScore(150); // will throw exception
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
