package module1.methods;

// Method overloading - same name, different parameters
public class MethodOverloading {
    public static void main(String[] args) {
        System.out.println("Sum of 2 ints: " + add(10, 20));
        System.out.println("Sum of 3 ints: " + add(10, 20, 30));
        System.out.println("Sum of 2 doubles: " + add(10.5, 20.5));
        
        display("John");
        display("Jane", 25);
    }
    
    // Same method name with different number of parameters
    public static int add(int a, int b) {
        return a + b;
    }
    
    public static int add(int a, int b, int c) {
        return a + b + c;
    }
    
    // Same method name with different parameter types
    public static double add(double a, double b) {
        return a + b;
    }
    
    public static void display(String name) {
        System.out.println("Name: " + name);
    }
    
    public static void display(String name, int age) {
        System.out.println("Name: " + name + ", Age: " + age);
    }
}
