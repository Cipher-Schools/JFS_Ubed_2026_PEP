package module1.oop.inheritance;

// Parent class (superclass)
class Animal {
    String name;
    int age;
    
    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }
    
    public void eat() {
        System.out.println(name + " is eating");
    }
    
    public void sleep() {
        System.out.println(name + " is sleeping");
    }
}

// Child class (subclass) - inherits from Animal
class Dog extends Animal {
    String breed;
    
    public Dog(String name, int age, String breed) {
        super(name, age); // calling parent constructor
        this.breed = breed;
    }
    
    // Dog-specific method
    public void bark() {
        System.out.println(name + " is barking: Woof! Woof!");
    }
}

public class InheritanceBasics {
    public static void main(String[] args) {
        Dog dog = new Dog("Buddy", 3, "Golden Retriever");
        
        // Inherited methods
        dog.eat();
        dog.sleep();
        
        // Own method
        dog.bark();
        
        System.out.println("\nDog details: " + dog.name + ", " + 
                         dog.age + " years, " + dog.breed);
    }
}
