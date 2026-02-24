package org.example.socialmediabe.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "comments")
public class Comment {
    //id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 1000, nullable = false) //db level
    @NotBlank(message = "Comment content cannot be blank") //java level
    @Size(min = 1, max = 1000, message = "Comment must be between 1 and 1000 characters")
    private String content;
    //comment -> content

    @ManyToOne(fetch = FetchType.LAZY) // Multiple comments belong to one user
    //don't load user data immediately when I fetch comment
    //only load when I explicitly ask for if
    @JoinColumn(name = "user_id", nullable = false) // Foreign key to users table
    @NotNull(message = "User cannot be null")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY) // Multiple comments belong to one post
    @JoinColumn(name = "post_id", nullable = false) // Foreign key to posts table
    @NotNull(message = "Post cannot be null")
    private Post post;
}
