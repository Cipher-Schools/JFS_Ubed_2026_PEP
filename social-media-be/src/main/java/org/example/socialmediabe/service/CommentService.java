package org.example.socialmediabe.service;

import jakarta.transaction.Transactional;
import jakarta.validation.ValidationException;
import lombok.RequiredArgsConstructor;
import org.example.socialmediabe.model.Comment;
import org.example.socialmediabe.repository.CommentRepo;
import org.example.socialmediabe.repository.PostRepo;
import org.example.socialmediabe.repository.UserRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepo commentRepo;
    private final PostRepo postRepo;
    private final UserRepo userRepo;

    public Comment addComment(Comment comment) {
        //if (post exists, user exists)
        if(comment.getPost() == null || comment.getPost().getId() == null) {
            throw new ValidationException("Post cannot be null");
        }
        if(postRepo.findById((long) comment.getPost().getId()).isEmpty()) {
            throw new ValidationException("Post does not exist");
        }
        if(comment.getUser() == null || comment.getUser().getId() == null) {
            throw new ValidationException("User cannot be null");
        }
        if(userRepo.findById(comment.getUser().getId()).isEmpty()) {
            throw new ValidationException("User does not exist");
        }
        return commentRepo.save(comment);
    }

    public List<Comment> getCommentsByPostId(Long postId) {
        return commentRepo.findByPostId(postId);
    }

    public void deleteComment(Long id) {
        //if(comment exists)
        if(commentRepo.findById(id).isEmpty()) {
            throw new ValidationException("Comment does not exist");
        }
        commentRepo.deleteById(id);
    }
}
