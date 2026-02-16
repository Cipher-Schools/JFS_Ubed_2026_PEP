package module2.collections.basics.map;

import java.util.HashMap;
import java.util.Map;

public class HashMapDemo {
    public static void main(String[] args) {
        // HashMap: Key-Value pairs. Keys must be unique. Unordered.
        Map<String, Integer> scores = new HashMap<>();
        
        // 1. put(K key, V value) - Inserts or Updates value for key
        scores.put("Alice", 95);
        scores.put("Bob", 80);
        scores.put("Alice", 99); // Updates Alice's score to 99
        
        // 2. get(Object key) - Retrieve value or null if not found
        System.out.println("Alice's score: " + scores.get("Alice"));
        
        // 3. containsKey(Object key) - Check if key exists
        if (scores.containsKey("Bob")) {
            System.out.println("Bob is present.");
        }
        
        // 4. remove(Object key) - Removes pair by key
        scores.remove("Bob");
        
        // 5. keySet() / values() - Get all keys or values
        System.out.println("Keys: " + scores.keySet());
        
        System.out.println("Map: " + scores);
        
        // Try This:
        // 1. Use putIfAbsent("Alice", 100) -> Does it change the score?
        // 2. Change HashMap to TreeMap -> Are keys sorted?
        // 3. Try putting null as a key.
    }
}
