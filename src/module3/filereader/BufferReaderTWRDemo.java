package module3.filereader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BufferReaderTWRDemo {
    public static void main(String[] args) {
        // Try-with-resources statement ensures that each resource is closed at the end of the statement.
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("data/demo.txt"))) {
            String line;
            while ((line = bufferedReader.readLine())!=null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
