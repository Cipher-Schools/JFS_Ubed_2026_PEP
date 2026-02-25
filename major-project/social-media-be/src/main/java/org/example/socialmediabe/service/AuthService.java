package org.example.socialmediabe.service;

import at.favre.lib.crypto.bcrypt.BCrypt;
import jakarta.validation.ValidationException;
import lombok.RequiredArgsConstructor;
import org.example.socialmediabe.dto.AuthResponse;
import org.example.socialmediabe.dto.LoginRequest;
import org.example.socialmediabe.dto.RegisterRequest;
import org.example.socialmediabe.model.User;
import org.example.socialmediabe.repository.UserRepo;
import org.example.socialmediabe.utils.JwtUtil;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final JwtUtil jwtUtil;
    private final UserRepo userRepo;

    public AuthResponse register(RegisterRequest req) {
//        if -> to check wether user exists or not
        //if -> username exists or not

        //Dto -> Entity
        if (userRepo.findByEmail(req.getEmail()) != null) {
            throw new ValidationException("Email already exists");
        }
        if (userRepo.findByUsername(req.getUsername()) != null) {
            throw new ValidationException("Username already exists");
        }

        User newUser = new User();
        newUser.setEmail(req.getEmail());
        //username
        //fullName
        newUser.setUsername(req.getUsername());
        newUser.setFullName(req.getFullName());

        //save password
//        newUser.setPassword(req.getPassword()); //raw pass
        String hashPass = BCrypt.withDefaults().hashToString(12, req.getPassword().toCharArray());
        newUser.setPassword(hashPass);  //save hashPass

        userRepo.save(newUser);

        String token = jwtUtil.generateToken(req.getEmail());
        return new AuthResponse(token);
    }

    public AuthResponse login(LoginRequest req) {
        User user = userRepo.findByEmail(req.getEmail());
        if (user == null) {
            throw new ValidationException("Invalid email or password");
        }

        BCrypt.Result result = BCrypt.verifyer().verify(req.getPassword().toCharArray(), user.getPassword());
        if (!result.verified) {
            throw new ValidationException("Invalid email or password");
        }

        String token = jwtUtil.generateToken(user.getEmail());
        return new AuthResponse(token);
    }
}
