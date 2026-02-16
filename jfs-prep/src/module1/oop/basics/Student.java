package module1.oop.basics;

// Class and Object basics - creating a simple class
public class Student {
    // Fields (instance variables)
    String name;
    int age;
    String grade;
    
    // Constructor - special method to initialize objects
    public Student(String name, int age, String grade) {
        this.name = name;
        this.age = age;
        this.grade = grade;
    }
    
    // Method to display student information
    public void displayInfo() {
        System.out.println("Name: " + name + ", Age: " + age + ", Grade: " + grade);
    }
    
    public static void main(String[] args) {
        // Creating objects
        Student student1 = new Student("Alice", 15, "A");
        Student student2 = new Student("Bob", 16, "B");
        
        student1.displayInfo();
        student2.displayInfo();
    }
}
