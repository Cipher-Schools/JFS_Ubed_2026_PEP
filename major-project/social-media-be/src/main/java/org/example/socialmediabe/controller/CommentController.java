package org.example.socialmediabe.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.socialmediabe.dto.ApiResponse;
import org.example.socialmediabe.dto.CommentResponse;
import org.example.socialmediabe.dto.CreateCommentRequest;
import org.example.socialmediabe.service.CommentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comments")
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    // ADD COMMENT — requires JWT token
    @PostMapping
    public ResponseEntity<ApiResponse<CommentResponse>> addComment(
            @RequestHeader("Authorization") String authHeader,
            @Valid @RequestBody CreateCommentRequest request) {
        CommentResponse savedComment = commentService.addComment(authHeader, request);
        // 201 Created - new comment was successfully added
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(ApiResponse.success("Comment added successfully", savedComment));
    }

    // GET COMMENTS BY POST ID — public, no auth required
    @GetMapping("/post/{postId}")
    public ResponseEntity<ApiResponse<List<CommentResponse>>> getCommentsByPostId(@PathVariable Long postId) {
        List<CommentResponse> comments = commentService.getCommentsByPostId(postId);
        return ResponseEntity.status(HttpStatus.OK)
                .body(ApiResponse.success("Comments fetched successfully", comments));
    }

    // DELETE COMMENT — requires JWT token + must be comment owner
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteComment(
            @RequestHeader("Authorization") String authHeader,
            @PathVariable Long id) {
        commentService.deleteComment(authHeader, id);
        // 204 No Content - delete was successful but there's nothing to return
        return ResponseEntity.status(HttpStatus.OK)
                .body(ApiResponse.success("Comment deleted successfully"));
    }
}
