package project;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * UTILITY CLASS: FileWriterUtil
 * 
 * Purpose: Handles writing log messages to files in a local data folder
 * Features:
 * - Automatic data folder creation if it doesn't exist
 * - Thread-safe file writing using synchronized method
 */
public final class FileWriterUtil {
    
    private static final String DATA_FOLDER = "data";
    
    // Private constructor to prevent instantiation (Utility class pattern)
    private FileWriterUtil() {
        throw new UnsupportedOperationException("FileWriterUtil is a utility class and cannot be instantiated");
    }
    
    /**
     * Writes a log message to a specified file in the data folder
     * 
     * @param filename The name of the file to write to (e.g., "error.log", "application.log")
     * @param message The log message to write
     * @throws IOException if an I/O error occurs during file writing
     */
    public static synchronized void writeToFile(String filename, String message) throws IOException {
        // nsure data folder exists
        File dataFolder = new File(DATA_FOLDER);
        if (!dataFolder.exists()) {
            boolean created = dataFolder.mkdirs();
            if (!created) {
                throw new IOException("Failed to create data folder: " + DATA_FOLDER);
            }
        }
        
        // Create full file path
        File logFile = new File(dataFolder, filename);
        
        // Write to file using try-with-resources (auto-closes resources)
        // FileWriter with 'true' parameter enables append mode
        // BufferedWriter provides efficient writing with buffering
        try (FileWriter fw = new FileWriter(logFile, true);
             BufferedWriter bw = new BufferedWriter(fw)) {
            
            // Write the message and add a newline
            bw.write(message);
            bw.newLine();
        }
        // Note: No need for explicit close() or flush() - try-with-resources handles it
    }
}
