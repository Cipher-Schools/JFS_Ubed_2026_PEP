package org.example.socialmediabe.repository;

import org.example.socialmediabe.model.Like;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LikeRepo extends JpaRepository<Like, Long> {

    // Used to check if a user already liked a post before inserting a duplicate
    boolean existsByUserIdAndPostId(Long userId, Long postId);
}
