package module3.filereader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderDemo {
	public static void main(String[] args) throws FileNotFoundException {
		// FileReader is used for reading streams of characters.
		// For reading streams of raw bytes, consider using FileInputStream.
		FileReader reader = new FileReader("data/demo.txt");
		int character;

		try {
			// read() returns the character read, or -1 if the end of the stream has been reached
			while((character = reader.read()) != -1) {
				System.out.print((char) character);
			}
		} catch (IOException e) {
			System.out.println(e.getStackTrace());
		} finally {
			// Always close the resource to prevent memory leaks
			try {
				reader.close();
			} catch (IOException e) {
				System.out.println(e.getStackTrace());
			}
		}
	}
}
