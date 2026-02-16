package module1.generics;

// Bounded type parameters - restricts generic type to specific types
class Calculator<T extends Number> { // T must be Number or its subclass
    private T num1;
    private T num2;
    
    public Calculator(T num1, T num2) {
        this.num1 = num1;
        this.num2 = num2;
    }
    
    // Can use Number methods because T extends Number
    public double sum() {
        return num1.doubleValue() + num2.doubleValue();
    }
    
    public double multiply() {
        return num1.doubleValue() * num2.doubleValue();
    }
}

public class BoundedTypesDemo {
    public static void main(String[] args) {
        // Works with Integer (subclass of Number)
        Calculator<Integer> intCalc = new Calculator<>(10, 20);
        System.out.println("Integer sum: " + intCalc.sum());
        
        // Works with Double (subclass of Number)
        Calculator<Double> doubleCalc = new Calculator<>(5.5, 3.5);
        System.out.println("Double multiply: " + doubleCalc.multiply());
        
        // Calculator<String> won't compile - String doesn't extend Number
    }
}
