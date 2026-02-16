package module3.io.filewriter;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedWriterDemo {
    public static void main(String[] args) throws IOException {
        // BufferedWriter writes text to a character-output stream, buffering characters so as to provide for the efficient writing of single characters, arrays, and strings.
        // The buffer size may be specified, or the default size may be accepted.
        try(BufferedWriter bufferedWriter = new BufferedWriter(
                new FileWriter("data/bufferedData.txt", true))) {
            bufferedWriter.write("this is another file created using buffered write\n");
            bufferedWriter.write("another line in buffered writer");
            System.out.println("buffered writer created file");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
