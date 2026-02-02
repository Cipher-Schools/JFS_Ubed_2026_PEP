package module2.collections.list.arraylist;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IterationDemo {
    public static void main(String[] args) {
        List<String> cities = new ArrayList<>();
        cities.add("New York");
        cities.add("London");
        cities.add("Tokyo");
        cities.add("Paris");
        
        // 1. Fundamental for loop (access to index)
        System.out.println("--- Traditional For Loop ---");
        for (int i = 0; i < cities.size(); i++) {
            System.out.println(cities.get(i));
        }
        
        // 2. Enhanced for loop (cleaner syntax, no index)
        System.out.println("\n--- Enhanced For Loop ---");
        for (String city : cities) {
            System.out.println(city);
        }
        
        // 3. Iterator (safe removal while iterating)
        System.out.println("\n--- Iterator ---");
        Iterator<String> iterator = cities.iterator();
        while (iterator.hasNext()) {
            String city = iterator.next();
            System.out.println(city);
            if (city.equals("London")) {
                // iterator.remove(); // This is safe only with Iterator
            }
        }
        
        // 4. Java 8 forEach (functional style)
        System.out.println("\n--- Java 8 forEach ---");
        cities.forEach(System.out::println);
    }
}
