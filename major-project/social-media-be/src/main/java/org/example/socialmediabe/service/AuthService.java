package org.example.socialmediabe.service;

import at.favre.lib.crypto.bcrypt.BCrypt;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.socialmediabe.dto.AuthResponse;
import org.example.socialmediabe.dto.LoginRequest;
import org.example.socialmediabe.dto.RegisterRequest;
import org.example.socialmediabe.exception.UnauthorizedException;
import org.example.socialmediabe.model.User;
import org.example.socialmediabe.repository.UserRepo;
import org.example.socialmediabe.utils.JwtUtil;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final JwtUtil jwtUtil;
    private final UserRepo userRepo;

    @Transactional
    public AuthResponse register(RegisterRequest req) {
        // Check if the email or username is already registered in the database to avoid duplicates
        if (userRepo.findByEmail(req.getEmail()) != null) {
            throw new IllegalArgumentException("Email is already in use");
        }
        if (userRepo.findByUsername(req.getUsername()) != null) {
            throw new IllegalArgumentException("Username is already taken");
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
        // Fetch the user from the database by email
        User user = userRepo.findByEmail(req.getEmail());

        // Use 401 Unauthorized for wrong credentials — not 400 Bad Request
        // Note: same message for wrong email or wrong password — avoids user enumeration attacks
        if (user == null) {
            throw new UnauthorizedException("Invalid email or password");
        }

        BCrypt.Result result = BCrypt.verifyer().verify(req.getPassword().toCharArray(), user.getPassword());
        if (!result.verified) {
            throw new UnauthorizedException("Invalid email or password");
        }

        String token = jwtUtil.generateToken(user.getEmail());
        return new AuthResponse(token);
    }
}
