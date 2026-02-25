package org.example.socialmediabe.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.socialmediabe.dto.UserResponse;
import org.example.socialmediabe.model.User;
import org.example.socialmediabe.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    //username
    @GetMapping("/{username}")
    public ResponseEntity<UserResponse> getUserByUsername(@PathVariable String username){ // @PathVariable extracts username from URL path
        User fetchedUser = userService.getUserByUsername(username);
        if(fetchedUser == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(new UserResponse(fetchedUser));
    }

    //now we will use AuthController - register route
//    @PostMapping
//    public ResponseEntity<User> createUser(@Valid @RequestBody User user){ // @Valid triggers validation; @RequestBody converts JSON to User object
//        User createdUser = userService.createUser(user);
//        if(createdUser == null) return ResponseEntity.status( HttpStatus.BAD_REQUEST).build();
////        return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
//        return new ResponseEntity<>(createdUser, HttpStatus.CREATED); // ResponseEntity wraps response with HTTP status code
//    };
}

//API Response

// this api with post
/*
{ email: "yourEmail",
fullName: "yourFullName,
password: your password,
username: yourUsername
* */