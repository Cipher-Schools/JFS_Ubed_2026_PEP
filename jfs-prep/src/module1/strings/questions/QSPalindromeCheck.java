package module1.strings.questions;

import java.util.Scanner;

public class QSPalindromeCheck {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String text = scanner.nextLine();
        
        if (isPalindrome(text)) {
            System.out.println("\"" + text + "\" is a palindrome.");
        } else {
            System.out.println("\"" + text + "\" is NOT a palindrome.");
        }
        scanner.close();
    }

    public static boolean isPalindrome(String text) {
        // Clean string: remove spaces and convert to lower case
        String clean = text.replaceAll("\\s+", "").toLowerCase();
        
        int left = 0;
        int right = clean.length() - 1;
        
        while (left < right) {
            if (clean.charAt(left) != clean.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
