package module2.comparator.basics;

import java.util.Comparator;

@FunctionalInterface
interface MyComparator {
    int compare(int a, int b);
}

class AscComparator implements MyComparator {
    @Override
    public int compare(int a, int b) { // a = 10, b = 20
        return a-b;  //positive -> descending, negative -> ascending
    }
}

class DescComparator implements MyComparator {
    @Override
    public int compare(int a, int b) { // a = 20, b = 10
        return b-a;  //positive -> descending, negative -> ascending
    }
}

public class ComparatorBasics {
    public static void main(String[] args) {
        AscComparator asc = new AscComparator();
        MyComparator asc1 = (a,  b) -> a-b;

        Comparator<Integer> asc2 = (a, b) -> a - b;
        
        System.out.println(asc.compare(10, 20));   // -10 (10 comes before 20)
        System.out.println(asc1.compare(10, 20));  // -10
        System.out.println(asc2.compare(10, 20));  // -10
    }
}
