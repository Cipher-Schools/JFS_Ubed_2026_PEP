package module1.primitives;

/*
 * Primitive Data Types:
 * The most basic data types available in Java language. 
 * There are 8 types: boolean, byte, char, short, int, long, float, and double.
 */

// Focus on these 4 used in 99% of interviews/daily work:
// 1. int (32-bit) - Default for whole numbers
// 2. long (64-bit) - For very large numbers
// 3. double (64-bit) - Default for decimals
// 4. boolean - For logic

public class AllPrimitives {
    public static void main(String[] args) {
        // --- MOST IMPORTANT (Interview Core) ---
        
        int population = 100000;      // 32-bit: Standard whole number
        long worldPop = 8000000000L;  // 64-bit: Large (add 'L')
        long amount = 100_00_00_000L; // We can also use underscore for better readbility
        
        double price = 19.99;         // 64-bit: Standard decimal
        boolean isJavaFun = true;     // true/false: Logic control
        
        System.out.println("--- Core Types ---");
        System.out.println("int: " + population);
        System.out.println("long: " + worldPop);
        System.out.println("double: " + price);
        System.out.println("boolean: " + isJavaFun);

        // --- LESS COMMON (Know they exist) ---
        
        byte age = 25;           // 8-bit: Very small numbers
        short year = 2024;       // 16-bit: Small numbers
        float tax = 2.5f;        // 32-bit: Smaller decimal (add 'f')
        char grade = 'A';        // 16-bit: Single character
        
        System.out.println("\n--- Other Types ---");
        System.out.println("char: " + grade); 
        // byte, short, float are rarely used in standard interview problems
    }
}
