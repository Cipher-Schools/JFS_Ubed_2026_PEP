package org.example.socialmediabe.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreatePostRequest {

    @NotBlank(message = "Caption cant be empty")
    private String caption;
    private String imageUrl;

}
