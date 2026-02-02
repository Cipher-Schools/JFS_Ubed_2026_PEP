package module1.oop.staticmembers;

// Static block and constants
public class MathUtility {
    public static final double PI = 3.14159;  // static constant
    private static String libraryName;
    
    // Static block - executes when class is loaded
    static {
        libraryName = "Math Utility Library";
        System.out.println("Static block executed");
        System.out.println("Library loaded: " + libraryName);
    }
    
    // Static utility methods
    public static int square(int num) {
        return num * num;
    }
    
    public static double circleArea(double radius) {
        return PI * radius * radius;
    }
    
    public static void main(String[] args) {
        // No need to create object for static methods
        System.out.println("\nSquare of 5: " + MathUtility.square(5));
        System.out.println("Circle area (r=3): " + MathUtility.circleArea(3));
        System.out.println("PI value: " + MathUtility.PI);
    }
}
