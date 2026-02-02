package module1.oop.basics.questions;

class Student {
    int rollNumber;
    String name;
    double marks;

    Student(int rollNumber, String name, double marks) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.marks = marks;
    }

    char calculateGrade() {
        if (marks >= 90) return 'A';
        else if (marks >= 75) return 'B';
        else if (marks >= 50) return 'C';
        else return 'F';
    }

    void displayInfo() {
        System.out.println("Roll: " + rollNumber + ", Name: " + name + ", Marks: " + marks + ", Grade: " + calculateGrade());
    }
}

public class QSStudentGrade {
    public static void main(String[] args) {
        Student s1 = new Student(101, "Alice", 92.5);
        Student s2 = new Student(102, "Bob", 65.0);
        
        s1.displayInfo();
        s2.displayInfo();
    }
}
