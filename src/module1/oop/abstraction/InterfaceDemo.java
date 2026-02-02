package module1.oop.abstraction;

// Interface - 100% abstraction, only method signatures
interface Drawable {
    void draw(); // public abstract by default
    void resize(int width, int height);

    // Static method in Interface (Java 8+)
    static void printInfo() {
        System.out.println("I am a static method in Drawable interface.");
    }
}

interface Colorable {
    void setColor(String color);
}

// Class implementing interface must provide implementations
class Circle implements Drawable, Colorable {
    private int radius;
    private String color;
    
    public Circle(int radius) {
        this.radius = radius;
    }
    
    @Override
    public void draw() {
        System.out.println("Drawing circle with radius " + radius);
    }
    
    @Override
    public void resize(int width, int height) {
        this.radius = width / 2;
        System.out.println("Circle resized to radius " + radius);
    }
    
    @Override
    public void setColor(String color) {
        this.color = color;
        System.out.println("Circle color set to " + color);
    }
}

public class InterfaceDemo {
    public static void main(String[] args) {
        Circle circle = new Circle(5);
        circle.draw();
        circle.setColor("Red");
        circle.resize(20, 20);
        
        // Calling static method of Interface
        Drawable.printInfo();
        
        // Try This:
        // 1. Try calling printInfo() using the object 'circle.printInfo()' -> Does it work?
        // 2. Add a 'default' method in Drawable interface and call it using 'circle' object.
        //    (default void common() { ... })
    }
}
