package module2.exceptions;

public class MultipleCatchBlocks {
    public static void main(String[] args) {
        // Multiple catch blocks - handles different exception types
        try {
            String text = null;
            System.out.println(text.length()); // NullPointerException
            
            int result = 10 / 0; // ArithmeticException
            
        } catch (NullPointerException e) {
            System.out.println("Null pointer error: " + e.getMessage());
        } catch (ArithmeticException e) {
            System.out.println("Arithmetic error: " + e.getMessage());
        } catch (Exception e) { // catches any other exception
            System.out.println("General error: " + e.getMessage());
        }
        
        System.out.println("Program continues after exception");
    }
}
