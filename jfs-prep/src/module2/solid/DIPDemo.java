package module2.solid;
// DIP - Dependency Inversion Principle
// High-level modules should not depend on low-level modules. Both should depend on abstractions.

// Abstraction
interface SaveToDB {
	void save();
}

// Low-level module 1
class MySQLDB implements SaveToDB {
	public void save() {
		System.out.println("Saving to MySQL...");
	}
}

// Low-level module 2
class MongoDB implements SaveToDB {
	public void save() {
		System.out.println("Saving to Mongo...");
	}
}

// [Bad Example]
// High-level module depending directly on low-level module
class UserServiceBad {
	MySQLDB db = new MySQLDB(); // Tightly coupled
	void saveUser() {
		db.save();
	}
}

// [Good Example]
// High-level module depends on abstraction (SaveToDB interface)
class UserService {
	SaveToDB db;

	// Dependency Injection via Constructor
	UserService(SaveToDB db) {
		this.db = db;
	}

	void saveUser() {
		db.save();
	}
}

public class DIPDemo {
	public static void main(String[] args) {
		// Using MySQL
		SaveToDB mysql = new MySQLDB();
		UserService u1 = new UserService(mysql);
		u1.saveUser();

		// Using Mongo
		SaveToDB mongo = new MongoDB();
		UserService u2 = new UserService(mongo);
		u2.saveUser();
	}
}
