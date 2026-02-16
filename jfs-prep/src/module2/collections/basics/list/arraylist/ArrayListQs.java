package module2.collections.basics.list.arraylist;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ArrayListQs {
    public static List<Integer> findSingleValue(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();

        //loop to update count in hashmap
        for(int num: nums) {
            if(map.containsKey(num)) {
                map.put(num, map.get(num)+1);
            } else map.put(num, 1);
        }

        //try with string -> aabbsscccdbdsbdadsfsadf

        ArrayList<Integer> list = new ArrayList<>();

        for(int label: map.keySet()) { //keyset -> would return arr of keys in map
            if(map.get(label) == 1) {
                list.add(label);
            }
        }

        //return empty array in case of no single values
        return list;
    }
    public static void main(String[] args) {
        int[] arr = {1, 9, 2, 2, 3, 3, 3, 4, 4, 4};        //1
        List<Integer> result = findSingleValue(arr);
        System.out.println(result);
    }
}
