package module2.solid;
// SRP - Single Responsibility Principle
// A class should have only one reason to change.
// It should have only one responsibility.

// [BAD Example]
// This class handles calculation, printing, AND database saving.
// If printing logic changes, this class changes. If DB logic changes, this class changes.
class Invoice {
	void calculateInvoice() {
		// Logic to calculate total
	}

	void printInvoice() {
		// Logic to print invoice
	}

	void saveToDB() {
		// Logic to save to database
	}
}

// [GOOD Example]
// Separation of concerns: Each class has a single responsibility.

// Responsible only for calculation
class InvoiceCalculation {
	void calculateInvoice() {}
}

// Responsible only for printing
class InvoicePrint {
	void printInvoice() {}
}

// Responsible only for persistence
class SaveInvoice {
    void saveToDB(){};
}

public class SRPDemo {
	public static void main(String[] args) {
		// Usage example (Clean separation)
		InvoiceCalculation ic = new InvoiceCalculation();
		ic.calculateInvoice();

		InvoicePrint ip = new InvoicePrint();
		ip.printInvoice();

		SaveInvoice si = new SaveInvoice();
		si.saveToDB();
	}
}
