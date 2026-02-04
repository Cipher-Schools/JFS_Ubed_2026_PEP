package module2.collections.basics.list;

import java.util.LinkedList;

// LinkedList - doubly linked list, fast insertion/deletion
public class LinkedListDemo {
    public static void main(String[] args) {
        LinkedList<Integer> numbers = new LinkedList<>();
        
        // Adding at different positions - fast O(1) at ends
        numbers.add(10);
        numbers.add(20);
        numbers.addFirst(5);  // add at beginning
        numbers.addLast(30);  // add at end
        
        System.out.println("Numbers: " + numbers);
        
        // Queue operations
        numbers.offer(40); // add at end
        System.out.println("First element: " + numbers.peek()); // view first
        System.out.println("Removed: " + numbers.poll()); // remove first
        
        System.out.println("After poll: " + numbers);
        
        // Stack operations
        numbers.push(100); // add at beginning
        System.out.println("After push: " + numbers);
        System.out.println("Popped: " + numbers.pop()); // remove first
    }
}
