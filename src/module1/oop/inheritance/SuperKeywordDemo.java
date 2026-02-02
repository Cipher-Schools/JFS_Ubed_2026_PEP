package module1.oop.inheritance;

// Super keyword is used to refer to immediate parent class object
// 1. super() -> Calls immediate parent constructor
// 2. super.variableName -> Calls immediate parent variable
// 3. super.methodName() -> Calls immediate parent method

class Parent {
    String name = "Parent Variable";

    Parent() {
        System.out.println("Parent Constructor Called");
    }

    void display() {
        System.out.println("Parent Method Called");
    }
}

class Child extends Parent {
    String name = "Child Variable";

    Child() {
        super(); // 1. Must be first line! Calls Parent Constructor
        System.out.println("Child Constructor Called");
    }

    void display() {
        super.display(); // 3. Calls Parent display()
        System.out.println("Child Method Called");
    }

    void showData() {
        System.out.println("Name in Child: " + name);
        System.out.println("Name in Parent: " + super.name); // 2. Access Parent Variable
    }
}

public class SuperKeywordDemo {
    public static void main(String[] args) {
        System.out.println("--- Constructor Chaining (super()) ---");
        Child obj = new Child();

        System.out.println("\n--- Variable Access (super.variable) ---");
        obj.showData();

        System.out.println("\n--- Method Interaction (super.method()) ---");
        obj.display();
        
        // Try This:
        // 1. Remove 'super()' from Child constructor (Java adds it implicitly!)
        // 2. Change Parent variable name and try accessing it without 'super'.
    }
}
