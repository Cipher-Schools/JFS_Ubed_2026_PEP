package org.example.socialmediabe.repository;

import org.example.socialmediabe.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
    User findByEmail(String email);
    //select * from user where email = email

    User findByUsername(String username);
}
