package org.example.restapidemo.service;

import org.example.restapidemo.dto.StudentDTO;
import org.example.restapidemo.repository.StudentRepo;
import org.springframework.stereotype.Service;

import java.util.List;

// @Service indicates that this class holds the business logic.
// It acts as a middleman between the Controller (API layer) and the Repository (Data layer).
@Service
public class StudentService {

    private final StudentRepo studentRepo;

    // Constructor Injection: optimal for required dependencies.
    // Spring automatically provides the StudentRepo instance here.
    public StudentService(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

    public List<StudentDTO> getAllStudents() {
        // Business logic could be added here (e.g., filtering, sorting) before calling repo
        return studentRepo.getAll();
    }

    public StudentDTO getByRollNo(Integer rollNo) {
        return studentRepo.getById(rollNo);
    }

    public String addStudent(StudentDTO student) {
        // Validation logic can go here
        if (studentRepo.exists(student.getRollNo())) {
            return "Student with Roll No " + student.getRollNo() + " already exists!";
        }
        studentRepo.save(student);
        return "Student " + student.getName() + " added successfully";
    }

    public String updateStudent(Integer rollNo, StudentDTO student) {
        if (!studentRepo.exists(rollNo)) {
            return "Student with Roll No " + rollNo + " not found";
        }
        studentRepo.save(student);
        return "Student with Roll No " + rollNo + " updated successfully";
    }

    public String deleteStudent(Integer rollNo) {
        if (!studentRepo.exists(rollNo)) {
            return "Student with Roll No " + rollNo + " not found";
        }
        studentRepo.delete(rollNo);
        return "Student deleted successfully";
    }
}