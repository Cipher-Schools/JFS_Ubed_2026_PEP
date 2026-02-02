package module1.oop.inheritance;

// Multilevel inheritance - A -> B -> C
class Vehicle {
    String brand;
    
    public Vehicle(String brand) {
        this.brand = brand;
        System.out.println("Vehicle constructor called");
    }
    
    public void start() {
        System.out.println("Vehicle starting...");
    }
}

class Car extends Vehicle {
    int doors;
    
    public Car(String brand, int doors) {
        super(brand);
        this.doors = doors;
        System.out.println("Car constructor called");
    }
    
    public void drive() {
        System.out.println("Driving the car");
    }
}

class ElectricCar extends Car {
    int batteryCapacity;
    
    public ElectricCar(String brand, int doors, int batteryCapacity) {
        super(brand, doors);
        this.batteryCapacity = batteryCapacity;
        System.out.println("ElectricCar constructor called");
    }
    
    public void charge() {
        System.out.println("Charging battery (" + batteryCapacity + " kWh)");
    }
}

public class MultilevelInheritance {
    public static void main(String[] args) {
        System.out.println("Creating Electric Car:\n");
        ElectricCar tesla = new ElectricCar("Tesla", 4, 100);
        
        System.out.println("\nCalling methods:");
        tesla.start();    // from Vehicle
        tesla.drive();    // from Car
        tesla.charge();   // from ElectricCar
    }
}
