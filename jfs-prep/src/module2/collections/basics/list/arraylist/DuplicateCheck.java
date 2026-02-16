package module2.collections.basics.list.arraylist;

import java.util.HashMap;

public class DuplicateCheck {
    public static boolean isDuplicate(int[] currency) {
        HashMap<Integer, Integer> locker = new HashMap<>();
        for(int curr: currency) {
            if(locker.containsKey(curr)) return true;
            locker.put(curr, 1);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] currency = {10, 20, 50, 10};

        boolean hasDuplicate = isDuplicate(currency);
        System.out.println("Has duplicate: " + hasDuplicate);
    }
}
