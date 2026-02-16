package module2.java8.streams;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

class Product {
    String name;
    double price;
    
    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }
    
    @Override
    public String toString() {
        return name + ":$" + price;
    }
}

public class StreamOperations {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();
        products.add(new Product("Laptop", 899.99));
        products.add(new Product("Mouse", 29.99));
        products.add(new Product("Keyboard", 79.99));
        products.add(new Product("Monitor", 299.99));
        
        // sorted - sorts stream elements
        System.out.println("Sorted by price:");
        products.stream()
               .sorted(Comparator.comparingDouble(p -> p.price))
               .forEach(System.out::println); // method reference
        
        // filter + map + collect - chain operations
        List<String> expensiveNames = products.stream()
                                              .filter(p -> p.price > 100)
                                              .map(p -> p.name)
                                              .collect(Collectors.toList());
        System.out.println("\nExpensive products: " + expensiveNames);
    }
}
