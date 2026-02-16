# Project Structure

This project demonstrates a logger utility system with file persistence capabilities.

## Directory Structure

```
src/project/
├── utils/                  # Utility classes
│   ├── DateTimeUtil.java   # Date/time formatting utility
│   ├── FileWriterUtil.java # File writing utility (cross-platform)
│   └── LoggerClass.java    # Main logger with multiple log levels
└── demo/                   # Demonstration files
    ├── LoggerDemo.java     # Main logger demonstration
    └── PathDemo.java       # Cross-platform path demonstration
```

## Utility Classes (`src/project/utils/`)

### DateTimeUtil

- Provides date and time formatting
- Used by LoggerClass for timestamps

### FileWriterUtil

- Handles writing log messages to files
- **Cross-platform compatible** (Windows, Mac, Linux)
- Creates `data/` folder automatically
- Thread-safe file writing
- Dynamic filename support

### LoggerClass

- Main logging utility with 4 levels: ERROR, WARNING, INFO, DEBUG
- ERROR logs are automatically saved to files
- Console output for all levels
- Supports custom filenames for organized logging

## Demo Classes (`src/project/demo/`)

### LoggerDemo

- Comprehensive demonstration of logging features
- Shows basic logging, custom filenames, and append behavior
- Creates multiple log files in the `data/` folder

### PathDemo

- Demonstrates cross-platform path compatibility
- Shows OS-specific path information
- Tests file writing on current system

## Usage

### Mac/Linux

#### Compile (from project root)

```bash
javac src/project/utils/*.java src/project/demo/*.java
```

#### Run Logger Demo

```bash
java -cp src project.demo.LoggerDemo
```

#### Run Path Demo

```bash
java -cp src project.demo.PathDemo
```

### Windows PowerShell

#### Compile (from project root)

```powershell
# Navigate to src directory first
cd src

# Compile utilities then demos
javac project\utils\*.java
javac project\demo\*.java

# Or compile all at once
javac project\utils\*.java project\demo\*.java
```

#### Run Logger Demo

```powershell
# From src directory
java project.demo.LoggerDemo
```

#### Run Path Demo

```powershell
# From src directory
java project.demo.PathDemo
```

**Important for Windows**: Always compile from the `src` directory (where package structure starts), NOT from inside `project\demo\` or `project\utils\` folders.

## Using LoggerClass in Your Code

```java
import project.utils.LoggerClass;

public class YourClass {
    public static void main(String[] args) {
        // Basic logging
        LoggerClass.info("Application started");
        LoggerClass.warning("Low memory warning");
        LoggerClass.debug("Debugging information");

        // Error logging with default file (error.log)
        LoggerClass.error("Something went wrong");

        // Error logging with custom file
        LoggerClass.error("Database error", "database_errors.log");
    }
}
```

## Features

✅ **Clean Separation**: Utilities separated from demos  
✅ **Cross-Platform**: Works on Windows, Mac, and Linux  
✅ **Dynamic Filenames**: No hardcoded paths  
✅ **Thread-Safe**: Synchronized file writing  
✅ **Auto-Creation**: Creates data folder automatically  
✅ **Append Mode**: Preserves log history

## Output

Log files are created in the `data/` folder at the project root.
