package org.example.socialmediabe.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.socialmediabe.dto.ApiResponse;
import org.example.socialmediabe.dto.CreatePostRequest;
import org.example.socialmediabe.dto.PostResponse;
import org.example.socialmediabe.service.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    // CREATE POST — requires JWT token
    @PostMapping
    public ResponseEntity<ApiResponse<PostResponse>> createPost(
            @RequestHeader("Authorization") String authHeader,
            @Valid @RequestBody CreatePostRequest request) {
        // 201 Created - standard response when a new resource is successfully created
        PostResponse createdPost = postService.createPost(authHeader, request);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(ApiResponse.success("Post created successfully", createdPost));
    }

    // GET ALL POSTS — public, no auth required
    @GetMapping
    public ResponseEntity<ApiResponse<List<PostResponse>>> getAllPosts() {
        List<PostResponse> posts = postService.getAllPosts();
        return ResponseEntity.status(HttpStatus.OK)
                .body(ApiResponse.success("Posts fetched successfully", posts));
    }

    // GET POSTS BY USER ID — public, no auth required
    @GetMapping("/user/{userId}")
    public ResponseEntity<ApiResponse<List<PostResponse>>> getPostsByUserId(@PathVariable Long userId) {
        List<PostResponse> posts = postService.getPostByUserId(userId);
        return ResponseEntity.status(HttpStatus.OK)
                .body(ApiResponse.success("Posts fetched successfully", posts));
    }

    // GET POST BY ID — public, no auth required
    // If post doesn't exist → PostService throws ResourceNotFoundException → GlobalExceptionHandler returns 404
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<PostResponse>> getPostById(@PathVariable Long id) {
        // 200 OK - post found and returned
        // 404 Not Found - auto-handled if post doesn't exist (see PostService → GlobalExceptionHandler)
        PostResponse post = postService.getPostById(id);
        return ResponseEntity.status(HttpStatus.OK)
                .body(ApiResponse.success("Post fetched successfully", post));
    }

    // DELETE POST — requires JWT token + must be post owner
    // 401 Unauthorized - if no/invalid token
    // 403 Forbidden   - if token is valid but you don't own the post
    // 404 Not Found   - if post doesn't exist
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deletePost(
            @RequestHeader("Authorization") String authHeader,
            @PathVariable Long id) {
        postService.deletePostById(authHeader, id);
        // 200 OK - returning a success message body (not 204, which has no body)
        return ResponseEntity.status(HttpStatus.OK)
                .body(ApiResponse.success("Post deleted successfully"));
    }
}
