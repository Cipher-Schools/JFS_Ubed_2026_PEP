package module3.filewriter;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriterDemo {
    public static void main(String[] args) throws IOException {
        //try with resource
        // FileWriter is used for writing streams of characters.
        // The second argument 'true' in the constructor indicates that the file should be appended to, not overwritten.
        try(FileWriter fileWriter = new FileWriter("data/data.txt", true)) {
            fileWriter.write("This is java fullstack class\n");
            fileWriter.write("we are 55 students here\n");
            System.out.println("file written");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
