package org.example.socialmediabe.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.socialmediabe.dto.CreatePostRequest;
import org.example.socialmediabe.dto.PostResponse;
import org.example.socialmediabe.exception.ForbiddenException;
import org.example.socialmediabe.exception.ResourceNotFoundException;
import org.example.socialmediabe.exception.UnauthorizedException;
import org.example.socialmediabe.model.Post;
import org.example.socialmediabe.model.User;
import org.example.socialmediabe.repository.PostRepo;
import org.example.socialmediabe.repository.UserRepo;
import org.example.socialmediabe.utils.JwtUtil;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepo postRepo;
    private final UserRepo userRepo;
    private final JwtUtil jwtUtil;

    @Transactional
    public PostResponse createPost(String authHeader, CreatePostRequest request) {
        User currentUser = jwtUtil.extractUser(authHeader, "You need to authenticate before creating a post");

        Post post = new Post();
        post.setCaption(request.getCaption());
        post.setImageUrl(request.getImageUrl());
        post.setUser(currentUser);
        Post savedPost = postRepo.save(post);
        return new PostResponse(savedPost);
    }

    public List<PostResponse> getAllPosts() {
        return postRepo.findAll().stream()
                .map(PostResponse::new)
                .collect(Collectors.toList());
    }

    public List<PostResponse> getPostByUserId(Long userId) {
        return postRepo.findAllByUserId(userId).stream()
                .map(PostResponse::new)
                .collect(Collectors.toList());
    }

    public PostResponse getPostById(long id) {
        //if post exists
        Post post = postRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Post with id " + id + " does not exist"));
        return new PostResponse(post);
    }

    @Transactional
    public void deletePostById(String authHeader, long id) {
        //if post exists
        User currentUser = jwtUtil.extractUser(authHeader, "You need to authenticate before deleting a post");

        Post post = postRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Post with id " + id + " does not exist"));

        // Only the post owner can delete it
        if (!post.getUser().getId().equals(currentUser.getId())) {
            throw new ForbiddenException("You are not authorized to delete this post");
        }

        postRepo.deleteById(id);
    }
}
