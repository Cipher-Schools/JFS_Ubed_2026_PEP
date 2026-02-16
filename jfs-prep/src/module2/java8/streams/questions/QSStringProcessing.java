package module2.java8.streams.questions;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class QSStringProcessing {
    public static void main(String[] args) {
        // Convert list of strings to uppercase, sort by length using streams
        
        List<String> words = Arrays.asList("Java", "Stream", "API", "is", "powerful");
        System.out.println("Original: " + words);

        List<String> processed = words.stream()
            .map(String::toUpperCase)              // Convert to uppercase
            .sorted(Comparator.comparingInt(String::length)) // Sort by length
            .collect(Collectors.toList());         // Collect

        System.out.println("Processed: " + processed);
        
        // Try This:
        // 1. Sort by length descending?
        //    .sorted(Comparator.comparingInt(String::length).reversed())
    }
}
