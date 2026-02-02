package module2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

class Student {
    String name;
    int marks;

    Student(String name, int marks) {
        this.name = name;
        this.marks = marks;
    }

    public String getName() {
        return name;
    }

    public int getMarks() {
        return marks;
    }
}

public class QSStreamQuestion {
    public static void main(String[] args) {
        Student st1 = new Student("Suraj" , 99);
        List<Student> listOfStudents = List.of(st1,
                new Student("sampad" , 85),
                new Student("mansi", 95),
                new Student("aman", 89),
                new Student("Khushi", 78));

        //sort based on student marks using streams-> top 3
//        .limit(3)
        List<String> topStudents = listOfStudents.stream()
                        .sorted(Comparator.comparingInt(Student::getMarks).reversed())
                .limit(3)
                .map(Student::getName)
                                .collect(Collectors.toList());
//        System.out.println(listOfStudents);
        System.out.println(topStudents);
    }
}
