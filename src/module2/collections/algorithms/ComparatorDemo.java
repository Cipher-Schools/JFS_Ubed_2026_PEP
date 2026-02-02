package module2.collections.algorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Student {
    String name;
    int marks;
    
    public Student(String name, int marks) {
        this.name = name;
        this.marks = marks;
    }
    
    @Override
    public String toString() { return name + ":" + marks; }
}

public class ComparatorDemo {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Alice", 85));
        students.add(new Student("Bob", 92));
        students.add(new Student("Charlie", 78));
        
        System.out.println("Original: " + students);
        
        // 1. Sort using anonymous class
        Collections.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                return s1.marks - s2.marks; // Ascending marks
            }
        });
        System.out.println("Sorted by Marks (Anon): " + students);
        
        // 2. Sort using Lambda
        students.sort((s1, s2) -> s1.name.compareTo(s2.name)); // Ascending name
        System.out.println("Sorted by Name (Lambda): " + students);
        
        // 3. Sort using Comparator.comparing (Modern)
        students.sort(Comparator.comparingInt(s -> s.marks));
        
        // Try This:
        // 1. Sort by marks DESCENDING ((s1, s2) -> s2.marks - s1.marks).
        // 2. Sort by name length.
    }
}
