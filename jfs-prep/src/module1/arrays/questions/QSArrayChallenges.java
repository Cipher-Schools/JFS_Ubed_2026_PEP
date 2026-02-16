package module1.arrays.questions;

import java.util.Arrays;

public class QSArrayChallenges {
    public static void main(String[] args) {
        int[] arr = {10, 20, 20, 5, 30, 30, 40};
        
        System.out.println("Original Array: " + Arrays.toString(arr));
        System.out.println("Second Largest: " + findSecondLargest(arr));
        
        int[] unique = removeDuplicatesNaive(arr);
        System.out.println("After removing duplicates (Naive): " + Arrays.toString(unique));
    }

    public static int findSecondLargest(int[] arr) {
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        for (int num : arr) {
            if (num > largest) {
                secondLargest = largest;
                largest = num;
            } else if (num > secondLargest && num != largest) {
                secondLargest = num;
            }
        }
        return secondLargest;
    }

    // Naive approach using a new array and checking existence
    public static int[] removeDuplicatesNaive(int[] arr) {
        int n = arr.length;
        int[] temp = new int[n];
        int j = 0;

        for (int i = 0; i < n; i++) {
            boolean exists = false;
            // Check if element is already in temp
            for (int k = 0; k < j; k++) {
                if (temp[k] == arr[i]) {
                    exists = true;
                    break;
                }
            }
            if (!exists) {
                temp[j++] = arr[i];
            }
        }

        // Create exact size array
        int[] result = new int[j];
        for(int i=0; i<j; i++) result[i] = temp[i];
        
        return result;
    }
}
