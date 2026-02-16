package module3.io.objectstream;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

//Deserialization -> reading object
// Reading the object from a file
// public final Object readObject() throws IOException, ClassNotFoundException
public class ObjectReadDemo {
    public static void main(String[] args) throws IOException {
        try (ObjectInputStream inputStream = new ObjectInputStream(
                new FileInputStream("data/student.ser"));) {
            Student s1 = (Student) inputStream.readObject();
            System.out.println(s1.id + "  " + s1.name);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
