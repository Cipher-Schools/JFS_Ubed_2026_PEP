package project.demo;

import project.utils.LoggerClass;
import java.io.File;

/**
 * DEMONSTRATION: Cross-Platform Path Verification
 * 
 * This demo shows that the FileWriterUtil now uses cross-platform paths
 * that work on Windows, Mac, and Linux
 */
public class PathDemo {
    
    public static void main(String[] args) {
        System.out.println("=== Cross-Platform Path Demo ===\n");
        
        // Display current OS information
        String os = System.getProperty("os.name");
        String userDir = System.getProperty("user.dir");
        String separator = File.separator;
        
        System.out.println("Operating System: " + os);
        System.out.println("Current Directory: " + userDir);
        System.out.println("Path Separator: " + separator);
        System.out.println();
        
        // Show the data folder path that will be used
        String dataFolderPath = userDir + File.separator + "data";
        System.out.println("Data Folder Path: " + dataFolderPath);
        System.out.println();
        
        // Demonstrate how it looks on different systems
        System.out.println("--- How paths look on different systems ---");
        System.out.println("Windows example: C:\\Users\\username\\project\\data");
        System.out.println("Mac/Linux example: /Users/username/project/data");
        System.out.println("Your system: " + dataFolderPath);
        System.out.println();
        
        // Test a log write
        System.out.println("--- Testing FileWriterUtil ---");
        try {
            LoggerClass.error("Cross-platform test message", "platform_test.log");
            System.out.println("✓ Successfully wrote to: " + dataFolderPath + separator + "platform_test.log");
        } catch (Exception e) {
            System.err.println("✗ Failed to write log: " + e.getMessage());
        }
        
        System.out.println("\n=== Path Demo Complete ===");
    }
}
