package org.example.socialmediabe.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users") //giving our custom name else db will use user
public class User {

    @Id
    //telling database autoincrement id - postgresql -> serial
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    @NotBlank(message = "Username cannot be blank") // Ensures field is not empty or whitespace
    @Size(min = 3, max = 20, message = "Username must be between 3 and 20 characters") // Validates length constraints
    @Pattern(regexp = "^[a-zA-Z0-9_.-]+$", message = "Username can only contain letters, numbers, dots, hyphens, and underscores") // Regex pattern validation
    private String username;

    @Column(nullable = false, unique = true)
    @NotBlank(message = "this cannot be null")
    @Email(message = "Enter valid email") // Validates email format (RFC 5322)
    private String email;

    @Column(nullable = false)
    @NotBlank(message = "Full name cannot be blank")
    @Size(min = 2, max = 100, message = "Full name must be between 2 and 100 characters")
    private String fullName;

    @Column(nullable = false)
    @NotBlank(message = "Password cannot be blank")
    @Size(min = 8, message = "Password must be at least 8 characters long")
    @JsonIgnore // Never serialize password in any API response — even if hashed
    private String password;

//    CREATE TABLE users (
//            id SERIAL PRIMARY KEY,
//            email VARCHAR(255) NOT NULL UNIQUE,
//    username VARCHAR(100) NOT NULL UNIQUE
//);
//this is getter function that we wont need as we are using Getter and Setter Annotation
//    public Integer getUserId() {
//        return id;
//    }
}
