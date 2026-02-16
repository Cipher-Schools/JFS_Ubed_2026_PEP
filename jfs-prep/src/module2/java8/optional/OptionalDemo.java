package module2.java8.optional;

import java.util.Optional;

// Optional - container to avoid null pointer exceptions
public class OptionalDemo {
    public static void main(String[] args) {
        // Creating Optional
        Optional<String> name = Optional.of("John");
        Optional<String> empty = Optional.empty();
        Optional<String> nullable = Optional.ofNullable(null);
        
        // 1. isPresent() / ifPresent() - Check existence
        if (name.isPresent()) {
            System.out.println("Name exists: " + name.get());
        }
        name.ifPresent(n -> System.out.println("Hello " + n));
        
        // 2. orElse() - Default value if empty
        String val = nullable.orElse("Default Value");
        System.out.println("Nullable value: " + val); 
        
        // 3. map() - Transform if present
        Optional<Integer> length = name.map(String::length);
        System.out.println("Length: " + length.orElse(0));
        
        // Try This:
        // 1. Use orElseThrow() -> throw an exception if value is missing.
        // 2. Use filter() on Optional -> keeping value only if it matches condition.
    }
}
