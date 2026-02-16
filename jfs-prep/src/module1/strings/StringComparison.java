package module1.strings;

// String vs StringBuilder vs StringBuffer
public class StringComparison {
    public static void main(String[] args) {
        // String - immutable (cannot be changed)
        String str = "Hello";
        str = str + " World"; // creates new String object
        System.out.println("String: " + str);
        
        // StringBuilder - mutable, not thread-safe, faster
        StringBuilder sb = new StringBuilder("Hello");
        sb.append(" World"); // modifies same object
        System.out.println("StringBuilder: " + sb.toString());
        
        // StringBuffer - mutable, thread-safe, slower than StringBuilder
        StringBuffer sbf = new StringBuffer("Hello");
        sbf.append(" World");
        System.out.println("StringBuffer: " + sbf.toString());
        
        // StringBuilder methods demo
        StringBuilder demo = new StringBuilder("Java");
        demo.append(" Programming");
        demo.insert(5, "Cool ");
        demo.delete(0, 5);
        demo.reverse();
        System.out.println("\nAfter operations: " + demo);
    }
}
