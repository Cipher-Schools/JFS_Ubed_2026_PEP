package module1.oop.encapsulation;

// Access modifiers: public, private, protected, default
public class AccessModifiersDemo {
    public String publicField = "Public - accessible everywhere";
    private String privateField = "Private - only within this class";
    protected String protectedField = "Protected - within package and subclasses";
    String defaultField = "Default - within package only";
    
    // Public method - accessible from anywhere
    public void publicMethod() {
        System.out.println("Public method called");
    }
    
    // Private method - only within this class
    private void privateMethod() {
        System.out.println("Private method called");
    }
    
    public void testAccess() {
        // All fields accessible within same class
        System.out.println(publicField);
        System.out.println(privateField);
        System.out.println(protectedField);
        System.out.println(defaultField);
        privateMethod(); // can call
    }
    
    public static void main(String[] args) {
        AccessModifiersDemo demo = new AccessModifiersDemo();
        demo.testAccess();
    }
}
