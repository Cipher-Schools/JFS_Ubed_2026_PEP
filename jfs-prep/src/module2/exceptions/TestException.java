package module2.exceptions;

import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;

//unchecked
class UnderAgeExceptionAgain extends RuntimeException {

}

//checked
class UnderAgeException extends Exception {
    UnderAgeException(String msg) {
        super(msg);
    }
}

class Operations {
    static int a = 10;
    static int b = 0;

    //throw
    //Arithmetic Exception is Runtime Exception -> compile wont bother
    //unchecked
    static void printSomething() {
        if(b == 0) throw new ArithmeticException("can divide");
    }

    //checked
    static void readFile() throws IOException {
        FileReader readfs = new FileReader("abc.txt");
    }

}

public class TestException {
    public static void main(String[] args) {
        try {
           Operations.readFile();
        } catch (IOException e) {
            System.out.println("failed reading file " + e.getMessage());
        }

//        Operations.printSomething();

        try {
            Operations.printSomething();
        } catch (ArithmeticException e) {
            System.err.println("maths failed " + e.getMessage());
            System.err.println("[INFO] " + LocalDateTime.now() + e.getMessage());
            //for errrors - will log in read
        }

    }
}
