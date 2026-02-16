package module1.methods.questions;

public class QSMathMethods {
    public static void main(String[] args) {
        System.out.println("Max of 10, 5, 8: " + findMax(10, 5, 8));
        System.out.println("Factorial of 5: " + factorial(5));
        
        System.out.print("Fibonacci series (5 terms): ");
        printFibonacci(5);
    }

    public static int findMax(int a, int b, int c) {
        if (a >= b && a >= c) return a;
        else if (b >= a && b >= c) return b;
        else return c;
    }

    public static long factorial(int n) {
        long fact = 1;
        for (int i = 1; i <= n; i++) {
            fact *= i;
        }
        return fact;
    }

    public static void printFibonacci(int n) {
        int a = 0, b = 1;
        for (int i = 0; i < n; i++) {
            System.out.print(a + " ");
            int next = a + b;
            a = b;
            b = next;
        }
        System.out.println();
    }
}
