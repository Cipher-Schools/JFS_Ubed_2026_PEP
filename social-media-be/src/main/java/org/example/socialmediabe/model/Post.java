package org.example.socialmediabe.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor //constructor with no arguments line-19
@AllArgsConstructor //constructor with arguments line-21
@Table(name = "posts")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 1000, nullable = false)
    @NotBlank(message = "Caption cannot be blank")
    @Size(min = 1, max = 1000, message = "Caption must be between 1 and 1000 characters")
    private String caption;

    //image that you will actually post
    private String imageUrl;
//    public Post(){};

//    public Post(Integer id, String content, String postUrl){
//        this.id = id;
//        this.content = content;
//        this.postUrl = postUrl;
//    };

    //belongs to user
    @ManyToOne(fetch = FetchType.LAZY) // Many posts belong to one user; LAZY loading defers user data fetch
    @JoinColumn(name = "user_id", nullable = false) // Creates foreign key relationship
    @NotNull(message = "User cannot be null") // Validates relationship reference is not null
    private User user;

    //has comment
    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true) // One post has many comments; cascade deletes comments when post is deleted
    private List<Comment> comments = new ArrayList<>();

    //has likes
    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true) // One post has many likes; orphanRemoval deletes likes with no post reference
    private List<Like> likes = new ArrayList<>();
}
