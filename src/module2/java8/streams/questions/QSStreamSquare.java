package module2.java8.streams.questions;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class QSStreamSquare {
    public static void main(String[] args) {
        // Use stream to filter even numbers and square them from a list.
        
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        System.out.println("Original Numbers: " + numbers);

        List<Integer> squaredEvens = numbers.stream()
            .filter(n -> n % 2 == 0)      // Filter even numbers
            .map(n -> n * n)              // Square them
            .collect(Collectors.toList());// Collect to list

        System.out.println("Squared Even Numbers: " + squaredEvens);
    }
}
