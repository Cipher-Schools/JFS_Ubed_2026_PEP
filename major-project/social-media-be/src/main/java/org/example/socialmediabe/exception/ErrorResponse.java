package org.example.socialmediabe.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorResponse {
    String error;
    //status code
    //error type

    public ErrorResponse(String error){
        this.error = error;
    }
}
