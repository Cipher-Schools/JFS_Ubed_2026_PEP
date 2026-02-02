package module1.loops.questions;

import java.util.Scanner;

public class QSNumberOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = scanner.nextInt();
        int originalNum = num;

        // Count digits
        int count = 0;
        int sum = 0;
        int reversed = 0;

        while (num != 0) {
            int digit = num % 10;
            sum += digit;
            reversed = reversed * 10 + digit;
            num /= 10;
            count++;
        }

        System.out.println("Number: " + originalNum);
        System.out.println("Count of digits: " + count);
        System.out.println("Sum of digits: " + sum);
        System.out.println("Reversed number: " + reversed);
        
        scanner.close();
    }
}
