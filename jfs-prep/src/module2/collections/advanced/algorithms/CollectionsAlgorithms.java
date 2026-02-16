package module2.collections.advanced.algorithms;

import java.util.ArrayList;
import java.util.Collections;

// Collections class - utility methods for sorting, searching, etc.
public class CollectionsAlgorithms {
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(45);
        numbers.add(12);
        numbers.add(78);
        numbers.add(23);
        numbers.add(56);
        
        System.out.println("Original: " + numbers);
        
        // Sorting - ascending order
        Collections.sort(numbers);
        System.out.println("Sorted: " + numbers);
        
        // Reverse order
        Collections.reverse(numbers);
        System.out.println("Reversed: " + numbers);
        
        // Binary search - works only on sorted list
        Collections.sort(numbers);
        int index = Collections.binarySearch(numbers, 45);
        System.out.println("45 found at index: " + index);
        
        // Min and Max
        System.out.println("Min: " + Collections.min(numbers));
        System.out.println("Max: " + Collections.max(numbers));
        
        // Shuffle - random order
        Collections.shuffle(numbers);
        System.out.println("Shuffled: " + numbers);
        
        // Frequency
        numbers.add(12);
        numbers.add(12);
        System.out.println("Frequency of 12: " + Collections.frequency(numbers, 12));
    }
}
