package org.example.socialmediabe.service;

import jakarta.validation.ValidationException;
import lombok.RequiredArgsConstructor;
import org.example.socialmediabe.model.Like;
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

    public void likePost(String authHeader, Like like) {
        User currentUser = extractUser(authHeader);

        if (like.getPost() == null || like.getPost().getId() == null) {
            throw new ValidationException("Post cannot be null");
        }
        if (postRepo.findById((long) like.getPost().getId()).isEmpty()) {
            throw new ValidationException("Post does not exist");
        }

        like.setUser(currentUser);
        likeRepo.save(like);
    }

    public void dislikePost(String authHeader, Long id) {
        User currentUser = extractUser(authHeader);

        //if(like exists)
        Like like = likeRepo.findById(id)
                .orElseThrow(() -> new ValidationException("Like does not exist"));

        //if(like belongs to current user)
        if (!like.getUser().getId().equals(currentUser.getId())) {
            throw new ValidationException("You are not authorized to remove this like");
        }

        likeRepo.deleteById(id);
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
