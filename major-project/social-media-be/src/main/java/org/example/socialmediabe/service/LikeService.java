package org.example.socialmediabe.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.socialmediabe.dto.LikeRequest;
import org.example.socialmediabe.exception.ForbiddenException;
import org.example.socialmediabe.exception.ResourceNotFoundException;
import org.example.socialmediabe.exception.UnauthorizedException;
import org.example.socialmediabe.model.Like;
import org.example.socialmediabe.model.Post;
import org.example.socialmediabe.model.User;
import org.example.socialmediabe.repository.LikeRepo;
import org.example.socialmediabe.repository.PostRepo;
import org.example.socialmediabe.repository.UserRepo;
import org.example.socialmediabe.utils.JwtUtil;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LikeService {

    private final LikeRepo likeRepo;
    private final PostRepo postRepo;
    private final UserRepo userRepo;
    private final JwtUtil jwtUtil;

    @Transactional
    public void likePost(String authHeader, LikeRequest request) {
        User currentUser = jwtUtil.extractUser(authHeader, "You need to authenticate before liking a post");

        Post post = postRepo.findById(request.getPostId())
                .orElseThrow(() -> new ResourceNotFoundException("Post with id " + request.getPostId() + " does not exist"));

        if (likeRepo.existsByUserIdAndPostId(currentUser.getId(), post.getId())) {
            throw new IllegalArgumentException("You have already liked this post");
        }

        Like like = new Like();
        like.setUser(currentUser);
        like.setPost(post);
        likeRepo.save(like);
    }

    @Transactional
    public void dislikePost(String authHeader, Long id) {
        User currentUser = jwtUtil.extractUser(authHeader, "You need to authenticate before removing a like");

        //if(like exists)
        Like like = likeRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Like with id " + id + " does not exist"));

        //if(like belongs to current user)
        if (!like.getUser().getId().equals(currentUser.getId())) {
            throw new ForbiddenException("You are not authorized to remove this like");
        }

        likeRepo.deleteById(id);
    }
}
