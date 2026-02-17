package org.example.restapidemo.repository;

import org.example.restapidemo.dto.StudentDTO;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// @Repository indicates that this class is a Repository (Data Access Layer).
// In a real application, this would interact with a database (like PostgreSQL, MySQL).
// Here, we are simulating a database using an in-memory HashMap.
@Repository
public class StudentRepo {
    // Simulating a database table where Key is RollNo and Value is the Student object
    private Map<Integer, StudentDTO> studentDB = new HashMap<>();

    public StudentRepo() {
        // Adding some dummy data to start with
        studentDB.put(1, new StudentDTO(1, "Sachin"));
        studentDB.put(2, new StudentDTO(2, "Avinash"));
        studentDB.put(3, new StudentDTO(3, "Amann"));   
        studentDB.put(4, new StudentDTO(4, "Vipul")); 
    }

    // Fetch all students (Select * from students)
    public List<StudentDTO> getAll() {
        return new ArrayList<>(studentDB.values());
    }

    // Fetch student by ID (Select * from students where rollNo = ?)
    public StudentDTO getById(Integer rollNo) {
        return studentDB.get(rollNo); // Returns null if not found
    }

    // Save or Update student (Insert into students ... or Update students ...)
    public StudentDTO save(StudentDTO student) {
        studentDB.put(student.getRollNo(), student);
        return student;
    }

    // Check if student exists
    public boolean exists(Integer rollNo) {
        return studentDB.containsKey(rollNo);
    }

    // Delete student (Delete from students where rollNo = ?)
    public StudentDTO delete(Integer rollNo) {
        return studentDB.remove(rollNo);
    }
}
