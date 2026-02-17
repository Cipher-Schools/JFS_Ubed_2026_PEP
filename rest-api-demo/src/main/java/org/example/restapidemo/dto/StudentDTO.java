package org.example.restapidemo.dto;

// this is data transfer object (DTO)
public class StudentDTO {
    // It is used to transfer data between different layers of the application (e.g., Controller <-> Service)
    private Integer rollNo;
    private String name;

// default constructor is needed by JPA to create objects
    public StudentDTO() {
    }

    public StudentDTO(Integer rollNo, String name) {
        this.rollNo = rollNo;
        this.name = name;
    }

    // Getters and Setters provide controlled access to private fields (Encapsulation)
    public Integer getRollNo() {
        return rollNo;
    }

    public void setRollNo(Integer rollNo) {
        this.rollNo = rollNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
