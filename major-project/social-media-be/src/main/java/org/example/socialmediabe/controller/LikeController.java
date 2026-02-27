package org.example.socialmediabe.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.socialmediabe.dto.ApiResponse;
import org.example.socialmediabe.dto.LikeRequest;
import org.example.socialmediabe.service.LikeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/likes")
@RequiredArgsConstructor
public class LikeController {

    private final LikeService likeService;

    // LIKE A POST — requires JWT token
    @PostMapping
    public ResponseEntity<ApiResponse<Void>> likePost(
            @RequestHeader("Authorization") String authHeader,
            @Valid @RequestBody LikeRequest request) {
        likeService.likePost(authHeader, request);
        // 201 Created - like was registered successfully
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(ApiResponse.success("Post liked successfully"));
    }

    // UNLIKE / REMOVE LIKE — requires JWT token + must be like owner
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> dislikePost(
            @RequestHeader("Authorization") String authHeader,
            @PathVariable Long id) {
        likeService.dislikePost(authHeader, id);
         // 204 No Content - unlike was successful but there's nothing to return
        return ResponseEntity.status(HttpStatus.OK)
                .body(ApiResponse.success("Like removed successfully"));
    }
}
