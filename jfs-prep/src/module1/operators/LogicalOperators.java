package module1.operators;

// Logical operators: && (AND), || (OR), ! (NOT)
public class LogicalOperators {
    public static void main(String[] args) {
        boolean isAdult = true;
        boolean hasLicense = true;
        boolean isTired = false;
        
        // AND operator - both must be true
        System.out.println("Can drive: " + (isAdult && hasLicense));
        
        // OR operator - at least one must be true
        System.out.println("Should rest: " + (isTired || !isAdult));
        
        // NOT operator - reverses boolean value
        System.out.println("Not tired: " + (!isTired));
        System.out.println("Can't drive: " + !(isAdult && hasLicense));
    }
}
