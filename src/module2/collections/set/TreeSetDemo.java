package module2.collections.set;

import java.util.TreeSet;

// TreeSet - sorted order, no duplicates, slower than HashSet
public class TreeSetDemo {
    public static void main(String[] args) {
        TreeSet<Integer> numbers = new TreeSet<>();
        
        // Adding elements - automatically sorted
        numbers.add(50);
        numbers.add(20);
        numbers.add(80);
        numbers.add(10);
        numbers.add(20); // duplicate, ignored
        
        System.out.println("Numbers (sorted): " + numbers);
        
        // TreeSet specific methods
        System.out.println("First (smallest): " + numbers.first());
        System.out.println("Last (largest): " + numbers.last());
        
        // Elements less than 50
        System.out.println("Less than 50: " + numbers.headSet(50));
        
        // Elements greater than or equal to 50
        System.out.println("50 and above: " + numbers.tailSet(50));
        
        // Elements between 20 and 80 (20 inclusive, 80 exclusive)
        System.out.println("Between 20-80: " + numbers.subSet(20, 80));
    }
}
