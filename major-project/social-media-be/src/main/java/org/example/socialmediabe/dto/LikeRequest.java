package org.example.socialmediabe.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class LikeRequest {

    @NotNull(message = "Post ID cannot be null")
    private Long postId;
}
