package module2.collections.basics.map.questions;

import java.util.HashMap;
import java.util.Map;

public class QSWordFrequency {
    public static void main(String[] args) {
        // Word frequency counter using HashMap for a given paragraph.

        String paragraph = "Java is fun. Java is powerful. Java is object-oriented. I love Java.";
        System.out.println("Paragraph: " + paragraph);

        // Normalize text: remove punctuation and convert to lowercase
        String cleanedText = paragraph.replaceAll("[^a-zA-Z ]", "").toLowerCase();
        String[] words = cleanedText.split("\\s+");

        Map<String, Integer> wordCount = new HashMap<>();

        for (String word : words) {
            // If word exists, increment count, else set to 1
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        System.out.println("Word Frequencies:");
        for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
