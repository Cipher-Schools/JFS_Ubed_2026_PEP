package module1.oop.inheritance;
// constructor chaining

class AnimalParent {
    AnimalParent() {
        this("test");
        System.out.println("constructor 1");
    }
    AnimalParent (String name) {
        this(24);
        System.out.println("constructor 2" + name);
    }
    AnimalParent (int count) {
        System.out.println("constructor 3" + count);
    }
}

public class ConstructorChainingDemo extends AnimalParent {
    public static void main(String[] args) {
        System.out.println("--- Constructor Chaining Demo ---");
        AnimalParent tommy = new AnimalParent();
    }
}
