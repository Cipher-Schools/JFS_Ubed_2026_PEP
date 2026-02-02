package module2.solid;
// LSP - Liskov Substitution Principle
// Subtypes must be substitutable for their base types without breaking the application.

// [BAD Example]
// Square extends Rectangle.
class RectangleBad {
	int width;
	int height;

	void setWidth(int width) { this.width = width; }
	void setHeight(int height) { this.height = height; }
	int getArea() { return width * height; }
}

class SquareBad extends RectangleBad {
	@Override
	void setWidth(int width) {
		super.setWidth(width);
		super.setHeight(width); // Side effect: changes height too!
	}
	@Override
	void setHeight(int height) {
		super.setWidth(height);
		super.setHeight(height);
	}
}

// [GOOD Example]
// Separation. Do not force inheritance if behavior is different.
// Both implement a common interface.
interface Shape {
	int getArea();
}

class Rectangle implements Shape {
	int l, b;
	Rectangle(int l, int b) { this.l = l; this.b = b; }
	@Override
	public int getArea() { return l * b; }
}

class Square implements Shape {
	int side;
	Square(int side) { this.side = side; }
	@Override
	public int getArea() { return side * side; }
}

public class LSPDemo {
	public static void main(String[] args) {
		// Validating Good Design
		Shape rect = new Rectangle(10, 5);
		System.out.println("Rectangle Area: " + rect.getArea());

		Shape sq = new Square(5);
		System.out.println("Square Area: " + sq.getArea());
	}
}
