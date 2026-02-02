package module1.generics;

// Generic class - works with any type instead of specific type
class Box<T> {
    private T content;
    
    public void set(T content) {
        this.content = content;
    }
    
    public T get() {
        return content;
    }
}

public class GenericClassDemo {
    public static void main(String[] args) {
        // Box for Integer - type safety at compile time
        Box<Integer> intBox = new Box<>();
        intBox.set(100);
        System.out.println("Integer box: " + intBox.get());
        
        // Box for String - same class, different type
        Box<String> strBox = new Box<>();
        strBox.set("Hello Generics");
        System.out.println("String box: " + strBox.get());
        
        // Box for Double
        Box<Double> doubleBox = new Box<>();
        doubleBox.set(99.99);
        System.out.println("Double box: " + doubleBox.get());
    }
}
