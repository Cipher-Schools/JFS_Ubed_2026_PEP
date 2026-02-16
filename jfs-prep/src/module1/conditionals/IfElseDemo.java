package module1.conditionals;

/*
 * Conditional Statements (If-Else):
 * Used to execute different blocks of code based on boolean conditions.
 * Includes if, else, and else-if ladder for multiple conditions.
 */

// if-else statements for decision making
public class IfElseDemo {
    public static void main(String[] args) {
        int age = 18;
        int marks = 75;
        
        // Simple if-else
        if (age >= 18) {
            System.out.println("You are an adult");
        } else {
            System.out.println("You are a minor");
        }
        
        // if-else-if ladder
        if (marks >= 90) {
            System.out.println("Grade: A");
        } else if (marks >= 75) {
            System.out.println("Grade: B");
        } else if (marks >= 60) {
            System.out.println("Grade: C");
        } else {
            System.out.println("Grade: F");
        }
    }
}
