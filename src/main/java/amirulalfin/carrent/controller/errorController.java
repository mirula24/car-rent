package amirulalfin.carrent.controller;


import amirulalfin.carrent.utils.page.Res;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.UnexpectedTypeException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class errorController {
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<?> handleConstraintViolationException(ConstraintViolationException e) {
        return Res.renderJson(null, e.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UnexpectedTypeException.class)
    public ResponseEntity<?> handleUnexpectedType(UnexpectedTypeException e) {
        String message = e.getMessage();
        HttpStatus status = HttpStatus.BAD_REQUEST;

        if (e.getMessage().contains("brand_id")) {
            message = "this field cannot be blank";
        }
        return Res.renderJson(null,message, status);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<?> handleRunTime(RuntimeException e) {
        String message = e.getMessage();
        HttpStatus status = HttpStatus.BAD_REQUEST;

        if (e.getMessage().contains("User with id")) {
            message = "User not found";
        }
        return Res.renderJson(null, message, HttpStatus.BAD_REQUEST);
    }
}
