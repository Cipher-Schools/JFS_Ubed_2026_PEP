package org.example.socialmediabe.controller;

import lombok.RequiredArgsConstructor;
import org.example.socialmediabe.dto.AuthResponse;
import org.example.socialmediabe.dto.LoginRequest;
import org.example.socialmediabe.dto.RegisterRequest;
import org.example.socialmediabe.service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthControl {

    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(@RequestBody RegisterRequest req){
        return ResponseEntity.ok(authService.register(req));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest req){
        return ResponseEntity.ok(authService.login(req));
    }
}
