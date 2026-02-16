package module2.solid;
// ISP - Interface Segregation Principle
// Clients should not be forced to implement interfaces they do not use.
// It is better to have specific interfaces than one general-purpose interface.

// [BAD Example]
// A "God Interface" that forces implementations to have methods they don't need.
interface BadShape {
	void getArea();
	void getDiameter(); // Not all shapes (e.g., Rectangle) have a diameter
}

class BadRectangle implements BadShape {
	@Override
	public void getArea() { System.out.println("Calculating Area"); }

	@Override
	public void getDiameter() {
		// Rectangle does not have a diameter!
		throw new UnsupportedOperationException("Rectangle has no diameter");
	}
}

// [GOOD Example]
// Segregated Interfaces

interface GoodShape {
	void getArea();
}

// Specific interface for circular shapes
interface CircleShape extends GoodShape {
	void getDiameter();
}

class GoodRectangle implements GoodShape {
	int l, b;
	GoodRectangle(int l, int b) {
		this.l = l;
		this.b = b;
	}

	@Override
	public void getArea() { System.out.println("Area: " + (l * b)); }
}

class GoodCircle implements CircleShape {
	int diameter;
	GoodCircle(int diameter) { this.diameter = diameter; }

	@Override
	public void getArea() {
		double radius = diameter / 2.0;
		System.out.println("Area: " + (3.14 * radius * radius));
	}

	@Override
	public void getDiameter() {
		System.out.println("Diameter: " + diameter);
	}
}

public class ISPDemo {
	public static void main(String[] args) {
		GoodShape rect = new GoodRectangle(3, 4);
		rect.getArea();

		GoodCircle circle = new GoodCircle(10);
		circle.getArea();
		circle.getDiameter();
	}
}
