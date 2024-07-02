package amirulalfin.carrent.utils.page;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class Res {
    public static <T> ResponseEntity<?> renderJson(T data , String message, HttpStatus status){
        WebResponse<?> response = WebResponse.builder()
                .status(status.getReasonPhrase())
                .message(message)
                .data(data)
                .build();
        return ResponseEntity.status(status).body(response);
    }
}