package module1.oop.abstraction.questions;

// Abstract base class
abstract class Shape {
    abstract double area();
    abstract double perimeter();
}

class Circle extends Shape {
    double radius;
    
    Circle(double radius) {
        this.radius = radius;
    }
    
    @Override
    double area() {
        return Math.PI * radius * radius;
    }
    
    @Override
    double perimeter() {
        return 2 * Math.PI * radius;
    }
}

class Rectangle extends Shape {
    double length, width;
    
    Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }
    
    @Override
    double area() {
        return length * width;
    }
    
    @Override
    double perimeter() {
        return 2 * (length + width);
    }
}

class Triangle extends Shape {
    double a, b, c;
    
    Triangle(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    
    @Override
    double area() {
        // Heron's formula
        double s = (a + b + c) / 2;
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }
    
    @Override
    double perimeter() {
        return a + b + c;
    }
}

public class QSShapeHierarchy {
    public static void main(String[] args) {
        Shape c = new Circle(5);
        Shape r = new Rectangle(4, 5);
        Shape t = new Triangle(3, 4, 5);
        
        printShape(c, "Circle");
        printShape(r, "Rectangle");
        printShape(t, "Triangle");
    }
    
    static void printShape(Shape s, String name) {
        System.out.println(name + " Area: " + String.format("%.2f", s.area()));
        System.out.println(name + " Perimeter: " + String.format("%.2f", s.perimeter()));
        System.out.println();
    }
}
