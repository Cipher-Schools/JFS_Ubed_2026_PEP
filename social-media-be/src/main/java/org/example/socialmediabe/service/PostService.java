package org.example.socialmediabe.service;

import lombok.RequiredArgsConstructor;
import org.example.socialmediabe.model.Post;
import org.example.socialmediabe.repository.PostRepo;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepo postRepo;

    public Post createPost(Post post) {
        return postRepo.save(post);
    }

    public List<Post> getAllPosts() {
        return postRepo.findAll();
    }

    public List<Post> getPostByUserId(Long userId) {
        return postRepo.findAllByUserId(userId);
    }

    public Post getPostById(long id) {
        return postRepo.findById(id).orElse(null);
    }

    public void deletePostById(long id) {
        postRepo.deleteById(id);
    }
}
