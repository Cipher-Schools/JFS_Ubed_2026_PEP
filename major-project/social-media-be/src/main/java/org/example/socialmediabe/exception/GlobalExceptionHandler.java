package org.example.socialmediabe.exception;

import jakarta.validation.ValidationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ValidationException.class)//handle all validation exceptions
    public ResponseEntity<?> handleValidationException(ValidationException ex){
        ErrorResponse errorResponse = new ErrorResponse(ex.getMessage());

        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    };

    @ExceptionHandler(Exception.class) //for other exceptions
    public ResponseEntity<?> handleException(Exception ex) {
        ErrorResponse error = new ErrorResponse("Something went wrong. Please try again.");
        
        // Return 500 (Internal Server Error) status
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
