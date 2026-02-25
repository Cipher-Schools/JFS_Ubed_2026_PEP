package org.example.socialmediabe.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.socialmediabe.dto.CreatePostRequest;
import org.example.socialmediabe.model.Post;
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

    //createPost
    @PostMapping
    public ResponseEntity<Post> createPost(@RequestHeader("Authorization") String authHeader, @Valid @RequestBody CreatePostRequest post) {
        Post createdPost = postService.createPost(authHeader, post);
        // 201 Created - standard response when a new resource is successfully created
        return ResponseEntity.status(HttpStatus.CREATED).body(createdPost);
    }

    //getAllPost
    @GetMapping
    public ResponseEntity<List<Post>> getAllPosts() {
        List<Post> posts = postService.getAllPosts();
        return ResponseEntity.status(HttpStatus.OK).body(posts);
    }

    //getPostByUserId
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Post>> getPostsByUserId(@PathVariable Long userId) {
        List<Post> posts = postService.getPostByUserId(userId);
        return ResponseEntity.status(HttpStatus.OK).body(posts);
    }

    //getPostByID
    @GetMapping("/{id}")
    public ResponseEntity<Post> getPostById(@PathVariable Long id) {
        Post post = postService.getPostById(id);
        if (post == null) {
            // 404 Not Found - the post with this id does not exist
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(post);
    }

    //deletePost
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePost(@PathVariable Long id) {
        postService.deletePostById(id);
        // 204 No Content - delete was successful but there's nothing to return
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
