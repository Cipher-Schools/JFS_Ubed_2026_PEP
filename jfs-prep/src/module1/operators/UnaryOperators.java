package module1.operators;

/*
 * Unary Operators:
 * Operators that require only one operand.
 * Used for incrementing/decrementing a value, negating an expression, or inverting a boolean.
 */

// Unary operators: ++ (increment), -- (decrement)
public class UnaryOperators {
    public static void main(String[] args) {
        int x = 10;
        
        System.out.println("Initial x: " + x);
        
        // Post-increment: use then increase
        System.out.println("Post-increment x++: " + (x++));
        System.out.println("After post-increment: " + x);
        
        // Pre-increment: increase then use
        System.out.println("Pre-increment ++x: " + (++x));
        
        // Post-decrement
        System.out.println("Post-decrement x--: " + (x--));
        System.out.println("After post-decrement: " + x);
        
        // Pre-decrement
        System.out.println("Pre-decrement --x: " + (--x));
        // Unary Plus (+) and Minus (-)
        int positive = +10; // Unary plus (optional, default)
        int negative = -10; // Unary minus (negates value)
        
        System.out.println("\nUnary Positive: " + positive);
        System.out.println("Unary Negative: " + negative);
    }
}
