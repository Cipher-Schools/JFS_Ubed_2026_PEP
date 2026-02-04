package module3.io.objectstream;

import java.io.*;
//object serialization - saving object locally
// The Serializable interface is a marker interface; it has no methods.
// Use 'transient' keyword for fields you don't want to save (e.g. passwords).
class Student implements Serializable {
    int id;
    String name;

    Student(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
public class ObjectStreamDemo {
    public static void main(String[] args) throws FileNotFoundException {
        Student s1 = new Student(24, "raj");

        try(ObjectOutputStream outputStream = new ObjectOutputStream(
                new FileOutputStream("data/student.ser"))) {
            outputStream.writeObject(s1);
            System.out.println("object created");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
