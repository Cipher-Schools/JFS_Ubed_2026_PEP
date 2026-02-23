package org.example.socialmediabe.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.socialmediabe.model.Comment;
import org.example.socialmediabe.repository.CommentRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepo commentRepo;

    public Comment addComment(Comment comment) {
        return commentRepo.save(comment);
    }

    public List<Comment> getCommentsByPostId(Long postId) {
        return commentRepo.findByPostId(postId);
    }

    public void deleteComment(Long id) {
        commentRepo.deleteById(id);
    }
}
