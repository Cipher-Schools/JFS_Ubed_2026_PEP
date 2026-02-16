package module1.operators;

// Assignment operators: =, +=, -=, *=, /=, %=
public class AssignmentOperators {
    public static void main(String[] args) {
        int num = 10;
        
        System.out.println("Initial num: " + num);
        
        num += 5; // num = num + 5
        System.out.println("After num += 5: " + num);
        
        num -= 3; // num = num - 3
        System.out.println("After num -= 3: " + num);
        
        num *= 2; // num = num * 2
        System.out.println("After num *= 2: " + num);
        
        num /= 4; // num = num / 4
        System.out.println("After num /= 4: " + num);
        
        num %= 3; // num = num % 3
        System.out.println("After num %= 3: " + num);
    }
}
