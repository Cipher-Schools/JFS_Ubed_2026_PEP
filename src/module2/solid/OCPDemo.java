package module2.solid;
// OCP - Open/Closed Principle
// Software entities (classes, modules, functions) should be OPEN for extension,
// but CLOSED for modification.

// [BAD Example]
// If we want to add a "SeniorCitizen" discount, we have to key modifying this class.
class Discount {
	void giveDiscount(String type) {
		if (type.equals("Student")) {
			// gives student discount
		} else if (type.equals("Faculty")) {
			// gives faculty discount
		} else {
			// standard price
		}
	}
}

// [GOOD Example]
// We use interface (or abstract class) to represent the behavior.
// To add a new discount type, we create a NEW class implementing the interface.
// We do NOT modify existing code.
interface DiscountStrategy {
	void giveDiscount();
}

class StudentDiscount implements DiscountStrategy {
	@Override
	public void giveDiscount() {
		System.out.println("Applying Student Discount");
	}
}

class FacultyDiscount implements DiscountStrategy {
	@Override
	public void giveDiscount() {
		System.out.println("Applying Faculty Discount");
	}
}

public class OCPDemo {
	public static void main(String[] args) {
		DiscountStrategy student = new StudentDiscount();
		student.giveDiscount(); // Output: Applying Student Discount

		DiscountStrategy faculty = new FacultyDiscount();
		faculty.giveDiscount(); // Output: Applying Faculty Discount
	}
}
