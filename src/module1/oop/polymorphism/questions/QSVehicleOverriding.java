package module1.oop.polymorphism.questions;

// Base class
class Vehicle {
    void start() {
        System.out.println("Vehicle is starting...");
    }
}

// Subclass Car
class Car extends Vehicle {
    @Override
    void start() {
        System.out.println("Car starts with a key ignition.");
    }
}

// Subclass Bike
class Bike extends Vehicle {
    @Override
    void start() {
        System.out.println("Bike starts with a kick.");
    }
}

public class QSVehicleOverriding {
    public static void main(String[] args) {
        Vehicle myCar = new Car();
        Vehicle myBike = new Bike();
        
        myCar.start();  // Calls Car's start
        myBike.start(); // Calls Bike's start
    }
}
