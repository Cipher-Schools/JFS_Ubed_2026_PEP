package org.example.socialmediabe.service;

import jakarta.validation.ValidationException;
import lombok.RequiredArgsConstructor;
import org.example.socialmediabe.dto.CreatePostRequest;
import org.example.socialmediabe.model.Post;
import org.example.socialmediabe.model.User;
import org.example.socialmediabe.repository.PostRepo;
import org.example.socialmediabe.repository.UserRepo;
import org.example.socialmediabe.utils.JwtUtil;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepo postRepo;
    private final UserRepo userRepo;
    private final JwtUtil jwtUtil;

    public Post createPost(String authHeader, CreatePostRequest request) {
        //if user exists
        if(authHeader == null || !authHeader.startsWith("Bearer")) {
            throw new ValidationException("Token is invalid");
        }

        //remove bearer word from token
        String token = authHeader.substring(7);
        String email = jwtUtil.verifyToken(token);

        //update use email to create post
        User currentUser = userRepo.findByEmail(email);

        if(currentUser == null) {
            throw new ValidationException("User doesn't exists");
        }

        Post post = new Post();
        post.setCaption(request.getCaption());
        post.setImageUrl(request.getImageUrl());
        post.setUser(currentUser);
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
