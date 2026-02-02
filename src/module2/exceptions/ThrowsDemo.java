package module2.exceptions;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

// throws - declares that method might throw exception (caller must handle)
public class ThrowsDemo {
    
    // Method declares it might throw IOException
    public static void readFile(String filename) throws IOException {
        FileReader reader = new FileReader(filename);
        System.out.println("File opened successfully");
        reader.close();
    }
    
    public static void main(String[] args) {
        // Must handle exception declared by throws
        try {
            readFile("test.txt");
        } catch (IOException e) {
            System.out.println("File error: " + e.getMessage());
        }
    }
}
