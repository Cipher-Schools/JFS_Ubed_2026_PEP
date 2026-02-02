package module2.collections.map;

import java.util.LinkedHashMap;
import java.util.Map;

// LinkedHashMap - maintains insertion order, slightly slower than HashMap
public class LinkedHashMapDemo {
    public static void main(String[] args) {
        LinkedHashMap<String, String> capitals = new LinkedHashMap<>();
        
        // Maintains order of insertion
        capitals.put("India", "New Delhi");
        capitals.put("USA", "Washington DC");
        capitals.put("Japan", "Tokyo");
        capitals.put("France", "Paris");
        
        // Iteration maintains insertion order
        System.out.println("Capitals (insertion order):");
        for (Map.Entry<String, String> entry : capitals.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
        
        // Update doesn't change position
        capitals.put("India", "Delhi");
        System.out.println("\nAfter update (order preserved):");
        capitals.forEach((k, v) -> System.out.println(k + " -> " + v));
    }
}
