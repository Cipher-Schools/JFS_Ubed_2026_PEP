package org.example.restapidemo.controller;

import org.example.restapidemo.dto.StudentDTO;
import org.example.restapidemo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// @RestController marks this class as a controller where every method returns a domain object instead of a view.
@RestController
@RequestMapping("/api") // Base URL path for all methods in this controller (e.g., http://localhost:8080/api)
public class StudentController {

    // Dependency Injection via field injection (Autowired)
    // Constructor injection is preferred
    @Autowired
    StudentService studentService;

    //constructor Injection (DI) example
    // public StudentController(StudentService studentService) {
    //     this.studentService = studentService;
    // }

    // GET request to fetch all students
    // URL: GET http://localhost:8080/api
    @GetMapping
    public ResponseEntity<List<StudentDTO>> getAllStudents() {
        List<StudentDTO> students = studentService.getAllStudents();
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    // GET request to fetch a specific student by Roll No
    // URL: GET http://localhost:8080/api/{rollNo}
    // @PathVariable extracts values from the URI path
    @GetMapping("/{rollNo}")
    public ResponseEntity<?> getByRollNo(@PathVariable Integer rollNo) {
        StudentDTO student = studentService.getByRollNo(rollNo);
        if (student == null) {
            return new ResponseEntity<>("Student not found", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    // POST request to add a new student
    // URL: POST http://localhost:8080/api
    // @RequestBody maps the JSON body of the request to the StudentDTO object
    @PostMapping
    public ResponseEntity<String> addStudent(@RequestBody StudentDTO student) {
        String response = studentService.addStudent(student);
        // Returns 201 Created status
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    // PUT request to update an existing student
    // URL: PUT http://localhost:8080/api/{rollNo}
    @PutMapping("/{rollNo}")
    public ResponseEntity<String> updateStudent(@PathVariable Integer rollNo, @RequestBody StudentDTO student) {
        String response = studentService.updateStudent(rollNo, student);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    // DELETE request to remove a student
    // URL: DELETE http://localhost:8080/api/{rollNo}
    @DeleteMapping("/{rollNo}")
    public ResponseEntity<String> deleteStudent(@PathVariable Integer rollNo) {
        String response = studentService.deleteStudent(rollNo);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
