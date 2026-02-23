package org.example.socialmediabe.service;

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

    public User getUserByEmail(String email){
        return userRepo.findByEmail(email);
    };

    public User createUser(User user){
        return userRepo.save(user);
        //Insert sql with data
    };
}
