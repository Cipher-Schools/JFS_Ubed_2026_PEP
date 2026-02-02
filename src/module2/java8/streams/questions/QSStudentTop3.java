package module2.java8.streams.questions;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

class Student {
    String name;
    int marks;

    public Student(String name, int marks) {
        this.name = name;
        this.marks = marks;
    }

    public int getMarks() {
        return marks;
    }

    public String getName() {
        return name;
    }
}

public class QSStudentTop3 {
    public static void main(String[] args) {
        // Given a list of Student, get names of top 3 by marks.
        
        List<Student> students = Arrays.asList(
            new Student("Alice", 85),
            new Student("Bob", 92),
            new Student("Charlie", 78),
            new Student("David", 95),
            new Student("Edward", 88),
            new Student("Frank", 90)
        );

        System.out.println("All Students:");
        students.forEach(s -> System.out.println(s.name + ": " + s.marks));

        // Get top 3 names
        List<String> top3Names = students.stream()
            .sorted(Comparator.comparingInt(Student::getMarks).reversed()) // Sort by marks desc
            .limit(3)                                                      // Take top 3
            .map(Student::getName)                                         // Extract names
            .collect(Collectors.toList());                                 // Collect to list

        System.out.println("\nTop 3 Students: " + top3Names);
    }
}
