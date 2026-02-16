package module2.java8.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamDemo {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David", "Edward");
        
        // 1. filter() - Select elements matching condition
        // Keeps names starting with 'A' or length > 4
        List<String> filtered = names.stream()
                                     .filter(name -> name.length() > 4)
                                     .collect(Collectors.toList());
        System.out.println("Filtered: " + filtered);
        
        // 2. map() - Transform each element
        // Convert to uppercase
        List<String> upperCaseNames = names.stream()
                                           .map(String::toUpperCase)
                                           .collect(Collectors.toList());
        System.out.println("Mapped (Upper): " + upperCaseNames);
        
        // 3. sorted() - Sort elements
        List<String> sortedNames = names.stream()
                                        .sorted()
                                        .collect(Collectors.toList());
        System.out.println("Sorted: " + sortedNames);

        // Try This:
        // 1. Filter names that contain the letter 'i'.
        // 2. Map names to their length (String -> Integer).
        // 3. Sort names by length descending.
    }
}
