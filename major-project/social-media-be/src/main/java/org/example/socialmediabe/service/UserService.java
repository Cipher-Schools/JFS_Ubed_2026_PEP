package org.example.socialmediabe.service;

import jakarta.validation.Valid;
import jakarta.validation.ValidationException;
import lombok.RequiredArgsConstructor;
import org.example.socialmediabe.model.User;
import org.example.socialmediabe.repository.UserRepo;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;




@Service
@RequiredArgsConstructor //creates constructor with final methods as param only
public class UserService {
    private final UserRepo userRepo;

// boilerplate can be skipped
//    public UserService(UserRepo userRepo) {
//        this.userRepo = userRepo;
//    }

    public User getUserByUsername(String username){
        return userRepo.findByUsername(username);
    };

    public User createUser(User user){
        //if email already in use -> return use some other email
        //if username already in use -> return use some other username
        if(user.getEmail() == null || user.getEmail().isEmpty()) {
            throw new ValidationException("Email cannot be null or empty");
        }
        if(user.getUsername() == null || user.getUsername().isEmpty()) {
            throw new ValidationException("Username cannot be null or empty");
        }
        if(userRepo.findByEmail(user.getEmail()) != null) { //not null -> means email already exists
            throw new ValidationException("Email already exists");
        }
        if(userRepo.findByUsername(user.getUsername()) != null) { //not null -> means username already exists
            throw new ValidationException("Username already exists");
        }
        return userRepo.save(user);
        //Insert sql with data
    };
}
