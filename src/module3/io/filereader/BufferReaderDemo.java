package module3.io.filereader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class BufferReaderDemo {
    public static void main(String[] args) throws FileNotFoundException {
        FileReader fileReaderOne = new FileReader("data/demo.txt");
        // BufferedReader improves reading performance by buffering the input.
        BufferedReader bufferedReader = new BufferedReader(fileReaderOne);

        try {
            String line;
            // Returns null if the end of the stream has been reached.
            while ((line = bufferedReader.readLine())!=null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
