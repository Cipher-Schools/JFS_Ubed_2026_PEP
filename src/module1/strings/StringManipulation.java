package module1.strings;

// String manipulation and splitting
public class StringManipulation {
    public static void main(String[] args) {
        String sentence = "  Java is awesome  ";
        
        // Trim - removes leading and trailing spaces
        System.out.println("Trimmed: '" + sentence.trim() + "'");
        
        // Replace
        String text = "I love Python";
        System.out.println("Replaced: " + text.replace("Python", "Java"));
        
        // Split - divides string into array
        String fruits = "apple,banana,orange,mango";
        String[] fruitArray = fruits.split(",");
        System.out.println("\nSplit fruits:");
        for (String fruit : fruitArray) {
            System.out.println("- " + fruit);
        }
        
        // Contains
        String message = "Hello World";
        System.out.println("\nContains 'World': " + message.contains("World"));
        
        // Starts with and ends with
        System.out.println("Starts with 'Hello': " + message.startsWith("Hello"));
        System.out.println("Ends with 'World': " + message.endsWith("World"));
    }
}
