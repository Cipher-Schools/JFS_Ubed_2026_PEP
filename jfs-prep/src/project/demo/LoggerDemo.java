package project.demo;

import project.utils.LoggerClass;

/**
 * DEMONSTRATION: LoggerClass with FileWriterUtil Integration
 * 
 * This demo shows how LoggerClass uses FileWriterUtil to write logs to local files
 * in the data folder with dynamic filename support.
 * 
 * Key Learning Points:
 * 1. LoggerClass provides convenient logging methods for different levels
 * 2. ERROR logs are automatically saved to files (default: error.log)
 * 3. Custom filenames can be specified for flexible log organization
 * 4. FileWriterUtil creates the data folder automatically if it doesn't exist
 * 5. All logs are appended to files (preserving history)
 */
public class LoggerDemo {
    
    public static void main(String[] args) {
        System.out.println("=== Logger and FileWriter Demo ===\n");
        
        // Demo 1: Basic logging with different levels
        System.out.println("--- Demo 1: Basic Logging ---");
        LoggerClass.info("Application started successfully");
        LoggerClass.debug("Debug mode enabled");
        LoggerClass.warning("Low disk space detected");
        
        // Demo 2: Error logging with default filename (error.log)
        System.out.println("\n--- Demo 2: Error Logging (Default File) ---");
        LoggerClass.error("Database connection failed");
        LoggerClass.error("Failed to load configuration file");
        System.out.println("✓ Errors written to: data/error.log");
        
        // Demo 3: Error logging with custom filenames (DYNAMIC!)
        System.out.println("\n--- Demo 3: Error Logging (Custom Files) ---");
        LoggerClass.error("User authentication failed for user: john_doe", "auth_errors.log");
        LoggerClass.error("Payment processing failed: Invalid card", "payment_errors.log");
        LoggerClass.error("Session expired for user: jane_smith", "auth_errors.log");
        System.out.println("✓ Authentication errors written to: data/auth_errors.log");
        System.out.println("✓ Payment errors written to: data/payment_errors.log");
        
        // Demo 4: Multiple calls to demonstrate append behavior
        System.out.println("\n--- Demo 4: Multiple Calls (Append Behavior) ---");
        for (int i = 1; i <= 3; i++) {
            LoggerClass.error("Error #" + i + " occurred in loop iteration", "loop_errors.log");
        }
        System.out.println("✓ All loop errors appended to: data/loop_errors.log");
        
        // Demo 5: Mixed logging scenario (real-world example)
        System.out.println("\n--- Demo 5: Real-World Scenario ---");
        simulateApplicationFlow();
        
        System.out.println("\n=== Demo Complete ===");
        System.out.println("Check the 'data' folder for generated log files:");
        System.out.println("  - data/error.log");
        System.out.println("  - data/auth_errors.log");
        System.out.println("  - data/payment_errors.log");
        System.out.println("  - data/loop_errors.log");
        System.out.println("  - data/application_errors.log");
    }
    
    /**
     * Simulates a typical application flow with various log levels and file logging
     */
    private static void simulateApplicationFlow() {
        LoggerClass.info("Processing user request...");
        
        // Simulate some operations
        LoggerClass.debug("Validating user input");
        LoggerClass.info("User input validated successfully");
        
        LoggerClass.debug("Connecting to database");
        LoggerClass.warning("Database query took longer than expected (3.5s)");
        
        // Simulate an error
        LoggerClass.error("Failed to update user profile: Constraint violation", "application_errors.log");
        
        LoggerClass.info("Request processing completed with errors");
    }
}
