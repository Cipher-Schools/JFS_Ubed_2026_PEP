# Logger Utility System

Practical project demonstrating file persistence, cross-platform file handling, and logging patterns.

## Project Structure

**Utilities** (`utils/`):

- **DateTimeUtil**: Date and time formatting for timestamps
- **FileWriterUtil**: Cross-platform file writing (Windows, Mac, Linux), auto-creates data folders, thread-safe operations, dynamic filenames
- **LoggerClass**: Multi-level logging (ERROR, WARNING, INFO, DEBUG), ERROR logs automatically saved to files, console output for all levels, custom filename support

**Demo** (`demo/`):

- **LoggerDemo**: Comprehensive demonstration of logging features, shows basic logging, custom filenames, append behavior
- **PathDemo**: Cross-platform path compatibility demonstration

## Key Concepts Demonstrated

- **Cross-platform compatibility**: Handles OS-specific file path separators
- **Utility class pattern**: Reusable logging components separated from business logic
- **File I/O**: Writing to files with proper resource management
- **Thread-safe operations**: Synchronized file writing for concurrent access
- **Auto-resource creation**: Automatic data folder creation
- **Log levels**: Different severity levels for better log organization
- **Custom configuration**: Dynamic filename support for organized logging

## Features

- Clean separation between utilities and demos
- Works across Windows, Mac, and Linux
- Dynamic, non-hardcoded file paths
- Thread-safe synchronized file writing
- Automatic folder creation
- Automatic log file appending to preserve history
