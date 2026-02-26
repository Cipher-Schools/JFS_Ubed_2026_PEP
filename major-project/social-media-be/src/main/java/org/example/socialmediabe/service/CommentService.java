package org.example.socialmediabe.service;

import jakarta.transaction.Transactional;
import jakarta.validation.ValidationException;
import lombok.RequiredArgsConstructor;
import org.example.socialmediabe.model.Comment;
import org.example.socialmediabe.model.User;
import org.example.socialmediabe.repository.CommentRepo;
import org.example.socialmediabe.repository.PostRepo;
import org.example.socialmediabe.repository.UserRepo;
import org.example.socialmediabe.utils.JwtUtil;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepo commentRepo;
    private final PostRepo postRepo;
    private final UserRepo userRepo;
    private final JwtUtil jwtUtil;

    public Comment addComment(String authHeader, Comment comment) {
        User currentUser = extractUser(authHeader);
        //if (post exists, user exists)
        if (comment.getPost() == null || comment.getPost().getId() == null) {
            throw new ValidationException("Post cannot be null");
        }
        if (postRepo.findById((long) comment.getPost().getId()).isEmpty()) {
            throw new ValidationException("Post does not exist");
        }

        comment.setUser(currentUser);
        return commentRepo.save(comment);
    }

    public List<Comment> getCommentsByPostId(Long postId) {
        return commentRepo.findByPostId(postId);
    }

    public void deleteComment(String authHeader, Long id) {
        User currentUser = extractUser(authHeader);

        //if(comment exists)
        Comment comment = commentRepo.findById(id)
                .orElseThrow(() -> new ValidationException("Comment does not exist"));

        //if(comment belongs to current user)
        if (!comment.getUser().getId().equals(currentUser.getId())) {
            throw new ValidationException("You are not authorized to delete this comment");
        }

        commentRepo.deleteById(id);
    }

    private User extractUser(String authHeader) {
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            throw new ValidationException("Token is invalid");
        }
        String token = authHeader.substring(7);
        String email = jwtUtil.verifyToken(token);
        User user = userRepo.findByEmail(email);
        if (user == null) {
            throw new ValidationException("User doesn't exist");
        }
        return user;
    }
}
