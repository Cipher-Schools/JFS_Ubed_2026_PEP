package org.example.socialmediabe.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.socialmediabe.model.Post;

import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostResponse {
    private Long id;
    private String caption;
    private String imageUrl;
    private UserResponse user;
    private List<CommentResponse> comments;
    private List<UserResponse> likedBy;
    private int likesCount;

    public PostResponse(Post post) {
        this.id = post.getId();
        this.caption = post.getCaption();
        this.imageUrl = post.getImageUrl();
        this.user = new UserResponse(post.getUser());
        this.comments = post.getComments().stream()
                .map(CommentResponse::new)
                .collect(Collectors.toList());
        this.likedBy = post.getLikes().stream()
                .map(like -> new UserResponse(like.getUser()))
                .collect(Collectors.toList());
        this.likesCount = post.getLikes().size();
    }
}
