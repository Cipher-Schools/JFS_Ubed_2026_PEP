package module2.comparator.advanced;

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

public class ComparatorAdvanced {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Alice", 85));
        students.add(new Student("Bob", 92));
        students.add(new Student("Charlie", 78));
        students.add(new Student("Alice", 90));  // Duplicate name, different marks
        
        System.out.println("Original: " + students);
        
        // 1. Sort using anonymous class
        Collections.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                return s1.marks - s2.marks; // Ascending marks
            }
        });
        System.out.println("Sorted by Marks Ascending (Anonymous): " + students);
        
        // 2. Sort using Lambda
        students.sort((s1, s2) -> s1.name.compareTo(s2.name)); // Ascending name
        System.out.println("Sorted by Name Ascending (Lambda): " + students);
        
        // 3. Sort using Comparator.comparing (Modern)
        students.sort(Comparator.comparingInt(s -> s.marks));
        System.out.println("Sorted by Marks Ascending (Method Ref): " + students);
        
        System.out.println("\n--- Advanced Examples ---");
        
        // 4. EXERCISE SOLUTION: Sort by marks DESCENDING
        students.sort((s1, s2) -> s2.marks - s1.marks);
        System.out.println("Marks Descending: " + students);
        
        // Alternative using reversed()
        students.sort(Comparator.comparingInt((Student s) -> s.marks).reversed());
        System.out.println("Marks Descending (reversed): " + students);
        
        // 5. EXERCISE SOLUTION: Sort by name length
        students.sort(Comparator.comparingInt(s -> s.name.length()));
        System.out.println("Name Length Ascending: " + students);
        
        // 6. COMPARATOR CHAINING: Sort by marks, then by name (for ties)
        students.sort(Comparator.comparingInt((Student s) -> s.marks)
                               .thenComparing(s -> s.name));
        System.out.println("Marks then Name: " + students);
        
        // 7. NULL-SAFE COMPARISON
        List<Student> studentsWithNull = new ArrayList<>();
        studentsWithNull.add(new Student("John", 85));
        studentsWithNull.add(null);
        studentsWithNull.add(new Student("Jane", 90));
        
        System.out.println("\nWith nulls: " + studentsWithNull);
        
        // nullsLast: null values go to the end
        studentsWithNull.sort(Comparator.nullsLast(
            Comparator.comparingInt(s -> s.marks)
        ));
        System.out.println("Nulls Last: " + studentsWithNull);
        
        // nullsFirst: null values go to the beginning
        studentsWithNull.sort(Comparator.nullsFirst(
            Comparator.comparingInt(s -> s.marks)
        ));
        System.out.println("Nulls First: " + studentsWithNull);
    }
}
