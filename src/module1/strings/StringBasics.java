package module1.strings;

// String basics and common operations
public class StringBasics {
    public static void main(String[] args) {
        String name = "Java Programming";
        
        // String length
        System.out.println("Length: " + name.length());
        
        // Character at specific index
        System.out.println("Character at index 0: " + name.charAt(0));
        
        // Substring
        // 0 is start index (inclusive) and 4 is end index (exclusive - stops before index 4)
        System.out.println("Substring (0-4): " + name.substring(0, 4));
        
        // Index of character/substring
        System.out.println("Index of 'P': " + name.indexOf('P'));
        System.out.println("Index of 'gram': " + name.indexOf("gram"));
        
        // String comparison
        String str1 = "Hello";
        String str2 = "Hello";
        System.out.println("\nstr1 equals str2: " + str1.equals(str2));
        
        // Case conversion
        System.out.println("Uppercase: " + name.toUpperCase());
        System.out.println("Lowercase: " + name.toLowerCase());
    }
}
