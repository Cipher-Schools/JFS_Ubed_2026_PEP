package module1.arrays;

/*
 * Arrays (1D):
 * A collection of elements of the same type stored in contiguous memory locations.
 * Elements are accessed using an index (starting from 0).
 */

// One-dimensional arrays - basics
public class OneDimensionalArray {
    public static void main(String[] args) {
        // Array declaration and initialization
        int[] numbers = {10, 20, 30, 40, 50};
        
        // Accessing array elements
        System.out.println("First element: " + numbers[0]);
        System.out.println("Array length: " + numbers.length);
        
        // Traversing array using for loop
        System.out.println("\nAll elements:");
        for (int i = 0; i < numbers.length; i++) {
            System.out.println("Index " + i + ": " + numbers[i]);
        }
        
        // Enhanced for loop - (Good for reading, you wont have access to index here)
        System.out.println("\nUsing enhanced for loop:");
        for (int num : numbers) {
            System.out.print(num + " ");
        }
    }
}
