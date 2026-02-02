package module3.filereader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class BufferReaderDemo {
    public static void main(String[] args) throws FileNotFoundException {
        FileReader fileReaderOne = new FileReader("data/demo.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReaderOne);

        try {
            String line;
            while ((line = bufferedReader.readLine())!=null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println(e.getStackTrace());
        } finally {
            try {
                bufferedReader.close();
            } catch (IOException e) {
                System.out.println(e.getStackTrace());
            }
        }
    }
}
