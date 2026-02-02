package module1.generics;

public class GenericMethodDemo {
    
    // Generic method - <T> before return type declares type parameter
    public static <T> void printArray(T[] array) {
        for (T element : array) {
            System.out.print(element + " ");
        }
        System.out.println();
    }
    
    // Generic method with return type
    public static <T> T getFirst(T[] array) {
        return array.length > 0 ? array[0] : null;
    }
    
    public static void main(String[] args) {
        // Works with Integer array
        Integer[] intArray = {1, 2, 3, 4, 5};
        System.out.print("Integer array: ");
        printArray(intArray);
        
        // Works with String array - same method, different type
        String[] strArray = {"Java", "Python", "C++"};
        System.out.print("String array: ");
        printArray(strArray);
        
        // Using generic method with return type
        System.out.println("First integer: " + getFirst(intArray));
        System.out.println("First string: " + getFirst(strArray));
    }
}
