package org.example.socialmediabe.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
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

    @GetMapping("/{email}")
    public ResponseEntity<User> getUserByEmail(@PathVariable String email){ // @PathVariable extracts email from URL path
        User fetchedUser = userService.getUserByEmail(email);
        if(fetchedUser == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(fetchedUser);
    };

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