package org.example.socialmediabe.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "likes")
public class Like {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //users who liked
    @ManyToOne(fetch = FetchType.LAZY) // Multiple likes belong to one user
    @JoinColumn(name = "user_id", nullable = false) // Foreign key to users table
    @NotNull(message = "User cannot be null")
    private User user;

    //post id that was liked
    @ManyToOne(fetch = FetchType.LAZY) // Multiple likes belong to one post
    @JoinColumn(name = "post_id", nullable = false) // Foreign key to posts table
    @NotNull(message = "Post cannot be null")
    private Post post;
}
