package module1.arrays;

// Array searching algorithms
public class ArraySearching {
    public static void main(String[] args) {
        int[] numbers = {15, 23, 8, 42, 19, 31, 5};
        int target = 19;
        
        // Linear search
        int index = linearSearch(numbers, target);
        if (index != -1) {
            System.out.println("Found " + target + " at index " + index);
        } else {
            System.out.println(target + " not found");
        }
        
        // Find maximum element
        int max = findMax(numbers);
        System.out.println("Maximum element: " + max);
    }
    
    // Linear search - checks each element one by one
    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }
    
    public static int findMax(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }
}
