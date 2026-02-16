package module1.oop.staticmembers;

// Static vs Instance members
public class Counter {
    static int staticCount = 0;    // shared by all objects
    int instanceCount = 0;          // separate for each object
    
    public Counter() {
        staticCount++;
        instanceCount++;
    }
    
    public void displayCounts() {
        System.out.println("Static count: " + staticCount + 
                         ", Instance count: " + instanceCount);
    }
    
    // Static method - can be called without creating object
    public static void showStaticCount() {
        System.out.println("Static count from static method: " + staticCount);
        // System.out.println(instanceCount); // ERROR: can't access instance variable
    }
    
    public static void main(String[] args) {
        Counter c1 = new Counter();
        c1.displayCounts();
        
        Counter c2 = new Counter();
        c2.displayCounts();
        
        Counter c3 = new Counter();
        c3.displayCounts();
        
        Counter.showStaticCount(); // calling static method
    }
}
