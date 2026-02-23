package org.example.socialmediabe.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.socialmediabe.model.Like;
import org.example.socialmediabe.service.LikeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/likes")
@RequiredArgsConstructor
public class LikeController {
    private final LikeService likeService;

    @PostMapping
    public ResponseEntity<Void> likePost(@Valid @RequestBody Like like) {
        likeService.likePost(like);
        // 201 Created - like was registered successfully
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> dislikePost(@PathVariable Long id) {
        likeService.dislikePost(id);
        // 204 No Content - unlike was successful but there's nothing to return
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
