package module2.collections.list.arraylist;

import java.util.ArrayList;
import java.util.List;

public class ArrayListDemo {
    public static void main(String[] args) {
        // ArrayList: Resizable array. Fast for reading O(1), slow for inserting/deleting in middle O(N).
        List<String> fruits = new ArrayList<>();
        
        // 1. add(E e) - Appends element to end
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Orange");
        
        // 2. get(int index) - Returns element at position
        System.out.println("Fruit at index 1: " + fruits.get(1)); // Banana
        
        // 3. set(int index, E element) - Replaces element
        fruits.set(1, "Mango"); // Replaces Banana with Mango
        
        // 4. remove(int index) or remove(Object o) - Removes element
        fruits.remove(0); // Removes Apple
        
        // 5. size() - Returns number of elements
        System.out.println("Total fruits: " + fruits.size());
        
        System.out.println("Final List: " + fruits);
        
        // Try This:
        // 1. Try adding a duplicate element (e.g., "Mango") -> Does ArrayList allow duplicates?
        // 2. Try accessing an index larger than size (e.g., get(10)) -> What exception do you get?
        // 3. Use add(0, "Grapes") to add at start.
    }
}
