package org.example.socialmediabe.service;

import jakarta.validation.ValidationException;
import lombok.RequiredArgsConstructor;
import org.example.socialmediabe.model.Post;
import org.example.socialmediabe.repository.PostRepo;
import org.example.socialmediabe.repository.UserRepo;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepo postRepo;
    private final UserRepo userRepo;

    public Post createPost(Post post) {
        //if user exists
        if(post.getUser() == null || post.getUser().getId() == null) {
            throw new ValidationException("User cannot be null");
        }
        if(userRepo.findById(post.getUser().getId()).isEmpty()) {
            throw new ValidationException("User does not exist");
        }
        return postRepo.save(post);
    }

    public List<Post> getAllPosts() {
        return postRepo.findAll();
    }

    public List<Post> getPostByUserId(Long userId) {
        return postRepo.findAllByUserId(userId);
    }

    public Post getPostById(long id) {
        //if post exists
        return postRepo.findById(id).orElse(null);
    }

    public void deletePostById(long id) {
        //if post exists
        if(postRepo.findById(id).isEmpty()) {
            throw new ValidationException("Post does not exist");
        }
        postRepo.deleteById(id);
    }
}
