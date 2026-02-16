package module1.oop.polymorphism;

// Method overriding - same method signature in parent and child
class Shape {
    public void draw() {
        System.out.println("Drawing a shape");
    }
    
    public double area() {
        return 0.0;
    }
}

class Circle extends Shape {
    double radius;
    
    public Circle(double radius) {
        this.radius = radius;
    }
    
    @Override // annotation indicates method overriding
    public void draw() {
        System.out.println("Drawing a circle");
    }
    
    @Override
    public double area() {
        return 3.14159 * radius * radius;
    }
}

class Rectangle extends Shape {
    double length, width;
    
    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }
    
    @Override
    public void draw() {
        System.out.println("Drawing a rectangle");
    }
    
    @Override
    public double area() {
        return length * width;
    }
}

public class MethodOverriding {
    public static void main(String[] args) {
        Circle circle = new Circle(5);
        circle.draw();
        System.out.println("Circle area: " + circle.area());
        
        Rectangle rect = new Rectangle(4, 6);
        rect.draw();
        System.out.println("Rectangle area: " + rect.area());
    }
}
