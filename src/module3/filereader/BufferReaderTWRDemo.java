package module3.filereader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BufferReaderTWRDemo {
    public static void main(String[] args) {
        //try with resource
        //java will close reader for us
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("data/demo.txt"))) {
            String line;
            while ((line = bufferedReader.readLine())!=null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println(e.getStackTrace());
        }
    }
}
