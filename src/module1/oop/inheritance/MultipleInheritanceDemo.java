package module1.oop.inheritance;

// Multiple Inheritance:
// Java does not support multiple inheritance with classes to avoid complexity (Diamond Problem).
// However, it can be achieved using Interfaces, allowing a class to implement multiple behaviors.

interface Flyable {
    void fly();
}

interface Swimmable {
    void swim();
}

// 1. Implementing multiple interfaces
class Duck implements Flyable, Swimmable {
    @Override
    public void fly() {
        System.out.println("Duck is flying");
    }
    
    @Override
    public void swim() {
        System.out.println("Duck is swimming");
    }
}

// 2. Diamond Problem mitigation (Default Methods)
interface A {
    default void show() {
        System.out.println("A's show");
    }
}

interface B {
    default void show() {
        System.out.println("B's show");
    }
}

// Class implementing both must override the conflicting method
class TestAB implements A, B {
    @Override
    public void show() {
        // Resolve conflict manually or call a specific super
        A.super.show(); // Calls A's version
        // B.super.show(); // Calls B's version
        System.out.println("TestAB's show");
    }
}

public class MultipleInheritanceDemo {
    public static void main(String[] args) {
        System.out.println("--- Multiple Interfaces ---");
        Duck duck = new Duck();
        duck.fly();
        duck.swim();
        
        System.out.println("\n--- Diamond Problem Resolution ---");
        TestAB obj = new TestAB();
        obj.show();
    }
}
