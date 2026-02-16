package module2.exceptions;

// Custom exception - extend Exception class for checked exception
class InvalidAgeException extends Exception {
    public InvalidAgeException(String message) {
        super(message);
    }
}

public class CustomExceptionDemo {
    
    public static void validateVoterAge(int age) throws InvalidAgeException {
        if (age < 18) {
            throw new InvalidAgeException("Age " + age + " is too young to vote");
        }
        System.out.println("Age " + age + " is eligible to vote");
    }
    
    public static void main(String[] args) {
        try {
            validateVoterAge(25);
            validateVoterAge(15); // throws custom exception
        } catch (InvalidAgeException e) {
            System.out.println("Validation error: " + e.getMessage());
        }
    }
}
