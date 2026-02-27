package org.example.socialmediabe.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.socialmediabe.dto.CommentResponse;
import org.example.socialmediabe.dto.CreateCommentRequest;
import org.example.socialmediabe.exception.ForbiddenException;
import org.example.socialmediabe.exception.ResourceNotFoundException;
import org.example.socialmediabe.exception.UnauthorizedException;
import org.example.socialmediabe.model.Comment;
import org.example.socialmediabe.model.Post;
import org.example.socialmediabe.model.User;
import org.example.socialmediabe.repository.CommentRepo;
import org.example.socialmediabe.repository.PostRepo;
import org.example.socialmediabe.repository.UserRepo;
import org.example.socialmediabe.utils.JwtUtil;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepo commentRepo;
    private final PostRepo postRepo;
    private final UserRepo userRepo;
    private final JwtUtil jwtUtil;

    @Transactional
    public CommentResponse addComment(String authHeader, CreateCommentRequest request) {
        User currentUser = jwtUtil.extractUser(authHeader, "You need to authenticate before adding a comment");

        Post post = postRepo.findById(request.getPostId())
                .orElseThrow(() -> new ResourceNotFoundException("Post with id " + request.getPostId() + " does not exist"));

        Comment comment = new Comment();
        comment.setContent(request.getContent());
        comment.setPost(post);
        comment.setUser(currentUser);
        Comment savedComment = commentRepo.save(comment);
        
        return new CommentResponse(savedComment);
    }

    public List<CommentResponse> getCommentsByPostId(Long postId) {
        // Public endpoint — no auth needed
        if (postRepo.findById(postId).isEmpty()) {
            throw new ResourceNotFoundException("Post with id " + postId + " does not exist");
        }
        return commentRepo.findByPostId(postId).stream()
                .map(CommentResponse::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public void deleteComment(String authHeader, Long id) {
        User currentUser = jwtUtil.extractUser(authHeader, "You need to authenticate before deleting a comment");

        //if(comment exists)
        Comment comment = commentRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Comment with id " + id + " does not exist"));

        //if(comment belongs to current user)
        if (!comment.getUser().getId().equals(currentUser.getId())) {
            throw new ForbiddenException("You are not authorized to delete this comment");
        }

        commentRepo.deleteById(id);
    }
}
