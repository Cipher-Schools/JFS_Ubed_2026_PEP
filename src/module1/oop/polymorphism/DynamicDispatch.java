package module1.oop.polymorphism;

// Dynamic dispatch (runtime polymorphism)
class Employee {
    String name;
    
    public Employee(String name) {
        this.name = name;
    }
    
    public void work() {
        System.out.println(name + " is working");
    }
    
    public double calculateSalary() {
        return 30000;
    }
}

class Manager extends Employee {
    public Manager(String name) {
        super(name);
    }
    
    @Override
    public void work() {
        System.out.println(name + " is managing the team");
    }
    
    @Override
    public double calculateSalary() {
        return 50000;
    }
}

class Developer extends Employee {
    public Developer(String name) {
        super(name);
    }
    
    @Override
    public void work() {
        System.out.println(name + " is writing code");
    }
    
    @Override
    public double calculateSalary() {
        return 45000;
    }
}

public class DynamicDispatch {
    public static void main(String[] args) {
        // Parent reference, child object - polymorphism
        Employee emp1 = new Manager("Alice");
        Employee emp2 = new Developer("Bob");
        Employee emp3 = new Employee("Charlie");
        
        // Method called depends on actual object type (runtime)
        emp1.work();
        System.out.println("Salary: $" + emp1.calculateSalary());
        
        emp2.work();
        System.out.println("Salary: $" + emp2.calculateSalary());
        
        emp3.work();
        System.out.println("Salary: $" + emp3.calculateSalary());
    }
}
