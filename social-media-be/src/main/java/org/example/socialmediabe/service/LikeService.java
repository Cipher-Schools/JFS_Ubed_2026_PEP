package org.example.socialmediabe.service;

import jakarta.validation.ValidationException;
import lombok.RequiredArgsConstructor;
import org.example.socialmediabe.model.Like;
import org.example.socialmediabe.repository.LikeRepo;
import org.example.socialmediabe.repository.PostRepo;
import org.example.socialmediabe.repository.UserRepo;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LikeService {

    private final LikeRepo likeRepo;
    private final PostRepo postRepo;
    private final UserRepo userRepo;

    public void likePost(Like like) {
        //if(posts exists, user exists)
        if(like.getPost() == null || like.getPost().getId() == null) {
            throw new ValidationException("Post cannot be null");
        }
        if(postRepo.findById((long) like.getPost().getId()).isEmpty()) {
            throw new ValidationException("Post does not exist");
        }
        if(like.getUser() == null || like.getUser().getId() == null) {
            throw new ValidationException("User cannot be null");
        }
        if(userRepo.findById(like.getUser().getId()).isEmpty()) {
            throw new ValidationException("User does not exist");
        }
        likeRepo.save(like);
    }

    public void dislikePost(Long id) {
        //if(posts exists, user exists, like exists)
        if(likeRepo.findById(id).isEmpty()) {
            throw new ValidationException("Like does not exist");
        }
        likeRepo.deleteById(id);
    }

}
