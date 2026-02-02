package module1.generics;

import java.sql.ClientInfoStatus;
import java.util.ArrayList;
import java.util.List;

// bound -> creates kind of limitation on Types that can be passed
// extends -> upper bound -> will only accept numbers and its subclass - wont work for add values
// super -> lower bound -> anything above it will work -> can read but not write
class Print<T extends Number> {
    T value;

    Print(T value) {
        this.value = value;
    }

    //Data structure
    List<? extends Number> list = new ArrayList<>();
//
//    void addValue() {
//        list.add(10);
//    }

    void printValue() {
        System.out.println("value " + value);
    }

    T returnValue() {
        return value;
    }
}

public class Generic {
    public static void main(String[] args) {
        Print<Integer> forNum = new Print<>(24);
        //super
        List<? super Integer> myList = new ArrayList<>();

        forNum.printValue();

        System.out.println(forNum.returnValue());
    }
}
