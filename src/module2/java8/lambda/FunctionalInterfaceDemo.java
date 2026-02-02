package module2.java8.lambda;

// 1. Functional Interface Definition
@FunctionalInterface
interface Calculator {
    int operate(int a, int b);
}

public class FunctionalInterfaceDemo {
    public static void main(String[] args) {
        
        // 2. Anonymous Inner Class (Pseudo Class) implementation
        // Before Java 8, we had to do this:
        Calculator adder = new Calculator() {
            @Override
            public int operate(int a, int b) {
                return a + b;
            }
        };
        System.out.println("Anonymous Class Add: " + adder.operate(5, 3));
        
        // 3. Lambda Expression implementation (The Modern Way)
        // Shorter, cleaner, does the same thing
        Calculator multiplier = (a, b) -> a * b;
        System.out.println("Lambda Multiply: " + multiplier.operate(5, 3));
        
        // 4. Lambda with block body
        Calculator safeDivide = (a, b) -> {
            if (b == 0) return 0;
            return a / b;
        };
        System.out.println("Safe Divide: " + safeDivide.operate(10, 2));
        
        // Try This:
        // 1. Create a Subtractor using Anonymous Inner Class.
        // 2. Convert it to a Lambda expression.
    }
}
