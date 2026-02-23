package org.example.socialmediabe.service;

import lombok.RequiredArgsConstructor;
import org.example.socialmediabe.model.Like;
import org.example.socialmediabe.repository.LikeRepo;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LikeService {

    private final LikeRepo likeRepo;

    public void likePost(Like like) {
        likeRepo.save(like);
    }

    public void dislikePost(Long id) {
        likeRepo.deleteById(id);
    }

}
