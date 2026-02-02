package module2.collections.set;

import java.util.HashSet;
import java.util.Set;

public class HashSetDemo {
    public static void main(String[] args) {
        // HashSet: Unique items only. Unordered. Fast lookup O(1).
        Set<String> countries = new HashSet<>();
        
        // 1. add(E e) - Adds element if not present (returns true if added)
        countries.add("India");
        countries.add("USA");
        countries.add("Japan");
        boolean addedAgain = countries.add("India"); // returns false
        System.out.println("Added India again? " + addedAgain);
        
        // 2. contains(Object o) - Checks existence (Very Fast)
        System.out.println("Contains USA: " + countries.contains("USA"));
        
        // 3. remove(Object o) - Removes element
        countries.remove("Japan");
        
        // 4. size() - Number of elements
        System.out.println("Size: " + countries.size());
        
        // 5. isEmpty() - Checks if empty
        System.out.println("Is empty? " + countries.isEmpty());
        
        System.out.println("Set: " + countries);
        
        // Try This:
        // 1. Change HashSet to LinkedHashSet -> Does it maintain insertion order?
        // 2. Change HashSet to TreeSet -> Does it sort the elements alphabetically?
    }
}
