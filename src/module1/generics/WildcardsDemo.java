package module1.generics;

import java.util.ArrayList;
import java.util.List;

public class WildcardsDemo {
    
    // Unbounded wildcard - accepts list of any type
    public static void printList(List<?> list) {
        for (Object obj : list) {
            System.out.print(obj + " ");
        }
        System.out.println();
    }
    
    // Upper bounded wildcard - accepts Number or its subclasses only
    public static double sumNumbers(List<? extends Number> list) {
        double sum = 0;
        for (Number num : list) {
            sum += num.doubleValue();
        }
        return sum;
    }
    
    public static void main(String[] args) {
        List<Integer> intList = new ArrayList<>();
        intList.add(1);
        intList.add(2);
        intList.add(3);
        
        List<String> strList = new ArrayList<>();
        strList.add("Java");
        strList.add("Generics");
        
        // Unbounded wildcard works with any type
        System.out.print("Integer list: ");
        printList(intList);
        System.out.print("String list: ");
        printList(strList);
        
        // Upper bounded works only with Number subclasses
        System.out.println("Sum: " + sumNumbers(intList));
    }
}
